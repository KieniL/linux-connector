package com.kienast.connectorservice.dto;

import com.kienast.connectorservice.model.Connection;
import com.kienast.connectorservice.model.ConnectionStatus;
import com.kienast.connectorservice.model.ConnectionStoreStatus;
import com.kienast.connectorservice.rest.api.model.ConnectionModel;
import com.kienast.connectorservice.rest.api.model.ConnectionStatusModel;
import com.kienast.connectorservice.rest.api.model.ConnectionStoreStatusModel;

public class ConnectionStoreStatusAdapter {

	private ConnectionStoreStatus connectionStoreStatus;

	public ConnectionStoreStatusAdapter(ConnectionStoreStatus connectionStoreStatus) {
		this.connectionStoreStatus = connectionStoreStatus;
	}

	public ConnectionStoreStatusModel createJson() {
		return new ConnectionStoreStatusModel().status(connectionStoreStatus.getStatuscode());
	}
}
