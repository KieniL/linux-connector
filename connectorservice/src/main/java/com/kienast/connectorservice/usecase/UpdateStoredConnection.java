package com.kienast.connectorservice.usecase;

import com.kienast.connectorservice.command.UpdateConnectionStoreCommand;
import com.kienast.connectorservice.model.ConnectionStoreStatus;
import com.kienast.connectorservice.repository.ConnectionStoreRepository;

public class UpdateStoredConnection {
	private ConnectionStoreRepository connectionStoreRepository;
	private UpdateConnectionStoreCommand command;

	public UpdateStoredConnection(ConnectionStoreRepository connectionStoreRepository, UpdateConnectionStoreCommand command) {
		this.connectionStoreRepository = connectionStoreRepository;
		this.command = command;
	}

	public ConnectionStoreStatus updateConnection() {
		return connectionStoreRepository.update(command);
	}
}
