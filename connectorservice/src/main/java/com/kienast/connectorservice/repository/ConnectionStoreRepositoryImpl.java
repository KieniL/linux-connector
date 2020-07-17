package com.kienast.connectorservice.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.kienast.connectorservice.command.DestroyConnectionStoreCommand;
import com.kienast.connectorservice.command.UpdateConnectionStoreCommand;
import com.kienast.connectorservice.model.ConnectionStatus;
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
		connStore.setId(String.valueOf(connections.size()+1));
		connections.add(connStore);
		return new ConnectionStoreStatus(200);
	}

	@Override
	public ConnectionStoreStatus update(UpdateConnectionStoreCommand command) {
		
		ConnectionStore store = null;
		try {
			store = findByString(command.getStoreId()).get();
		}catch(java.util.NoSuchElementException e) {
			System.out.println(e.getMessage());
			return new ConnectionStoreStatus(500);
		}
		
		
		store.setHostname(command.getHostname());
		store.setPassword(command.getPassword());
		store.setPort(command.getPort());
		store.setUsername(command.getUsername());
		
		return new ConnectionStoreStatus(200);
	}

	@Override
	public ConnectionStoreStatus delete(DestroyConnectionStoreCommand command) {
		ConnectionStore store = null;
		
		try {
			store = findByString(command.getStoreId()).get();
		}catch(java.util.NoSuchElementException e) {
			System.out.println(e.getMessage());
			return new ConnectionStoreStatus(500);
		}
		
		connections.remove(store);
		
		return new ConnectionStoreStatus(200);
	}


	@Override
	public Optional<ConnectionStore> findByString(String storeId) {
		return connections.stream().filter(item -> item.getId().equals(storeId)).findFirst();
	}

}
