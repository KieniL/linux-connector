package com.kienast.connectorservice.command;


public class UpdateConnectionStoreCommand {
	private int storeId;
	private String hostname;
	private int port;
	private String username;
	private String password;

	public UpdateConnectionStoreCommand(int storeId, String hostname, int port, String username, String password) {
		this.storeId = storeId;
		this.hostname = hostname;
		this.port = port;
		this.username = username;
		this.password =  password;	
	}

	public int getStoreId() {
		return storeId;
	}
	
	public String getHostname() {
		return hostname;
	}

	public int getPort() {
		return port;
	}

	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}


}
