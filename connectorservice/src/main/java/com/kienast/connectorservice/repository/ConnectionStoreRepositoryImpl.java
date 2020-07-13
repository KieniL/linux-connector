package com.kienast.connectorservice.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import com.kienast.connectorservice.command.DestroyConnectionStoreCommand;
import com.kienast.connectorservice.command.UpdateConnectionStoreCommand;
import com.kienast.connectorservice.model.ConnectionStore;
import com.kienast.connectorservice.model.ConnectionStoreStatus;

@Component
public class ConnectionStoreRepositoryImpl implements ConnectionStoreRepository {

	List<ConnectionStore> connections = new ArrayList<ConnectionStore>();
	
	@Override
	public List<ConnectionStore> getConnections() {
		return connections;
	}

	@Override
	public ConnectionStoreStatus save(ConnectionStore connStore) {
		connections.add(connStore);
		return new ConnectionStoreStatus(200);
	}

	@Override
	public ConnectionStoreStatus update(UpdateConnectionStoreCommand command) {
		ConnectionStore store = connections.get(command.getStoreId());
		
		store.setHostname(command.getHostname());
		store.setPassword(command.getPassword());
		store.setPort(command.getPort());
		store.setUsername(command.getUsername());
		
		return new ConnectionStoreStatus(200);
	}

	@Override
	public ConnectionStoreStatus delete(DestroyConnectionStoreCommand command) {
		ConnectionStore store = null;
		for (ConnectionStore c : connections) {
			if(c.getHostname().equals(command.getHostname()) && 
					c.getPassword().equals(command.getPassword()) &&
					c.getPort() == command.getPort() &&
					c.getUsername().equals(command.getUsername())) {
				store = c;
			}
		}
		
		connections.remove(store);
		
		return new ConnectionStoreStatus(200);
	}

	@Override
	public ConnectionStore findByString(int storeId) {
		return connections.get(storeId);
	}

}
