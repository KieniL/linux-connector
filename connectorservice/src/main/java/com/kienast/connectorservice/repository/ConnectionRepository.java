package com.kienast.connectorservice.repository;

import java.util.List;

import com.jcraft.jsch.Session;
import com.kienast.connectorservice.command.DestroyConnectionCommand;
import com.kienast.connectorservice.command.ShellCommand;
import com.kienast.connectorservice.model.Connection;
import com.kienast.connectorservice.model.ConnectionStatus;
import com.kienast.connectorservice.model.ConnectionStore;


public interface ConnectionRepository {
	
	ConnectionStatus save(Connection connection);
	
	ConnectionStatus delete(DestroyConnectionCommand command);
	
	List<Connection> getActiveConnections();
	
	String addCommand(ShellCommand command);

}
