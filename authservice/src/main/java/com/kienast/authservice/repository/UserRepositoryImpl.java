package com.kienast.authservice.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.kienast.authservice.model.User;

@Component
public class UserRepositoryImpl implements UserRepository {

	private List<User> users = new ArrayList<>();

	// TODO nur temporär, wird dann später im service gemacht, nur um dummy data zu
	// initializieren
	@Autowired
	private PasswordEncoder passwordEncoder;

	
	@PostConstruct
	public void initDummyData() {
		users.add(new User("1", "test1234@gmail.com", passwordEncoder.encode("password")));
		users.add(new User("2", "testuser@gmail.com", passwordEncoder.encode("password")));
	}

	@Override
	public Optional<User> findUser(String email) {
		return users.stream().filter(item -> item.getEmail().equals(email)).findFirst();
	}

}
