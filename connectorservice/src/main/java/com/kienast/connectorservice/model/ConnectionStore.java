package com.kienast.connectorservice.model;


public class ConnectionStore {

	private String id;
	
	private String hostname;

	private int port;

	private String username;

	private String password;
	
	private String sshkey;
	

	public ConnectionStore(String hostname, int port, String username, String password, String sshkey) {
		this.hostname = hostname;
		this.port = port;
		this.username = username;
		this.password = password;
		this.sshkey = sshkey;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSshkey() {
		return sshkey;
	}

	public void setSshkey(String sshkey) {
		this.sshkey = sshkey;
	}
}
