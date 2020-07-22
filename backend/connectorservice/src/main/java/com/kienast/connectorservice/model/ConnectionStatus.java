package com.kienast.connectorservice.model;


public class ConnectionStatus {

	private int statuscode;
	
	public ConnectionStatus(int statusCode) {
		this.statuscode = statusCode;
	}

	public int getStatuscode() {
		return statuscode;
	}

	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}
	
	
}
