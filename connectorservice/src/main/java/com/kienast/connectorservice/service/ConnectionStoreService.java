package com.kienast.connectorservice.service;

import java.util.List;

import com.kienast.connectorservice.command.CreateConnectionStoreCommand;
import com.kienast.connectorservice.command.DestroyConnectionStoreCommand;
import com.kienast.connectorservice.command.UpdateConnectionStoreCommand;
import com.kienast.connectorservice.model.ConnectionStore;
import com.kienast.connectorservice.model.ConnectionStoreStatus;


public interface ConnectionStoreService {

	List<ConnectionStore> getStoredConnections();
	
	ConnectionStoreStatus addStoredConnection(CreateConnectionStoreCommand command);
	
	ConnectionStoreStatus updateStoredConnection(UpdateConnectionStoreCommand command);
	
	ConnectionStoreStatus deleteStoredConnection(DestroyConnectionStoreCommand command); 
	
	
}
