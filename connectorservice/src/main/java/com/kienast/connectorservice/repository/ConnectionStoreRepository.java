package com.kienast.connectorservice.repository;

import java.util.List;

import com.kienast.connectorservice.model.ConnectionStore;

public interface ConnectionStoreRepository {

	List<ConnectionStore> getStoredConnections();
	
	ConnectionStore save(ConnectionStore connStore);
	
	ConnectionStore update(ConnectionStore connStore);
	
	boolean delete(ConnectionStore connStore); 
}
