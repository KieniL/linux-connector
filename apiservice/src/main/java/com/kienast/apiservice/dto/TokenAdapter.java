package com.kienast.apiservice.dto;

import com.kienast.apiservice.model.Token;
import com.kienast.apiservice.rest.api.model.TokenModel;

public class TokenAdapter {
	private String token;
	private String userid;

	public TokenAdapter(Token token) {
		this.token = token.getToken();
		this.userid = token.getUserId();
	}

	public TokenModel createJson() {
		return new TokenModel().token(token).userid(userid);
	}
}
