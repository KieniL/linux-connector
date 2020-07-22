package com.kienast.authservice.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public final class SecurityContext {

	private SecurityContext() {
	}

	public static String getAuthenticatedUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null) {
			throw new IllegalArgumentException("todo user is not authenticated");
		}
		return (authentication.getName());
	}

}
