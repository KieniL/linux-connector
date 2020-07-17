package com.kienast.apiservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.kienast.apiservice.rest.api.ConnstoreApi;
import com.kienast.apiservice.rest.api.model.ConnectionStoreModel;
import com.kienast.apiservice.rest.api.model.ConnectionStoreStatusModel;

@RestController
public class ConnStoreController implements ConnstoreApi {

	@Override
	public ResponseEntity<ConnectionStoreStatusModel> addConnectionStore(
			@Valid ConnectionStoreModel connectionStoreModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ConnectionStoreStatusModel> deleteConnectionStore(
			@Valid ConnectionStoreModel connectionStoreModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<List<ConnectionStoreModel>> getConnectionStores() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ConnectionStoreStatusModel> updateConnectionStore(String storeId,
			@Valid ConnectionStoreModel connectionStoreModel) {
		// TODO Auto-generated method stub
		return null;
	}

}
