package com.kienast.authservice.service;

import com.kienast.authservice.command.LoginUserCommand;

public interface UserService {
	String[] login(LoginUserCommand command);
}
