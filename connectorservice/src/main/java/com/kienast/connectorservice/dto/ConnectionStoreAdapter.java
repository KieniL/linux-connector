package com.kienast.connectorservice.dto;

import com.kienast.connectorservice.model.ConnectionStoreEntity;
import com.kienast.connectorservice.rest.api.model.ConnectionStoreModel;

public class ConnectionStoreAdapter {

	private ConnectionStoreEntity connectionStore;

	public ConnectionStoreAdapter(ConnectionStoreEntity connectionStore) {
		this.connectionStore = connectionStore;
	}

	public ConnectionStoreModel createJson() {
		return new ConnectionStoreModel()
				.id(String.valueOf(connectionStore.getId()))
				.hostname(connectionStore.getHostname())
				.port(connectionStore.getPort())
				.username(connectionStore.getUsername())
				.sshkey(connectionStore.getSshkey());
	}
}
