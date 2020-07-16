package com.kienast.connectorservice.command;


public class ShellCommand {
	private String storeId;
	private String command;

	public ShellCommand(String storeId, String command) {
		this.storeId = storeId;
		this.command = command;
	}

	
	public String getCommand() {
		return command;
	}
	
	public String getStoreId() {
		return storeId;
	}
}
