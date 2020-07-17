package com.kienast.apiservice.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.kienast.apiservice.dto.TokenAdapter;
import com.kienast.apiservice.model.Login;
import com.kienast.apiservice.model.Token;
import com.kienast.apiservice.rest.api.AuthApi;
import com.kienast.apiservice.rest.api.model.LoginModel;
import com.kienast.apiservice.rest.api.model.TokenModel;


@RestController
public class AuthController implements AuthApi {
	
	//Used for WebTemplate
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@Value("${authURL}")
	private String authURL;
	
	@Value("${connURL}")
	private String connURL;

	@Override
	public ResponseEntity<TokenModel> authenticate(@Valid LoginModel loginModel) {
		Login login = new Login(loginModel.getEmail(), loginModel.getPassword());
		Token tokenResponse = null;
		
		try {
			tokenResponse = webClientBuilder.build()
					.post() //RequestMethod
					.uri(authURL+"/auth")
					.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
					.body(BodyInserters.fromObject(login))
					.retrieve() //run command
					.bodyToMono(Token.class) //convert Response
					.block(); //do as Synchronous call
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

		
		if (tokenResponse != null) {
			TokenModel response = new TokenAdapter(tokenResponse).createJson();
			return ResponseEntity.ok(response);
		}
		
		return ResponseEntity.badRequest().body(null);
	}

}
