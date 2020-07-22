package com.kienast.authservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kienast.authservice.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
