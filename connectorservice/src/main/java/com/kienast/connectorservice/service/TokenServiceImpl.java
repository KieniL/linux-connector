package com.kienast.connectorservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.kienast.connectorservice.model.TokenRequest;
import com.kienast.connectorservice.model.TokenResponse;

@Component
public class TokenServiceImpl implements TokenService {

	//Used for WebTemplate
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@Value("${authURL}")
	private String authURL;
		
	@Override
	public TokenResponse validateToken(String jwtToken) {
		TokenRequest tmpToken = new TokenRequest(jwtToken);
		
		TokenResponse tokenResponse = null;
		
		try {
			tokenResponse = webClientBuilder.build()
					.put() //RequestMethod
					.uri(authURL+"/auth")
					.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
					.body(BodyInserters.fromObject(tmpToken))
					.retrieve() //run command
					.bodyToMono(TokenResponse.class) //convert Response
					.block(); //do as Synchronous call
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

		
		if (tokenResponse != null) {
			return tokenResponse;
		}
		
		return null;
	}

}
