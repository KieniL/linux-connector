package com.kienast.connectorservice.dto;

import com.kienast.connectorservice.model.ConnectionStore;
import com.kienast.connectorservice.rest.api.model.ConnectionStoreModel;

public class ConnectionStoreAdapter {

	private ConnectionStore connectionStore;

	public ConnectionStoreAdapter(ConnectionStore connectionStore) {
		this.connectionStore = connectionStore;
	}

	public ConnectionStoreModel createJson() {
		return new ConnectionStoreModel()
				.id(connectionStore.getId())
				.hostname(connectionStore.getHostname())
				.port(connectionStore.getPort())
				.username(connectionStore.getUsername())
				.password(connectionStore.getPassword());
	}
}
