package com.kienast.connectorservice.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.kienast.connectorservice.command.CreateConnectionCommand;
import com.kienast.connectorservice.command.CreateConnectionStoreCommand;
import com.kienast.connectorservice.command.DestroyConnectionCommand;
import com.kienast.connectorservice.command.DestroyConnectionStoreCommand;
import com.kienast.connectorservice.command.ShellCommand;
import com.kienast.connectorservice.command.UpdateConnectionStoreCommand;
import com.kienast.connectorservice.dto.CommandAdapter;
import com.kienast.connectorservice.dto.ConnectionAdapter;
import com.kienast.connectorservice.dto.ConnectionStatusAdapter;
import com.kienast.connectorservice.dto.ConnectionStoreAdapter;
import com.kienast.connectorservice.dto.ConnectionStoreStatusAdapter;
import com.kienast.connectorservice.exception.NotAuthorizedException;
import com.kienast.connectorservice.model.Connection;
import com.kienast.connectorservice.model.ConnectionStatus;
import com.kienast.connectorservice.model.ConnectionStore;
import com.kienast.connectorservice.model.ConnectionStoreStatus;
import com.kienast.connectorservice.rest.api.ConnectionApi;
import com.kienast.connectorservice.rest.api.ConnstoreApi;
import com.kienast.connectorservice.rest.api.model.ConnectionCommandRequestModel;
import com.kienast.connectorservice.rest.api.model.ConnectionCommandResponseModel;
import com.kienast.connectorservice.rest.api.model.ConnectionModel;
import com.kienast.connectorservice.rest.api.model.ConnectionRequestModel;
import com.kienast.connectorservice.rest.api.model.ConnectionStatusModel;
import com.kienast.connectorservice.rest.api.model.ConnectionStoreModel;
import com.kienast.connectorservice.rest.api.model.ConnectionStoreStatusModel;
import com.kienast.connectorservice.rest.api.model.DestroyConnectionRequestModel;
import com.kienast.connectorservice.service.ConnectionService;
import com.kienast.connectorservice.service.ConnectionStoreService;
import com.kienast.connectorservice.service.TokenService;

@RestController
public class ConnectionController implements ConnectionApi, ConnstoreApi {

	@Autowired
	private ConnectionService connectionService;
	
	@Autowired
	private TokenService tokenService;
	
	
	@Autowired
	private ConnectionStoreService connectionStoreService;
	
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
		
		CreateConnectionCommand command = new CreateConnectionCommand(connectionRequestModel.getId());
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



	@Override
	public ResponseEntity<List<ConnectionStoreModel>> getConnectionStores() {
		List<ConnectionStore> storedConnections = connectionStoreService.getStoredConnections();
		
		List<ConnectionStoreModel> response = storedConnections.stream().map(ConnectionStoreAdapter::new)
				.map(ConnectionStoreAdapter::createJson).collect(Collectors.toList());
		
		return ResponseEntity.ok(response);
	}
	
	
	@Override
	public ResponseEntity<ConnectionStoreStatusModel> addConnectionStore(@Valid ConnectionStoreModel connectionStoreModel) {
		
		if (tokenService.validateToken(connectionStoreModel.getToken()) == null) {
			throw(new NotAuthorizedException(connectionStoreModel.getToken()));
		}
		
		
		
		CreateConnectionStoreCommand command = new CreateConnectionStoreCommand(connectionStoreModel.getHostname(),
				connectionStoreModel.getPort(),
				connectionStoreModel.getUsername(),connectionStoreModel.getPassword());
		ConnectionStoreStatus connStoreStatus = connectionStoreService.addStoredConnection(command);
		ConnectionStoreStatusModel response = new ConnectionStoreStatusAdapter(connStoreStatus).createJson();
		return ResponseEntity.ok(response);
	}




	@Override
	public ResponseEntity<ConnectionStoreStatusModel> deleteConnectionStore(
			@Valid ConnectionStoreModel connectionStoreModel) {
		
		if (tokenService.validateToken(connectionStoreModel.getToken()) == null) {
			throw(new NotAuthorizedException(connectionStoreModel.getToken()));
		}
		
		
		DestroyConnectionStoreCommand command = new DestroyConnectionStoreCommand(connectionStoreModel.getHostname(),
				connectionStoreModel.getPort(), connectionStoreModel.getUsername(), connectionStoreModel.getPassword());
		ConnectionStoreStatus connStoreStatus = connectionStoreService.deleteStoredConnection(command);
		ConnectionStoreStatusModel response = new ConnectionStoreStatusAdapter(connStoreStatus).createJson();
		return ResponseEntity.ok(response);
	}



	@Override
	public ResponseEntity<ConnectionStoreStatusModel> updateConnectionStore(String storeId,
			@Valid ConnectionStoreModel connectionStoreModel) {

		if (tokenService.validateToken(connectionStoreModel.getToken()) == null) {
			throw(new NotAuthorizedException(connectionStoreModel.getToken()));
		}
		
		
		UpdateConnectionStoreCommand command = new UpdateConnectionStoreCommand(storeId, connectionStoreModel.getHostname(),
				connectionStoreModel.getPort(), connectionStoreModel.getUsername(), connectionStoreModel.getPassword());
		ConnectionStoreStatus connStoreStatus = connectionStoreService.updateStoredConnection(command);
		ConnectionStoreStatusModel response = new ConnectionStoreStatusAdapter(connStoreStatus).createJson();
		return ResponseEntity.ok(response);
	}


















}
