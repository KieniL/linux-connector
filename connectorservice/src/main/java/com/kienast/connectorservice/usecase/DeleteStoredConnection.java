package com.kienast.connectorservice.usecase;

import com.kienast.connectorservice.command.DestroyConnectionStoreCommand;
import com.kienast.connectorservice.model.ConnectionStoreStatus;
import com.kienast.connectorservice.repository.ConnectionStoreRepository;

public class DeleteStoredConnection {
	private ConnectionStoreRepository connectionStoreRepository;
	private DestroyConnectionStoreCommand command;

	public DeleteStoredConnection(ConnectionStoreRepository connectionStoreRepository, DestroyConnectionStoreCommand command) {
		this.connectionStoreRepository = connectionStoreRepository;
		this.command = command;
	}

	public ConnectionStoreStatus destroyConnection() {
		return connectionStoreRepository.delete(command);
	}
}
