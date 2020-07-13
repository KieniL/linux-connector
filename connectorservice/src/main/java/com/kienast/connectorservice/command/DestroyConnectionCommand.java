package com.kienast.connectorservice.command;


public class DestroyConnectionCommand {
	private String session;

	public DestroyConnectionCommand(String session) {
		this.session = session;
	}


	public String getSession() {
		return session;
	}
	
}
