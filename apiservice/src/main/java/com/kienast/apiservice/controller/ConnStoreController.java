package com.kienast.apiservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestBodySpec;

import com.kienast.apiservice.rest.api.ConnstoreApi;
import com.kienast.apiservice.rest.api.model.ConnectionCommandResponseModel;
import com.kienast.apiservice.rest.api.model.ConnectionModel;
import com.kienast.apiservice.rest.api.model.ConnectionStoreModel;
import com.kienast.apiservice.rest.api.model.ConnectionStoreStatusModel;
import com.kienast.apiservice.rest.api.model.DeleteConnectionStoreRequestModel;

@RestController
public class ConnStoreController implements ConnstoreApi {
	
	//Used for WebTemplate
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@Value("${connURL}")
	private String connURL;

	@Override
	public ResponseEntity<ConnectionStoreStatusModel> addConnectionStore(
			@Valid ConnectionStoreModel connectionStoreModel) {
		ConnectionStoreStatusModel model =
				webClientBuilder.build()
					.post() //RequestMethod
					.uri(connURL+"/connstore")
					.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
					.body(BodyInserters.fromObject(connectionStoreModel))
					.retrieve() //run command
					.bodyToMono(ConnectionStoreStatusModel.class) //convert Response
					.block(); //do as Synchronous call
		
		if(model != null) {
			return ResponseEntity.ok(model);
		}
		
		return ResponseEntity.badRequest().body(null);
	}

	
	@Override
	public ResponseEntity<ConnectionStoreStatusModel> deleteConnectionStore(
			@Valid DeleteConnectionStoreRequestModel deleteConnectionStoreRequestModel) {
		ConnectionStoreStatusModel model =
				((RequestBodySpec) webClientBuilder.build()
					.head() //RequestMethod
					.uri(connURL+"/connstore")
					.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE))
					.body(BodyInserters.fromObject(deleteConnectionStoreRequestModel))
					.retrieve() //run command
					.bodyToMono(ConnectionStoreStatusModel.class) //convert Response
					.block(); //do as Synchronous call
		
		if(model != null) {
			return ResponseEntity.ok(model);
		}
		
		return ResponseEntity.badRequest().body(null);
	}

	@Override
	public ResponseEntity<List<ConnectionStoreModel>> getConnectionStores() {
		List<ConnectionStoreModel> model =
				webClientBuilder.build()
					.get() //RequestMethod
					.uri(connURL+"/connstore")
					.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
					.retrieve() //run command
					.bodyToFlux(ConnectionStoreModel.class) //convert Response
					.collectList()
					.block(); //do as Synchronous call
		
		if(model != null) {
			return ResponseEntity.ok(model);
		}
		
		return ResponseEntity.badRequest().body(null);
	}

	@Override
	public ResponseEntity<ConnectionStoreStatusModel> updateConnectionStore(String storeId,
			@Valid ConnectionStoreModel connectionStoreModel) {
		ConnectionStoreStatusModel model =
				webClientBuilder.build()
					.post() //RequestMethod
					.uri(connURL+"/connstore/"+storeId)
					.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
					.body(BodyInserters.fromObject(connectionStoreModel))
					.retrieve() //run command
					.bodyToMono(ConnectionStoreStatusModel.class) //convert Response
					.block(); //do as Synchronous call
		
		if(model != null) {
			return ResponseEntity.ok(model);
		}
		
		return ResponseEntity.badRequest().body(null);
	}



}
