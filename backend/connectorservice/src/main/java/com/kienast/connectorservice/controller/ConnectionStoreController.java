package com.kienast.connectorservice.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.kienast.connectorservice.dto.ConnectionStoreAdapter;
import com.kienast.connectorservice.dto.ConnectionStoreStatusAdapter;
import com.kienast.connectorservice.exception.ConnectionStoreExistsException;
import com.kienast.connectorservice.exception.ConnectionStoreNotFoundException;
import com.kienast.connectorservice.exception.NotAuthorizedException;
import com.kienast.connectorservice.model.ConnectionStore;
import com.kienast.connectorservice.model.ConnectionStoreEntity;
import com.kienast.connectorservice.model.ConnectionStoreStatus;
import com.kienast.connectorservice.repository.ConnectionStoreRepository;
import com.kienast.connectorservice.rest.api.ConnstoreApi;
import com.kienast.connectorservice.rest.api.model.ConnectionStoreModel;
import com.kienast.connectorservice.rest.api.model.ConnectionStoreStatusModel;
import com.kienast.connectorservice.rest.api.model.DeleteConnectionStoreRequestModel;
import com.kienast.connectorservice.service.TokenService;
import com.kienast.connectorservice.util.PasswordCheck;

@RestController
public class ConnectionStoreController implements ConnstoreApi{
	
	@Autowired
    private ConnectionStoreRepository connectionStoreRepository;
	
	@Autowired
	private TokenService tokenService;

	@Override
	public ResponseEntity<List<ConnectionStoreModel>> getConnectionStores() {
		
		
		List<ConnectionStoreEntity> entites = connectionStoreRepository.findAll();
		
		List<ConnectionStoreModel> response = entites.stream().map(ConnectionStoreAdapter::new)
				.map(ConnectionStoreAdapter::createJson).collect(Collectors.toList());
		
		return ResponseEntity.ok(response);
	}
	
	@Override
	public ResponseEntity<ConnectionStoreStatusModel> addConnectionStore(@Valid ConnectionStoreModel connectionStoreModel) {
		
		System.out.println("Add");
		
		if (tokenService.validateToken(connectionStoreModel.getToken()) == null) {
			throw(new NotAuthorizedException(connectionStoreModel.getToken()));
		}
		
		
		ConnectionStoreEntity entity = null;
		ConnectionStore store = new ConnectionStore(connectionStoreModel.getHostname(), connectionStoreModel.getPort(),
				connectionStoreModel.getUsername(), PasswordCheck.hashPassword(connectionStoreModel.getPassword()),
				connectionStoreModel.getSshkey());
		try {
			entity = findConnectionStore(store);
		}catch(java.util.NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
		
		
		if(entity == null) {
			entity = connectionStoreRepository.save(new ConnectionStoreEntity(connectionStoreModel.getHostname(), connectionStoreModel.getPort(),
					connectionStoreModel.getUsername(), PasswordCheck.hashPassword(connectionStoreModel.getPassword()),
					connectionStoreModel.getSshkey()));
		}else {
			System.out.println("Already exists");
			throw(new ConnectionStoreExistsException("already exists"));
		}

		
		ConnectionStoreStatus connStoreStatus;
		if(entity == null) {
			connStoreStatus = new ConnectionStoreStatus(500);
		}else {
			connStoreStatus = new ConnectionStoreStatus(200);
		}
		
		ConnectionStoreStatusModel response = new ConnectionStoreStatusAdapter(connStoreStatus).createJson();
		return ResponseEntity.ok(response);
	}
	
	
	@Override
	public ResponseEntity<ConnectionStoreStatusModel> updateConnectionStore(String storeId,
			@Valid ConnectionStoreModel connectionStoreModel) {

		if (tokenService.validateToken(connectionStoreModel.getToken()) == null) {
			throw(new NotAuthorizedException(connectionStoreModel.getToken()));
		}
		
		ConnectionStoreEntity entity = null;
		try {
			entity = findConnectionStoreById(Long.valueOf(storeId));
		}catch(java.util.NoSuchElementException e) {
			System.out.println(e.getMessage());
			throw(new ConnectionStoreNotFoundException(storeId));
		}
		
		
		ConnectionStoreStatus connStoreStatus;
		if(entity != null) {
			entity.setHostname(connectionStoreModel.getHostname());
			entity.setPassword(PasswordCheck.hashPassword(connectionStoreModel.getPassword()));
			entity.setPort(connectionStoreModel.getPort());
			entity.setSshkey(connectionStoreModel.getSshkey());
			entity.setUsername(connectionStoreModel.getUsername());
			connectionStoreRepository.save(entity);
			connStoreStatus = new ConnectionStoreStatus(200);
		}else {
			connStoreStatus = new ConnectionStoreStatus(500);
		}
		
		
		ConnectionStoreStatusModel response = new ConnectionStoreStatusAdapter(connStoreStatus).createJson();
		return ResponseEntity.ok(response);
	}
	
	@Override
	public ResponseEntity<ConnectionStoreStatusModel> deleteConnectionStore(
			@Valid DeleteConnectionStoreRequestModel deleteConnectionStoreRequestModel) {
		if (tokenService.validateToken(deleteConnectionStoreRequestModel.getToken()) == null) {
			throw(new NotAuthorizedException(deleteConnectionStoreRequestModel.getToken()));
		}
		
		ConnectionStoreEntity entity = null;
		try {
			entity = findConnectionStoreById(Long.valueOf(deleteConnectionStoreRequestModel.getStoreId()));
		}catch(java.util.NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
		
		if(entity != null) {
			connectionStoreRepository.delete(entity);
		}
				
		ConnectionStoreStatusModel response = new ConnectionStoreStatusAdapter(new ConnectionStoreStatus(200)).createJson();
		return ResponseEntity.ok(response);
	}
	
	

	
	private ConnectionStoreEntity findConnectionStore(ConnectionStore store) {
		return connectionStoreRepository.findAll().stream().filter(
				item -> item.getHostname().equals(store.getHostname()) &&
				PasswordCheck.checkPass(store.getPassword(), item.getPassword()) &&
				item.getPort() == store.getPort() && 
				item.getSshkey().equals(store.getSshkey()) &&
				item.getUsername().equals(store.getUsername())
				).findFirst().get();
	}
	
	private ConnectionStoreEntity findConnectionStoreById(Long id) {
		return connectionStoreRepository.findById(id).get();
	}
	

}
