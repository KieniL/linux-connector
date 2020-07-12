package com.kienast.connectorservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.kienast.connectorservice.rest.api.ConnectionApi;
import com.kienast.connectorservice.rest.api.ConnstoreApi;
import com.kienast.connectorservice.rest.api.model.ConnectionStatusModel;
import com.kienast.connectorservice.rest.api.model.ConnectionStoreModel;
import com.kienast.connectorservice.service.ConnectionService;

public class ConnectionController implements ConnectionApi, ConnstoreApi {

	@Autowired
	private ConnectionService connectionService;

	
	@Override
	public ResponseEntity<ConnectionStatusModel> addConnectionStore() {
		
		return null;
	}

	@Override
	public ResponseEntity<ConnectionStatusModel> deleteConnectionStore() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<List<ConnectionStoreModel>> getonnectionStores() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ConnectionStatusModel> updateConnectionStore() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ConnectionStatusModel> createConnection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ConnectionStatusModel> destroyConnection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<List<ConnectionStoreModel>> getActiveConnection() {
		// TODO Auto-generated method stub
		return null;
	}

}
