package com.kienast.connectorservice.model;

import java.math.BigDecimal;

public class ConnectionStoreStatus {

	private int statuscode;
	
	public ConnectionStoreStatus(int statusCode) {
		this.statuscode = statusCode;
	}

	public int getStatuscode() {
		return statuscode;
	}

	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}
	
	
}
