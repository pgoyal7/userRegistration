package com.user.registration.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.registration.entities.User;
import com.user.registration.repositiory.UserRepository;
import com.user.registration.service.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	/*
	 * Get the list of the users
	 * 
	 * */
	@RequestMapping("/users")
	public List<User> getUsers() {
		return userService.getUsers();
	}

	/*
	 * Get the user by using id
	 * 
	 * */
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable Long id) {
		return userService.getUser(id);
	}

	/*
	 * delete the user by the given id
	 * 
	 * */
	@DeleteMapping("/user/{id}")
	public boolean deleteUser(@PathVariable Long id) {
		return userService.deleteUser(id);
	}

	/*
	 * Save the user in the database
	 * 
	 * */
	@PostMapping("/user")
	public User createUser(@RequestBody User user) {
		return userRepository.save(user);
	}

	/*
	 * update the user in the database
	 * 
	 * */
	@PutMapping("/user")
	public User updateUser(@RequestBody User user) {
		return userRepository.save(user);
	}
}
