package com.kienast.authservice.repository;

import java.util.Optional;

import com.kienast.authservice.model.User;


public interface UserRepository {

	Optional<User> findUser(String email);
}
