package com.kienast.connectorservice.dto;

import com.kienast.connectorservice.command.CreateConnectionCommand;
import com.kienast.connectorservice.model.ConnectionRequest;

public final class ConnectionFactory {

	private ConnectionFactory() {
	}

	public static ConnectionRequest createNew(CreateConnectionCommand command) {
		return new ConnectionRequest(
				command.getStoreId(),
				command.getPassword());
	}
}
