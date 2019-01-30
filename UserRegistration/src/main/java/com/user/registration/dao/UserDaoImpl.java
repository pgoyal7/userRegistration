package com.user.registration.dao;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.user.registration.entities.User;
import com.user.registration.repositiory.UserRepository;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private UserRepository userRepository;

	/*
	 * Get the list of the users
	 * 
	 * */
	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	/*
	 * Get the user by using the id
	 * 
	 * */
	@Override
	public User getUser(Long id) {
		return getUserList(id);
	}
	
	/*
	 * delete the user by given id
	 * 
	 * */
	@Override
	public boolean deleteUser(Long id) {
		userRepository.delete(getUserList(id));
		return true;
	}

	/*
	 * save the new user into the database
	 * 
	 * */
	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	/*
	 * update the existing user in the database
	 * 
	 * */
	@Override
	public User updateUser(User user) {
		return userRepository.save(user);
	}

	private User getUserList(Long id) {
		List<User> users = getUsers();
		User user = null;
		users = users.stream().filter(temp -> temp.getId() == id).collect(Collectors.toList());

		if (users.size() > 0) {
			user = users.get(0);
		}

		return user;
	}
}
