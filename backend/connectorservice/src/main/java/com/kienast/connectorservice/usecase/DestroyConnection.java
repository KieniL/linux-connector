package com.kienast.connectorservice.usecase;

import com.kienast.connectorservice.command.DestroyConnectionCommand;
import com.kienast.connectorservice.model.ConnectionStatus;
import com.kienast.connectorservice.repository.ConnectionRepository;

public class DestroyConnection {

	private ConnectionRepository connectionRepository;
	private DestroyConnectionCommand command;

	public DestroyConnection(ConnectionRepository connectionRepository, DestroyConnectionCommand command) {
		this.connectionRepository = connectionRepository;
		this.command = command;
	}

	public ConnectionStatus destroyConnection() {
		return connectionRepository.delete(command);
	}
}
