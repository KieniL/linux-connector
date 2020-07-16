package com.kienast.connectorservice.command;


public class UpdateConnectionStoreCommand {
	private String storeId;
	private String hostname;
	private int port;
	private String username;
	private String password;

	public UpdateConnectionStoreCommand(String storeId, String hostname, int port, String username, String password) {
		this.storeId = storeId;
		this.hostname = hostname;
		this.port = port;
		this.username = username;
		this.password =  password;	
	}

	public String getStoreId() {
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
