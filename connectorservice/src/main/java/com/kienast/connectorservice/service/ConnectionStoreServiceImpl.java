package com.kienast.connectorservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kienast.connectorservice.command.CreateConnectionStoreCommand;
import com.kienast.connectorservice.command.DestroyConnectionStoreCommand;
import com.kienast.connectorservice.command.UpdateConnectionStoreCommand;
import com.kienast.connectorservice.model.ConnectionStore;
import com.kienast.connectorservice.model.ConnectionStoreStatus;
import com.kienast.connectorservice.repository.ConnectionStoreRepository;
import com.kienast.connectorservice.usecase.AddStoredConnection;
import com.kienast.connectorservice.usecase.DeleteStoredConnection;
import com.kienast.connectorservice.usecase.GetStoredConnections;
import com.kienast.connectorservice.usecase.UpdateStoredConnection;

@Component
public class ConnectionStoreServiceImpl implements ConnectionStoreService {

	@Autowired
	private ConnectionStoreRepository connectionStoreRepository;
	
	@Override
	public List<ConnectionStore> getStoredConnections() {
		return new GetStoredConnections(connectionStoreRepository).getConnections();
	}

	@Override
	public ConnectionStoreStatus addStoredConnection(CreateConnectionStoreCommand command) {
		return new AddStoredConnection(connectionStoreRepository, command).addConnection();
	}

	@Override
	public ConnectionStoreStatus updateStoredConnection(UpdateConnectionStoreCommand command) {
		return new UpdateStoredConnection(connectionStoreRepository, command).updateConnection();
	}

	@Override
	public ConnectionStoreStatus deleteStoredConnection(DestroyConnectionStoreCommand command) {
		// TODO Auto-generated method stub
		return new DeleteStoredConnection(connectionStoreRepository, command).destroyConnection();
	}



	

}
