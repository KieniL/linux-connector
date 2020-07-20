package com.kienast.authservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import net.bytebuddy.implementation.bind.annotation.Super;

@ResponseStatus(value=HttpStatus.FORBIDDEN, reason = "Not Authorized")
public class NotAuthorizedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final String id;
	

	public NotAuthorizedException(String id) {
		this.id = id;
	}
	
	

	public String getId() {
		return id;
	}

}
