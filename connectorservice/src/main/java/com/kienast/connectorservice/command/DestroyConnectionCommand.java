package com.kienast.connectorservice.command;


public class DestroyConnectionCommand {
	private String hostname;
	private int port;
	private String username;
	private String password;
	private String session;

	public DestroyConnectionCommand(String hostname, int port, String username, String password, String session) {
		this.hostname = hostname;
		this.port = port;
		this.username = username;
		this.password =  password;
		this.session = session;
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

	public String getSession() {
		return session;
	}
	
}
