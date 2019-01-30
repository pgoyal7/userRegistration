package com.user.registration.service;

import java.util.List;

import com.user.registration.entities.User;

public interface UserService {

	List<User> getUsers();

	User getUser(Long id);

	boolean deleteUser(Long id);

	User createUser(User user);

	User updateUser(User user);

}
