package com.user.registration.dao;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.user.registration.entities.User;
import com.user.registration.repositiory.UserRepository;

@Repository("userDao")
public class UserDaoImpl implements UserDao{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUser(Long id) {
		return getUserList(id);
	}

	@Override
	public boolean deleteUser(Long id) {
		userRepository.delete(getUserList(id));
		return true;
	}

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user) {
		return userRepository.save(user);
	}

	private User getUserList(Long id) {
		List<User> users = getUsers();
		User user = users.stream().filter(temp -> temp.getId() == id).collect(Collectors.toList()).get(0);

		return user;
	}
}
