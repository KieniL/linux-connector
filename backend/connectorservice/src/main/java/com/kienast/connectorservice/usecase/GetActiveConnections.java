package com.kienast.connectorservice.usecase;

import java.util.List;

import com.kienast.connectorservice.model.Connection;
import com.kienast.connectorservice.repository.ConnectionRepository;

public class GetActiveConnections {

	private ConnectionRepository connectionRepository;

	public GetActiveConnections(ConnectionRepository connectionRepository) {
		this.connectionRepository = connectionRepository;
	}

	public List<Connection> getConnections() {
		return connectionRepository.getConnections();
	}
}
