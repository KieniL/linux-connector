package com.kienast.authservice.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.kienast.authservice.dto.TokenAdapter;
import com.kienast.authservice.exception.NotAuthorizedException;
import com.kienast.authservice.exception.WrongCredentialsException;
import com.kienast.authservice.model.User;
import com.kienast.authservice.repository.UserRepository;
import com.kienast.authservice.rest.api.AuthApi;
import com.kienast.authservice.rest.api.model.LoginModel;
import com.kienast.authservice.rest.api.model.TokenModel;
import com.kienast.authservice.service.TokenService;


@RestController
public class AuthController implements AuthApi{

	
	@Autowired
    private UserRepository userEntityRepository;
	
	@Autowired
	private TokenService tokenService;
	
	
	@Override
	public ResponseEntity<TokenModel> authenticate(@Valid LoginModel loginModel) {
		
		User user = null;
		try {
			user = findByEmailAndPassword(loginModel.getEmail(), loginModel.getPassword());
		}catch(java.util.NoSuchElementException e) {
			System.out.println(e.getMessage());
			throw(new NotAuthorizedException(loginModel.getEmail()));
		}
		 
		
		String userCred = "";
		
		try{
			userCred = tokenService.generateToken(user.getEmail());
		}catch(WrongCredentialsException e) {
			throw(new NotAuthorizedException(user.getEmail()));
		}
		
		TokenModel response = new TokenAdapter(userCred).createJson();
		return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<TokenModel> register(@Valid LoginModel loginModel) throws NotAuthorizedException {
		
		User user = null;
		try {
			user = findByEmailAndPassword(loginModel.getEmail(), loginModel.getPassword());
		}catch(java.util.NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
		
		User entity = null;
		
		if(user == null) {
			entity = userEntityRepository.save(new User(loginModel.getEmail(), hashPassword(loginModel.getPassword())));
		}else {
			System.out.println("Already exists");
			throw(new NotAuthorizedException("already exists"));
		}
		
		
		
		
		String userCred = "";
		
		try{
			userCred = tokenService.generateToken(entity.getEmail());
		}catch(WrongCredentialsException e) {
			throw(new NotAuthorizedException(entity.getEmail()));
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
	
	
	private User findByEmailAndPassword(String email, String password) {
		return userEntityRepository.findAll().stream().filter(
				item -> item.getEmail().equals(email) && checkPass(password, item.getPassword())
				).findFirst().get();
	}
	
	private String hashPassword(String plainTextPassword){
		return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
	}
	
	private boolean checkPass(String plainPassword, String hashedPassword) {
		return BCrypt.checkpw(plainPassword, hashedPassword);
	}
	
	



}
