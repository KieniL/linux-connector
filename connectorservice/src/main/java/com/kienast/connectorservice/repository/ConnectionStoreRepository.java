package com.kienast.connectorservice.repository;

import java.util.List;

import com.kienast.connectorservice.command.DestroyConnectionStoreCommand;
import com.kienast.connectorservice.command.UpdateConnectionStoreCommand;
import com.kienast.connectorservice.model.ConnectionStore;
import com.kienast.connectorservice.model.ConnectionStoreStatus;

public interface ConnectionStoreRepository {

	List<ConnectionStore> getConnections();
	
	ConnectionStoreStatus save(ConnectionStore connStore);
	
	ConnectionStoreStatus update(UpdateConnectionStoreCommand connStore);
	
	ConnectionStoreStatus delete(DestroyConnectionStoreCommand connStore);
	
	ConnectionStore findByString(int storeId);
}
