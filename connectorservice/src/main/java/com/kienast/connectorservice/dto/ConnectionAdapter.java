package com.kienast.connectorservice.dto;

import com.kienast.connectorservice.model.Connection;
import com.kienast.connectorservice.rest.api.model.ConnectionModel;

public class ConnectionAdapter {

	private Connection connection;

	public ConnectionAdapter(Connection connection) {
		this.connection = connection;
	}

	public ConnectionModel createJson() {
		return new ConnectionModel()
				.hostname(connection.getHostname())
				.port(connection.getPort())
				.username(connection.getUsername())
				.session(connection.getSession());
	}
}
