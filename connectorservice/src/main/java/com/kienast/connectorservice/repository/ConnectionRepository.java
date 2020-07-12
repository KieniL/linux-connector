package com.kienast.connectorservice.repository;

import java.util.List;

import com.kienast.connectorservice.model.ConnectionStatus;
import com.kienast.connectorservice.model.ConnectionStore;


public interface ConnectionRepository {
	
	ConnectionStatus save();
	
	ConnectionStatus delete();
	
	List<ConnectionStore> getActiveConnections();
	

}
