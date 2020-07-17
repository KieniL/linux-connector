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

import com.kienast.apiservice.model.Token;
import com.kienast.apiservice.rest.api.ConnectionApi;
import com.kienast.apiservice.rest.api.model.ConnectionCommandRequestModel;
import com.kienast.apiservice.rest.api.model.ConnectionCommandResponseModel;
import com.kienast.apiservice.rest.api.model.ConnectionModel;
import com.kienast.apiservice.rest.api.model.ConnectionRequestModel;
import com.kienast.apiservice.rest.api.model.ConnectionStatusModel;
import com.kienast.apiservice.rest.api.model.DestroyConnectionRequestModel;

@RestController
public class ConnectionController implements ConnectionApi {

	//Used for WebTemplate
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@Value("${connURL}")
	private String connURL;
	
	@Override
	public ResponseEntity<ConnectionCommandResponseModel> addCommand(
			@Valid ConnectionCommandRequestModel connectionCommandRequestModel) {
		ConnectionCommandResponseModel model =
				webClientBuilder.build()
					.put() //RequestMethod
					.uri(connURL+"/connection")
					.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
					.body(BodyInserters.fromObject(connectionCommandRequestModel))
					.retrieve() //run command
					.bodyToMono(ConnectionCommandResponseModel.class) //convert Response
					.block(); //do as Synchronous call
		
		if(model != null) {
			return ResponseEntity.ok(model);
		}
		
		return ResponseEntity.badRequest().body(null);
	}

	@Override
	public ResponseEntity<ConnectionStatusModel> createConnection(
			@Valid ConnectionRequestModel connectionRequestModel) {
		ConnectionStatusModel model =
				webClientBuilder.build()
					.post() //RequestMethod
					.uri(connURL+"/connection")
					.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
					.body(BodyInserters.fromObject(connectionRequestModel))
					.retrieve() //run command
					.bodyToMono(ConnectionStatusModel.class) //convert Response
					.block(); //do as Synchronous call
		if(model != null) {
			return ResponseEntity.ok(model);
		}
		
		return ResponseEntity.badRequest().body(null);
	}

	@Override
	public ResponseEntity<ConnectionStatusModel> destroyConnection(
			@Valid DestroyConnectionRequestModel destroyConnectionRequestModel) {
		
		ConnectionStatusModel model =
				((RequestBodySpec) webClientBuilder.build()
					.head() //RequestMethod
					.uri(connURL+"/connection")
					.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE))
					.body(BodyInserters.fromObject(destroyConnectionRequestModel))
					.retrieve() //run command
					.bodyToMono(ConnectionStatusModel.class) //convert Response
					.block(); //do as Synchronous call
		if(model != null) {
			return ResponseEntity.ok(model);
		}
		
		return ResponseEntity.badRequest().body(null);
	}

	@Override
	public ResponseEntity<List<ConnectionModel>> getActiveConnections() {
		List<ConnectionModel> model =
				webClientBuilder.build()
					.get() //RequestMethod
					.uri(connURL+"/connection")
					.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
					.retrieve() //run command
					.bodyToFlux(ConnectionModel.class) //convert Response
					.collectList()
					.block(); //do as Synchronous call
		
		if(model != null && model.size() > 0) {
			return ResponseEntity.ok(model);
		}
		
		return ResponseEntity.badRequest().body(null);
	}

}
