package com.kienast.connectorservice.model;

public class Connection {
	
	private String id;

	private String hostname;

	private int port;

	private String username;

	private String password;
	
	private String session;
	
	

	public Connection(String id, String hostname, int port, String username, String password, String session) {
		this.id = id;
		this.hostname = hostname;
		this.port = port;
		this.username = username;
		this.password = password;
		this.session = session;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


}
