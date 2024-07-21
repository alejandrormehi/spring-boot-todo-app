package com.example.spring_boot_todo_app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_boot_todo_app.models.User;
import com.example.spring_boot_todo_app.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	public Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}
}
