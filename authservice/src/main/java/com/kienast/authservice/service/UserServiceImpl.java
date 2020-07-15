package com.kienast.authservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.kienast.authservice.command.LoginUserCommand;
import com.kienast.authservice.repository.UserRepository;
import com.kienast.authservice.usecase.LoginUser;


@Component
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TokenService tokenService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public String[] login(LoginUserCommand command) {
		return new LoginUser(userRepository, command, tokenService, passwordEncoder).login();
	}

}
