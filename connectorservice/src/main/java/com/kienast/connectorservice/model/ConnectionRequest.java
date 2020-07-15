package com.kienast.connectorservice.model;

public class ConnectionRequest {

	private int storeId;

	

	public ConnectionRequest(int storeId) {
		this.storeId = storeId;

	}

	public int getStoreId() {
		return storeId;
	}

	public void getStoreId(int storeId) {
		this.storeId = storeId;
	}

}
