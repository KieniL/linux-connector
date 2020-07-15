package com.kienast.connectorservice.usecase;

import com.kienast.connectorservice.command.CreateConnectionCommand;
import com.kienast.connectorservice.dto.ConnectionFactory;
import com.kienast.connectorservice.model.Connection;
import com.kienast.connectorservice.model.ConnectionRequest;
import com.kienast.connectorservice.model.ConnectionStatus;
import com.kienast.connectorservice.repository.ConnectionRepository;

public class CreateConnection {

	private ConnectionRepository connectionRepository;
	private CreateConnectionCommand command;

	public CreateConnection(ConnectionRepository connectionRepository, CreateConnectionCommand command) {
		this.connectionRepository = connectionRepository;
		this.command = command;
	}

	public ConnectionStatus createConnection() {
		ConnectionRequest connectionRequest = ConnectionFactory.createNew(command);
		return connectionRepository.save(connectionRequest);
	}
}
