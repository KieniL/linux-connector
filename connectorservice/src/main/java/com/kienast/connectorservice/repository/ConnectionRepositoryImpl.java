package com.kienast.connectorservice.repository;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.kienast.connectorservice.command.DestroyConnectionCommand;
import com.kienast.connectorservice.command.ShellCommand;
import com.kienast.connectorservice.exception.ConnectionStoreNotFoundException;
import com.kienast.connectorservice.model.Connection;
import com.kienast.connectorservice.model.ConnectionRequest;
import com.kienast.connectorservice.model.ConnectionStatus;
import com.kienast.connectorservice.model.ConnectionStore;
import com.kienast.connectorservice.model.ConnectionStoreEntity;
import com.kienast.connectorservice.util.PasswordCheck;

@Component
public class ConnectionRepositoryImpl implements ConnectionRepository {
	
	@Autowired
	private ConnectionStoreRepository connectionStoreRepository;
	
	List<Connection> connections = new ArrayList<Connection>();
	List<Session> sessions = new ArrayList<Session>();

	@Override
	public ConnectionStatus save(ConnectionRequest connectionRequest) {
        int status = 200;
		try {
			
			
			ConnectionStoreEntity entity = null;
			try {
				entity = connectionStoreRepository.findById(Long.valueOf(connectionRequest.getStoreId())).get();
			}catch(java.util.NoSuchElementException e) {
				System.out.println(e.getMessage());
				throw(new ConnectionStoreNotFoundException(connectionRequest.getStoreId()));
			}
			
			//Get password from request and compare with stored hash
			if(PasswordCheck.checkPass(connectionRequest.getPassword(), entity.getPassword())) {
				System.out.println("entity" + entity.getSshkey());
				
				ConnectionStore store = new ConnectionStore(entity.getHostname(), entity.getPort(),
						entity.getUsername(), connectionRequest.getPassword(), entity.getSshkey());
				
				Session session;
				JSch jsch = new JSch();
				jsch.setKnownHosts(new ByteArrayInputStream( entity.getSshkey().getBytes()));
				//jsch.setKnownHosts(System.getProperty("user.home")+"/.ssh/known_hosts");

				session = jsch.getSession(store.getUsername(), store.getHostname(), store.getPort());
				session.setPassword(store.getPassword());
				session.connect(3000);
				

				store.setId(String.valueOf(connections.size() + 1));
				connections.add(new Connection(store.getId(),
						store.getHostname(),
						store.getPort(),
						store.getUsername(),
						store.getPassword(),
						session.toString()));
				
				sessions.add(session);
			}else {
				return new ConnectionStatus(500);
			}

		} catch (Exception e) {
			System.err.println("Error: " + e);
			return new ConnectionStatus(500);
		}
		
		return new ConnectionStatus(status);
	}

	@Override
	public ConnectionStatus delete(DestroyConnectionCommand command) {
		Session session = null;
		Connection connection = null;
		
		Connection conn = null;
		
		try {
			conn = findByString(command.getStoreId()).get();
		}catch(java.util.NoSuchElementException e) {
			System.out.println(e.getMessage());
			return new ConnectionStatus(500);
		}
		
		for(Session s : sessions) {
			if(s.toString().equals(conn.getSession())) {
				session = s;
			}
		}
		
		session.disconnect();
		
		sessions.remove(session);
		
		
		for(Connection c : connections) {
			if(c.getSession().equals(conn.getSession())) {
				connection = c;
			}
		}
		
		connections.remove(connection);
		
		return new ConnectionStatus(200);
	}

	@Override
	public List<Connection> getConnections() {
		return connections;
	}

	@Override
	public String addCommand(ShellCommand command) {
		
		String response = "";
		Session session = null;
		
		Connection connection = null;
		
		try {
			connection = findByString(command.getStoreId()).get();
		}catch(java.util.NoSuchElementException e) {
			System.out.println(e.getMessage());
			return null;
		}
		
		
		for(Session s : sessions) {
			if(s.toString().equals(connection.getSession())) {
				session = s;
			}
		}
		
		ChannelExec channelExec = null;
		try {
			channelExec = (ChannelExec) session.openChannel("exec");
			InputStream in = channelExec.getInputStream();
			channelExec.setCommand(command.getCommand());
			channelExec.connect();

			
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			String line;

			while ((line = reader.readLine()) != null) {
				response += line + "\n";
			}

			int exitStatus = channelExec.getExitStatus();
			if (exitStatus < 0) {
				response += "Done, but exit status not set!\n";
			} else if (exitStatus > 0) {
				response += "Done, but with error!\n";
			} else {
				response += "Done!\n";
			}
			
		} catch (JSchException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		channelExec.disconnect();
		return response;
	}
	
	private Optional<Connection> findByString(String storeId) {
		return connections.stream().filter(item -> item.getId().equals(storeId)).findFirst();
	}

}
