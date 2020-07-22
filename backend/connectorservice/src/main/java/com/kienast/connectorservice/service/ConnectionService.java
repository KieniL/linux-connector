package com.kienast.connectorservice.service;

import java.util.List;

import com.kienast.connectorservice.command.CreateConnectionCommand;
import com.kienast.connectorservice.command.DestroyConnectionCommand;
import com.kienast.connectorservice.command.ShellCommand;
import com.kienast.connectorservice.model.Connection;
import com.kienast.connectorservice.model.ConnectionStatus;



public interface ConnectionService {

	ConnectionStatus createConnection(CreateConnectionCommand command);
	
	ConnectionStatus destroyConnection(DestroyConnectionCommand command);
	
	List<Connection> getActiveConnections();
	
	String addCommand(ShellCommand command);
	

}
