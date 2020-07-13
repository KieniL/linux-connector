package com.kienast.connectorservice.repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.kienast.connectorservice.command.DestroyConnectionCommand;
import com.kienast.connectorservice.command.ShellCommand;
import com.kienast.connectorservice.model.Connection;
import com.kienast.connectorservice.model.ConnectionStatus;
import com.kienast.connectorservice.model.ConnectionStore;

@Component
public class ConnectionRepositoryImpl implements ConnectionRepository {
	
	List<Connection> connections = new ArrayList<Connection>();
	List<Session> sessions = new ArrayList<Session>();

	@Override
	public ConnectionStatus save(Connection connection) {
        int status = 200;
		try {
			Session session;
			JSch jsch = new JSch();
			jsch.setKnownHosts(System.getProperty("user.home")+"/.ssh/known_hosts");

			session = jsch.getSession(connection.getUsername(), connection.getHostname(), connection.getPort());
			session.setPassword(connection.getPassword());
			session.connect(3000);
			

			
			connections.add(new Connection(connection.getHostname(),
					connection.getPort(),
					connection.getUsername(),
					connection.getPassword(),
					session.toString()));
			
			sessions.add(session);
			
			
		} catch (Exception e) {
			System.err.println("Error: " + e);
		}
		
		return new ConnectionStatus(status);
	}

	@Override
	public ConnectionStatus delete(DestroyConnectionCommand command) {
		Session session = null;
		Connection connection = null;
		
		for(Session s : sessions) {
			if(s.toString().equals(command.getSession())) {
				session = s;
			}
		}
		
		session.disconnect();
		
		sessions.remove(session);
		
		
		for(Connection c : connections) {
			if(c.getSession().equals(command.getSession())) {
				connection = c;
			}
		}
		
		connections.remove(connection);
		
		return new ConnectionStatus(200);
	}

	@Override
	public List<Connection> getActiveConnections() {
		return connections;
	}

	@Override
	public String addCommand(ShellCommand command) {
		
		String response = "";
		Session session = null;
		
		for(Session s : sessions) {
			if(s.toString().equals(command.getSession())) {
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

}
