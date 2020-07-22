package com.kienast.connectorservice.service;

import com.kienast.connectorservice.model.TokenResponse;

public interface TokenService {

	TokenResponse validateToken(String jwtToken);
}
