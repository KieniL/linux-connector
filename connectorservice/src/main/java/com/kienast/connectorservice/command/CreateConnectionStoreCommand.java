package com.kienast.connectorservice.command;


public class CreateConnectionStoreCommand {

	private String hostname;
	private int port;
	private String username;
	private String password;
	private String sshkey;

	public CreateConnectionStoreCommand(String hostname, int port, String username, String password, String sshkey) {
		this.hostname = hostname;
		this.port = port;
		this.username = username;
		this.password =  password;
		this.sshkey = sshkey;
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

	public String getSshkey() {
		return sshkey;
	}


	
}
