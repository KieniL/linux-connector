package com.kienast.connectorservice.service;

import java.util.List;

import com.kienast.connectorservice.model.ConnectionStatus;
import com.kienast.connectorservice.model.ConnectionStore;


public interface ConnectionService {

	ConnectionStatus createConnection();
	
	ConnectionStatus destroyConnection();
	
	List<ConnectionStore> getActiveConnections();
	
	List<ConnectionStore> getStoredConnections();
	
	ConnectionStore addStoredConnection(ConnectionStore connStore);
	
	ConnectionStore updateStoredConnection(ConnectionStore connStore);
	
	boolean deleteStoredConnection(ConnectionStore connStore); 
	
	
}
