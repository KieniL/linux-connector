package com.kienast.connectorservice.command;


public class CreateConnectionCommand {
	private String storeId;
	private String password;
	
	public CreateConnectionCommand(String storeId, String password) {
		this.storeId = storeId;
		this.password = password;
	}

	public String getStoreId() {
		return storeId;
	}

	public String getPassword() {
		return password;
	}

	
}
