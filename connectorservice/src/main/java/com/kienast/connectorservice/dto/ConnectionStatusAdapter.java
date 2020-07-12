package com.kienast.connectorservice.dto;

import com.kienast.connectorservice.model.Connection;
import com.kienast.connectorservice.model.ConnectionStatus;
import com.kienast.connectorservice.rest.api.model.ConnectionModel;
import com.kienast.connectorservice.rest.api.model.ConnectionStatusModel;

public class ConnectionStatusAdapter {

	private ConnectionStatus connectionStatus;

	public ConnectionStatusAdapter(ConnectionStatus connectionStatus) {
		this.connectionStatus = connectionStatus;
	}

	public ConnectionStatusModel createJson() {
		return new ConnectionStatusModel().statuscode(connectionStatus.getStatuscode());
	}
}
