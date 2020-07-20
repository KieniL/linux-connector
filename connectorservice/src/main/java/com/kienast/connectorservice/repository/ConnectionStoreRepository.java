package com.kienast.connectorservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kienast.connectorservice.model.ConnectionStoreEntity;

@Repository
public interface ConnectionStoreRepository extends JpaRepository<ConnectionStoreEntity, Long> {

}
