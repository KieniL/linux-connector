package com.kienast.connectorservice.command;


public class CreateConnectionCommand {
	private String storeId;
	
	public CreateConnectionCommand(String storeId) {
		this.storeId = storeId;
	}

	public String getStoreId() {
		return storeId;
	}

	
}
