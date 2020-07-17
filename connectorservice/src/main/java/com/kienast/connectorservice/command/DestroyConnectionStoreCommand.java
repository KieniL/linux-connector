package com.kienast.connectorservice.command;


public class DestroyConnectionStoreCommand {
	private String storeId;

	public DestroyConnectionStoreCommand(String storeId) {
		this.storeId = storeId;
	}

	public String getStoreId() {
		return storeId;
	}



}
