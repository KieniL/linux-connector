package com.kienast.connectorservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason = "No surch Connection STore")
public class ConnectionStoreNotFoundException {

	private static final long serialVersionUID = 1L;

	private final String id;

	public ConnectionStoreNotFoundException(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
}
