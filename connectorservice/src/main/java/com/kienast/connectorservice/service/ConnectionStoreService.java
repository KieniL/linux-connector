package com.kienast.connectorservice.service;

import java.util.List;

import com.jcraft.jsch.Session;
import com.kienast.connectorservice.command.CreateConnectionCommand;
import com.kienast.connectorservice.command.CreateConnectionStoreCommand;
import com.kienast.connectorservice.command.DestroyConnectionCommand;
import com.kienast.connectorservice.command.DestroyConnectionStoreCommand;
import com.kienast.connectorservice.command.ShellCommand;
import com.kienast.connectorservice.command.UpdateConnectionStoreCommand;
import com.kienast.connectorservice.model.Connection;
import com.kienast.connectorservice.model.ConnectionStatus;
import com.kienast.connectorservice.model.ConnectionStore;
import com.kienast.connectorservice.model.ConnectionStoreStatus;


public interface ConnectionStoreService {

	List<ConnectionStore> getStoredConnections();
	
	ConnectionStoreStatus addStoredConnection(CreateConnectionStoreCommand command);
	
	ConnectionStoreStatus updateStoredConnection(UpdateConnectionStoreCommand command);
	
	ConnectionStoreStatus deleteStoredConnection(DestroyConnectionStoreCommand command); 
	
	
}
