package com.kienast.connectorservice.command;


public class CreateConnectionStoreCommand {

	private String hostname;
	private int port;
	private String username;
	private String password;

	public CreateConnectionStoreCommand(String hostname, int port, String username, String password) {
		this.hostname = hostname;
		this.port = port;
		this.username = username;
		this.password =  password;
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
