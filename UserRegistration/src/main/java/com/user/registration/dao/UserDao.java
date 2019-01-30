package com.user.registration.dao;

import java.util.List;

import com.user.registration.entities.User;

public interface UserDao {
	List<User> getUsers();

	User getUser(Long id);

	boolean deleteUser(Long id);

	User createUser(User user);

	User updateUser(User user);
}
