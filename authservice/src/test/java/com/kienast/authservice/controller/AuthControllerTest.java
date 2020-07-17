package com.kienast.authservice.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;

import com.kienast.authservice.command.LoginUserCommand;
import com.kienast.authservice.model.User;
import com.kienast.authservice.repository.UserRepository;
import com.kienast.authservice.service.TokenService;
import com.kienast.authservice.service.UserService;


@WebMvcTest(controllers = AuthController.class)
@AutoConfigureMockMvc(addFilters = false)
class AuthControllerTest {
	
	@Autowired
    private MockMvc mockMvc;
	
	@MockBean
	private UserService userService;
	
	@MockBean
	private TokenService tokenService;
	
	@MockBean
	private UserRepository userRepository;
	
	@MockBean
	private PasswordEncoder passwordEncoder;
	
	
	private List<User> users;

	//Not Done atm since no idea why not true
	void testAuthenticate() throws Exception {
		
		String[] userCred = new String[] {
			"eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIyIiwiYXV0aCI6IlJPTEVfU0VSVklDRSIsImlhdCI6MTU5NDg3Nzc2NiwiZXhwIjoxNjI2NDEzNzY2fQ.PqmkF0KeVOg5Jpk_Uz2HVt-FTFkb_lcV1Q1_K_oIjM1yrRkDS0F8BQMlpyO8iU30eqATr80p6LE0-JiINaPOeA",
			null
		};
		


		//init Test Data
		users = new ArrayList<>();
		users.add(new User("1", "test1234@gmail.com", passwordEncoder.encode("password")));
		users.add(new User("2", "testuser@gmail.com", passwordEncoder.encode("password")));
		
		LoginUserCommand command = new LoginUserCommand(users.get(1).getEmail(), "password");
		
		
		//MockService
		Mockito.when (userService.login(command)).thenReturn (userCred);

		String jsonBody = "{\"email\" : \""+command.getEmail()+"\",\"password\" : \""+command.getPassword()+"\"}";
		
		
		//Do Request
		this.mockMvc.perform(post("/auth").contentType(MediaType.APPLICATION_JSON)
				.content(jsonBody))
	       .andExpect(status().isOk());
	}

	@Test
	void testVerifyValidToken() throws Exception {
		
		String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIyIiwiYXV0aCI6IlJPTEVfU0VSVklDRSIsImlhdCI6MTU5NDg3Nzc2NiwiZXhwIjoxNjI2NDEzNzY2fQ.PqmkF0KeVOg5Jpk_Uz2HVt-FTFkb_lcV1Q1_K_oIjM1yrRkDS0F8BQMlpyO8iU30eqATr80p6LE0-JiINaPOeA";
		
		
		//MockService
		Mockito.when (tokenService.validateToken(token)).thenReturn(true);
		
		String jsonBody = "{\"token\" : \""+token+"\"}";
		
		
		this.mockMvc.perform(put("/auth").contentType(MediaType.APPLICATION_JSON)
				.content(jsonBody))
	       .andExpect(status().isOk())
	       .andExpect(content().json("{\"token\":\""+token+"\", \"userid\" : null}"));
	}
	
	@Test
	void testVerifyNotValidToken() throws Exception {
		
		String token = "eyJhbGciOiJIUzUxMiJ9.PqmkF0KeVOg5Jpk_Uz2HVt-FTFkb_lcV1Q1_K_oIjM1yrRkDS0F8BQMlpyO8iU30eqATr80p6LE0-JiINaPOeA";
		
		
		//MockService
		Mockito.when (tokenService.validateToken(token)).thenReturn(false);
		
		String jsonBody = "{\"token\" : \""+token+"\"}";
		
		
		this.mockMvc.perform(put("/auth").contentType(MediaType.APPLICATION_JSON)
				.content(jsonBody))
	       .andExpect(status().isForbidden());
	}

}
