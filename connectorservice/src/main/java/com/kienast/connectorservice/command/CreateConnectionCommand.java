package com.kienast.connectorservice.command;


public class CreateConnectionCommand {
	private int storeId;
	
	public CreateConnectionCommand(int storeId) {
		this.storeId = storeId;
	}

	public int getStoreId() {
		return storeId;
	}

	
}
