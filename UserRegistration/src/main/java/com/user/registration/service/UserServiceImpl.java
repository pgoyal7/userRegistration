package com.user.registration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.registration.dao.UserDao;
import com.user.registration.entities.User;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	/*
	 * Get the list of the users
	 * 
	 * */
	@Override
	public List<User> getUsers() {
		return userDao.getUsers();
	}

	/*
	 * Get the user by using id
	 * 
	 * */
	@Override
	public User getUser(Long id) {
		return userDao.getUser(id);
	}

	/*
	 * delete the user using given id
	 * 
	 * */
	@Override
	public boolean deleteUser(Long id) {
		return userDao.deleteUser(id);
	}

	/*
	 * create the new user in the database
	 * 
	 * */
	@Override
	public User createUser(User user) {
		return userDao.createUser(user);
	}

	/*
	 * update the existing user in the database
	 * 
	 * */
	@Override
	public User updateUser(User user) {
		return userDao.updateUser(user);
	}

}
