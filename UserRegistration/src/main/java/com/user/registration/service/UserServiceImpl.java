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
	
	@Override
	public List<User> getUsers() {
		return userDao.getUsers();
	}

	@Override
	public User getUser(Long id) {
		return userDao.getUser(id);
	}

	@Override
	public boolean deleteUser(Long id) {
		return userDao.deleteUser(id);
	}

	@Override
	public User createUser(User user) {
		return userDao.createUser(user);
	}

	@Override
	public User updateUser(User user) {
		return userDao.updateUser(user);
	}

	
}
