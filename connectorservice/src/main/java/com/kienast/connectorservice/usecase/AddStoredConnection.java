package com.kienast.connectorservice.usecase;

import com.kienast.connectorservice.command.CreateConnectionStoreCommand;
import com.kienast.connectorservice.dto.ConnectionStoreFactory;
import com.kienast.connectorservice.model.ConnectionStore;
import com.kienast.connectorservice.model.ConnectionStoreStatus;
import com.kienast.connectorservice.repository.ConnectionStoreRepository;

public class AddStoredConnection {
	private ConnectionStoreRepository connectionStoreRepository;
	private CreateConnectionStoreCommand command;

	public AddStoredConnection(ConnectionStoreRepository connectionStoreRepository, CreateConnectionStoreCommand command) {
		this.connectionStoreRepository = connectionStoreRepository;
		this.command = command;
	}

	public ConnectionStoreStatus addConnection() {
		ConnectionStore connectionStore = ConnectionStoreFactory.createNew(command);
		return connectionStoreRepository.save(connectionStore);
	}
}
