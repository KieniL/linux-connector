package com.kienast.authservice.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import com.kienast.authservice.service.TokenService;

import io.jsonwebtoken.ExpiredJwtException;

public class JwtAuthorizationFilter extends GenericFilterBean {

	private static final String HEADER = "Authorization";
	private static final String PREFIX = "Bearer ";

	private TokenService tokenService;

	public JwtAuthorizationFilter(TokenService tokenService) {
		this.tokenService = tokenService;
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {

		try {
			HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
			String jwt = this.resolveToken(httpServletRequest);
			if (StringUtils.hasText(jwt)) {
				if (tokenService.validateToken(jwt)) {
					Authentication authentication = tokenService.getAuthentication(jwt);
					SecurityContextHolder.getContext().setAuthentication(authentication);
				}
			}
			filterChain.doFilter(servletRequest, servletResponse);

			this.resetAuthenticationAfterRequest();
		} catch (ExpiredJwtException eje) {
			((HttpServletResponse) servletResponse).setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		}
	}

	private void resetAuthenticationAfterRequest() {
		SecurityContextHolder.getContext().setAuthentication(null);
	}

	private String resolveToken(HttpServletRequest request) {
		String bearerToken = request.getHeader(HEADER);
		if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(PREFIX)) {
			return bearerToken.substring(7, bearerToken.length());
		}
		return null;
	}

}

