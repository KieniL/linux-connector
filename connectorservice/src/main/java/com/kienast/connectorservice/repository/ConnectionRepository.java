package com.kienast.connectorservice.repository;

import java.util.List;

import com.kienast.connectorservice.command.DestroyConnectionCommand;
import com.kienast.connectorservice.command.ShellCommand;
import com.kienast.connectorservice.model.Connection;
import com.kienast.connectorservice.model.ConnectionRequest;
import com.kienast.connectorservice.model.ConnectionStatus;


public interface ConnectionRepository {
	
	ConnectionStatus save(ConnectionRequest connectionRequest);
	
	ConnectionStatus delete(DestroyConnectionCommand command);
	
	List<Connection> getConnections();
	
	String addCommand(ShellCommand command);

}
