package com.kienast.connectorservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason = "Already exists")
public class ConnectionStoreExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final String id;

	public ConnectionStoreExistsException(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
}
