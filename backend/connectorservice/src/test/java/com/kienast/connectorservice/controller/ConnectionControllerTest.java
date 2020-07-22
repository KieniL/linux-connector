package com.kienast.connectorservice.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
import org.springframework.test.web.servlet.MockMvc;

import com.kienast.connectorservice.command.CreateConnectionCommand;
import com.kienast.connectorservice.model.Connection;
import com.kienast.connectorservice.model.ConnectionStatus;
import com.kienast.connectorservice.repository.ConnectionRepository;
import com.kienast.connectorservice.service.ConnectionService;
import com.kienast.connectorservice.service.TokenService;


@WebMvcTest(controllers = ConnectionController.class)
@AutoConfigureMockMvc(addFilters = false)
class ConnectionControllerTest {
	
	@Autowired
    private MockMvc mockMvc;
	
	@MockBean
	private ConnectionService connectionService;
	
	
	
	@MockBean
	private TokenService tokenService;
	

	@MockBean
	private ConnectionRepository connectionRepositor;
	
	private List<Connection> connections;

	/*
	@Test
	void testGetActiveConnections() throws Exception {
		
		connections = new ArrayList<Connection>();
		
		connections.add(new Connection("1", "10.0.0.0", 22, "testuser", "testpw", "session1"));
		
		//MockService
		Mockito.when (connectionService.getActiveConnections()).thenReturn (connections);
		
		//Do Request
		this.mockMvc.perform(get("/connection").contentType(MediaType.APPLICATION_JSON))
	       .andExpect(status().isOk())
	       .andExpect(content().json("[{\"hostname\":\"10.0.0.0\","
	       		+ "\"port\" : 22, "
	       		+ "\"username\" : \"testuser\", "
	       		+ "\"password\" : null}]"));
	}

	//@Test
	void testCreateConnection() throws Exception {
		
		String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIyIiwiYXV0aCI6IlJPTEVfU0VSVklDRSIsImlhdCI6MTU5NDg4MDc0OCwiZXhwIjoxNjI2NDE2NzQ4fQ.UQkT0tL_YqXizGQ1LtVj8emzLg081Bvbi63mIw63yQho0CR1sToG2Ac33IQacYQv1rG6cQnKQgNC0uzTPqBe4w";
		//MockService
		CreateConnectionCommand command = new CreateConnectionCommand("1");
		ConnectionStatus status = null;
		Mockito.when (connectionService.createConnection(command)).thenReturn (status);
		
		this.mockMvc.perform(post("/connection").contentType(MediaType.APPLICATION_JSON)
				.content("{\"id\" : 1, \"token\" : \""+token+"\"}"))
		.andExpect(status().isOk());
	}

	//@Test
	void testDestroyConnection() throws Exception {
		fail("Not yet implemented");
	}

	//@Test
	void testAddCommand() throws Exception {
		fail("Not yet implemented");
	}

	//@Test
	void testGetConnectionStores() throws Exception {
		fail("Not yet implemented");
	}

	//@Test
	void testAddConnectionStore() throws Exception {
		fail("Not yet implemented");
	}

	//@Test
	void testDeleteConnectionStore() throws Exception {
		fail("Not yet implemented");
	}

	//@Test
	void testUpdateConnectionStore() throws Exception {
		fail("Not yet implemented");
	}*/

}
