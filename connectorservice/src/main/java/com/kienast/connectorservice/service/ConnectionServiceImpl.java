package com.kienast.connectorservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jcraft.jsch.Session;
import com.kienast.connectorservice.command.CreateConnectionCommand;
import com.kienast.connectorservice.command.DestroyConnectionCommand;
import com.kienast.connectorservice.command.ShellCommand;
import com.kienast.connectorservice.model.Connection;
import com.kienast.connectorservice.model.ConnectionStatus;
import com.kienast.connectorservice.model.ConnectionStore;
import com.kienast.connectorservice.repository.ConnectionRepository;
import com.kienast.connectorservice.repository.ConnectionStoreRepository;
import com.kienast.connectorservice.usecase.CreateConnection;
import com.kienast.connectorservice.usecase.DestroyConnection;
import com.kienast.connectorservice.usecase.GetActiveConnections;
import com.kienast.connectorservice.usecase.GetStoredConnections;
import com.kienast.connectorservice.usecase.ShellCommandUseCase;

@Component
public class ConnectionServiceImpl implements ConnectionService {

	@Autowired
	private ConnectionRepository connectionRepository;
	
	@Override
	public ConnectionStatus createConnection(CreateConnectionCommand command) {
		return new CreateConnection(connectionRepository, command).createConnection();
	}
	
	@Override
	public List<Connection> getActiveConnections() {
		return new GetActiveConnections(connectionRepository).getConnections();
	}

	@Override
	public ConnectionStatus destroyConnection(DestroyConnectionCommand command) {
		return new DestroyConnection(connectionRepository, command).destroyConnection();
	}
	
	@Override
	public String addCommand(ShellCommand command) {
		return new ShellCommandUseCase(connectionRepository, command).addCommand();
	}

}
