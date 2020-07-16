package com.kienast.authservice.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.kienast.authservice.command.LoginUserCommand;
import com.kienast.authservice.dto.TokenAdapter;
import com.kienast.authservice.exception.NotAuthorizedException;
import com.kienast.authservice.exception.WrongCredentialsException;
import com.kienast.authservice.rest.api.AuthApi;
import com.kienast.authservice.rest.api.model.LoginModel;
import com.kienast.authservice.rest.api.model.TokenModel;
import com.kienast.authservice.service.TokenService;
import com.kienast.authservice.service.UserService;


@RestController
public class AuthController implements AuthApi{

	@Autowired
	private UserService userService;
	
	@Autowired
	private TokenService tokenService;
	
	@Override
	public ResponseEntity<TokenModel> authenticate(@Valid LoginModel loginModel) {
		LoginUserCommand command = new LoginUserCommand(loginModel.getEmail(), loginModel.getPassword());
		String[] userCred;
		
		try{
			userCred = userService.login(command);
		}catch(WrongCredentialsException e) {
			throw(new NotAuthorizedException(command.getEmail()));
		}
		
		TokenModel response = new TokenAdapter(userCred).createJson();
		return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<TokenModel> verifyToken(@Valid TokenModel tokenModel) {
		if (!tokenService.validateToken(tokenModel.getToken())) {
			throw(new NotAuthorizedException(tokenModel.getToken()));
		}
		
		return ResponseEntity.ok(tokenModel);
	}

}
