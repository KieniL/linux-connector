package com.kienast.connectorservice.model;

public class ConnectionRequest {

	private String storeId;

	

	public ConnectionRequest(String storeId) {
		this.storeId = storeId;

	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

}
