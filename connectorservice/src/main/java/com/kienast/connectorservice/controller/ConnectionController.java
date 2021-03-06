package com.kienast.connectorservice.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.kienast.connectorservice.command.CreateConnectionCommand;
import com.kienast.connectorservice.command.DestroyConnectionCommand;
import com.kienast.connectorservice.command.ShellCommand;
import com.kienast.connectorservice.dto.CommandAdapter;
import com.kienast.connectorservice.dto.ConnectionAdapter;
import com.kienast.connectorservice.dto.ConnectionStatusAdapter;
import com.kienast.connectorservice.exception.NotAuthorizedException;
import com.kienast.connectorservice.model.Connection;
import com.kienast.connectorservice.model.ConnectionStatus;
import com.kienast.connectorservice.rest.api.ConnectionApi;
import com.kienast.connectorservice.rest.api.model.ConnectionCommandRequestModel;
import com.kienast.connectorservice.rest.api.model.ConnectionCommandResponseModel;
import com.kienast.connectorservice.rest.api.model.ConnectionModel;
import com.kienast.connectorservice.rest.api.model.ConnectionRequestModel;
import com.kienast.connectorservice.rest.api.model.ConnectionStatusModel;
import com.kienast.connectorservice.rest.api.model.DestroyConnectionRequestModel;
import com.kienast.connectorservice.service.ConnectionService;
import com.kienast.connectorservice.service.TokenService;

@RestController
public class ConnectionController implements ConnectionApi {

	@Autowired
	private ConnectionService connectionService;
	
	@Autowired
	private TokenService tokenService;

	
	@Override
	public ResponseEntity<List<ConnectionModel>> getActiveConnections() {
		List<Connection> activeConnections = connectionService.getActiveConnections();

		List<ConnectionModel> response = activeConnections.stream().map(ConnectionAdapter::new)
				.map(ConnectionAdapter::createJson).collect(Collectors.toList());
		
		return ResponseEntity.ok(response);
	}

	
	@Override
	public ResponseEntity<ConnectionStatusModel> createConnection(
			@Valid ConnectionRequestModel connectionRequestModel) {
		if (tokenService.validateToken(connectionRequestModel.getToken()) == null) {
			throw(new NotAuthorizedException(connectionRequestModel.getToken()));
		}
		
		CreateConnectionCommand command = new CreateConnectionCommand(connectionRequestModel.getId(), connectionRequestModel.getPassword());
		ConnectionStatus connectionStatus = connectionService.createConnection(command);
		ConnectionStatusModel response = new ConnectionStatusAdapter(connectionStatus).createJson();
		return ResponseEntity.ok(response);
	}


	
	@Override
	public ResponseEntity<ConnectionStatusModel> destroyConnection(
			@Valid DestroyConnectionRequestModel destroyConnectionRequestModel) {
		
		if (tokenService.validateToken(destroyConnectionRequestModel.getToken()) == null) {
			throw(new NotAuthorizedException(destroyConnectionRequestModel.getToken()));
		}
		
		
		DestroyConnectionCommand command = new DestroyConnectionCommand(destroyConnectionRequestModel.getStoreId());
		ConnectionStatus connectionStatus = connectionService.destroyConnection(command);
		ConnectionStatusModel response = new ConnectionStatusAdapter(connectionStatus).createJson();
		return ResponseEntity.ok(response);
	}
	

	
	@Override
	public ResponseEntity<ConnectionCommandResponseModel> addCommand(
			@Valid ConnectionCommandRequestModel connectionCommandRequestModel) {
		
		if (tokenService.validateToken(connectionCommandRequestModel.getToken()) == null) {
			throw(new NotAuthorizedException(connectionCommandRequestModel.getToken()));
		}
		
		
		ShellCommand command = new ShellCommand(connectionCommandRequestModel.getStoreId(),
				connectionCommandRequestModel.getCommand());
		
		String responseText = connectionService.addCommand(command);
		
		ConnectionCommandResponseModel response = new CommandAdapter(responseText).createJson();
		
		return ResponseEntity.ok(response);
	}



	
	
	
	




		
	
	



	






















}
