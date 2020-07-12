package com.kienast.connectorservice.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.kienast.connectorservice.model.ConnectionStore;

@Component
public class ConnectionStoreRepositoryImpl implements ConnectionStoreRepository {

	@Override
	public List<ConnectionStore> getStoredConnections() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ConnectionStore save(ConnectionStore connStore) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ConnectionStore update(ConnectionStore connStore) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(ConnectionStore connStore) {
		// TODO Auto-generated method stub
		return false;
	}

}
