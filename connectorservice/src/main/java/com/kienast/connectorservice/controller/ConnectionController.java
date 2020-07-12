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
import com.kienast.connectorservice.dto.ConnectionStoreAdapter;
import com.kienast.connectorservice.model.Connection;
import com.kienast.connectorservice.model.ConnectionStatus;
import com.kienast.connectorservice.model.ConnectionStore;
import com.kienast.connectorservice.rest.api.ConnectionApi;
import com.kienast.connectorservice.rest.api.ConnstoreApi;
import com.kienast.connectorservice.rest.api.model.ConnectionCommandRequestModel;
import com.kienast.connectorservice.rest.api.model.ConnectionCommandResponseModel;
import com.kienast.connectorservice.rest.api.model.ConnectionModel;
import com.kienast.connectorservice.rest.api.model.ConnectionStatusModel;
import com.kienast.connectorservice.rest.api.model.ConnectionStoreModel;
import com.kienast.connectorservice.service.ConnectionService;

@RestController
public class ConnectionController implements ConnectionApi, ConnstoreApi {

	@Autowired
	private ConnectionService connectionService;

	
	@Override
	public ResponseEntity<List<ConnectionModel>> getActiveConnections() {
		List<Connection> activeConnections = connectionService.getActiveConnections();
		
		List<ConnectionModel> response = activeConnections.stream().map(ConnectionAdapter::new)
				.map(ConnectionAdapter::createJson).collect(Collectors.toList());
		
		return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<ConnectionStatusModel> createConnection(@Valid ConnectionModel connectionModel) {
		CreateConnectionCommand command = new CreateConnectionCommand(connectionModel.getHostname(),
				connectionModel.getPort(), connectionModel.getUsername(),
				connectionModel.getPassword(), connectionModel.getSession());
		ConnectionStatus connectionStatus = connectionService.createConnection(command);
		ConnectionStatusModel response = new ConnectionStatusAdapter(connectionStatus).createJson();
		return ResponseEntity.ok(response);
	}
	
	
	@Override
	public ResponseEntity<ConnectionStatusModel> destroyConnection(@Valid ConnectionModel connectionModel) {
		DestroyConnectionCommand command = new DestroyConnectionCommand(connectionModel.getHostname(),
				connectionModel.getPort(), connectionModel.getUsername(),
				connectionModel.getPassword(), connectionModel.getSession());
		ConnectionStatus connectionStatus = connectionService.destroyConnection(command);
		ConnectionStatusModel response = new ConnectionStatusAdapter(connectionStatus).createJson();
		return ResponseEntity.ok(response);
	}
	

	
	@Override
	public ResponseEntity<ConnectionCommandResponseModel> addCommand(
			@Valid ConnectionCommandRequestModel connectionCommandRequestModel) {
		ShellCommand command = new ShellCommand(connectionCommandRequestModel.getSession(),
				connectionCommandRequestModel.getCommand());
		
		String responseText = connectionService.addCommand(command);
		
		ConnectionCommandResponseModel response = new CommandAdapter(responseText).createJson();
		
		return ResponseEntity.ok(response);
	}



	@Override
	public ResponseEntity<List<ConnectionStoreModel>> getConnectionStores() {
		List<ConnectionStore> storedConnections = connectionService.getStoredConnections();
		
		List<ConnectionStoreModel> response = storedConnections.stream().map(ConnectionStoreAdapter::new)
				.map(ConnectionStoreAdapter::createJson).collect(Collectors.toList());
		
		return ResponseEntity.ok(response);
	}
	
	
	@Override
	public ResponseEntity<ConnectionStatusModel> addConnectionStore(@Valid ConnectionStoreModel connectionStoreModel) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public ResponseEntity<ConnectionStatusModel> deleteConnectionStore(
			@Valid ConnectionStoreModel connectionStoreModel) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public ResponseEntity<ConnectionStatusModel> updateConnectionStore(
			@Valid ConnectionStoreModel connectionStoreModel) {
		// TODO Auto-generated method stub
		return null;
	}




}
