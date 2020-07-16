package com.kienast.connectorservice.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter  {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.cors().and()
		.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/").permitAll()
		.antMatchers(HttpMethod.GET, "/connstore").permitAll()
		.antMatchers(HttpMethod.POST, "/connstore").permitAll()
		.antMatchers(HttpMethod.HEAD, "/connstore").permitAll()
		.antMatchers(HttpMethod.PUT, "/connection").permitAll()
		.antMatchers(HttpMethod.POST, "/connstore/**").permitAll()
		.antMatchers(HttpMethod.GET, "/connection").permitAll()
		.antMatchers(HttpMethod.POST, "/connection").permitAll()
		.antMatchers(HttpMethod.HEAD, "/connection").permitAll()
		.antMatchers(HttpMethod.PUT, "/connection").permitAll();
		
		}
}
