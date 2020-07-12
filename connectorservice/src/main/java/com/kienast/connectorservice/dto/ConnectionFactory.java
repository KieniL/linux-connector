package com.kienast.connectorservice.dto;

import com.kienast.connectorservice.command.CreateConnectionCommand;
import com.kienast.connectorservice.model.Connection;

public final class ConnectionFactory {

	private ConnectionFactory() {
	}

	public static Connection createNew(CreateConnectionCommand command) {
		return new Connection(
				command.getHostname(),
				command.getPort(),
				command.getUsername(),
				command.getPassword(),
				command.getSession());
	}
}
