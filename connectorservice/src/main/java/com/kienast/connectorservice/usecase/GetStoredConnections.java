package com.kienast.connectorservice.usecase;

import java.util.List;

import com.kienast.connectorservice.model.ConnectionStore;
import com.kienast.connectorservice.repository.ConnectionStoreRepository;

public class GetStoredConnections {
	private ConnectionStoreRepository connectionStoreRepository;

	public GetStoredConnections(ConnectionStoreRepository connectionStoreRepository) {
		this.connectionStoreRepository = connectionStoreRepository;
	}

	public List<ConnectionStore> getConnections() {
		return connectionStoreRepository.getConnections();
	}
}
