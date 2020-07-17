package com.kienast.connectorservice.dto;

import com.kienast.connectorservice.command.CreateConnectionStoreCommand;
import com.kienast.connectorservice.model.ConnectionStore;

public final class ConnectionStoreFactory {

	private ConnectionStoreFactory() {
	}

	public static ConnectionStore createNew(CreateConnectionStoreCommand command) {
		return new ConnectionStore(command.getHostname(),
				command.getPort(),
				command.getUsername(),
				command.getPassword());
	}
}
