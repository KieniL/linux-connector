package com.kienast.connectorservice.command;


public class ShellCommand {
	private String session;
	private String command;

	public ShellCommand(String session, String command) {
		this.session = session;
		this.command = command;
	}

	
	public String getCommand() {
		return command;
	}
	
	public String getSession() {
		return session;
	}
}
