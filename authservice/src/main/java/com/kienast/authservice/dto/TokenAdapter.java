package com.kienast.authservice.dto;

import com.kienast.authservice.rest.api.model.TokenModel;

public class TokenAdapter {
	private String token;

	public TokenAdapter(String token) {
		this.token = token;
	}

	public TokenModel createJson() {
		return new TokenModel().token(token);
	}
}
