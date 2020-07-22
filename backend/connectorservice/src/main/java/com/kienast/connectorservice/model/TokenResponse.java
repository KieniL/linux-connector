package com.kienast.connectorservice.model;


public class TokenResponse {

	private String token;

	private String userid;
	
	public TokenResponse() {
		
	}

	public TokenResponse(String token, String userid) {
		this.token = token;
		this.userid = userid;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	  
	  
}
