package com.kienast.connectorservice.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class WebSecurityConfig extends WebSecurityConfigurerAdapter  {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.cors().and()
		.authorizeRequests()
		.antMatchers("/**").authenticated();
	}


}
