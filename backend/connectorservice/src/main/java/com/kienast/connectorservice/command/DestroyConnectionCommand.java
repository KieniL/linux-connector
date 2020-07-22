package com.kienast.connectorservice.command;


public class DestroyConnectionCommand {
	private String storeId;

	public DestroyConnectionCommand(String storeId) {
		this.storeId = storeId;
	}


	public String getStoreId() {
		return storeId;
	}
	
}
