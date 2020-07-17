package com.kienast.apiservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.kienast.apiservice.rest.api.ConnectionApi;
import com.kienast.apiservice.rest.api.model.ConnectionCommandRequestModel;
import com.kienast.apiservice.rest.api.model.ConnectionCommandResponseModel;
import com.kienast.apiservice.rest.api.model.ConnectionModel;
import com.kienast.apiservice.rest.api.model.ConnectionRequestModel;
import com.kienast.apiservice.rest.api.model.ConnectionStatusModel;
import com.kienast.apiservice.rest.api.model.DestroyConnectionRequestModel;

@RestController
public class ConnectionController implements ConnectionApi {

	@Override
	public ResponseEntity<ConnectionCommandResponseModel> addCommand(
			@Valid ConnectionCommandRequestModel connectionCommandRequestModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ConnectionStatusModel> createConnection(
			@Valid ConnectionRequestModel connectionRequestModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ConnectionStatusModel> destroyConnection(
			@Valid DestroyConnectionRequestModel destroyConnectionRequestModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<List<ConnectionModel>> getActiveConnections() {
		// TODO Auto-generated method stub
		return null;
	}

}
