package com.kienast.connectorservice.model;

public class ConnectionRequest {

	private String storeId;
	private String password;
	

	public ConnectionRequest(String storeId, String password) {
		this.storeId = storeId;
		this.setPassword(password);

	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
