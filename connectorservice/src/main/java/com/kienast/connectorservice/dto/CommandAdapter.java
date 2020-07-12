package com.kienast.connectorservice.dto;

import com.kienast.connectorservice.rest.api.model.ConnectionCommandResponseModel;

public class CommandAdapter {

	private String response;

	public CommandAdapter(String response) {
		this.response = response;
	}

	public ConnectionCommandResponseModel createJson() {
		return new ConnectionCommandResponseModel().response(response);
	}
}
