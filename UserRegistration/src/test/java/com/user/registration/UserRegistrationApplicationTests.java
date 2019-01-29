package com.user.registration;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.user.registration.entities.User;
import com.user.registration.initializer.UserRegistrationApplication;
import com.user.registration.repositiory.UserRepository;
import com.user.registration.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = UserRegistrationApplication.class)
public class UserRegistrationApplicationTests {
	List<User> userList = new ArrayList<User>();
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Before
	public void setUpTestData() {
		userList = new ArrayList<User>();
		
		userList.add(new User("Rohit", "Goyal", "21071988", "M", "IT"));
		userList.add(new User("Rinki", "Gupta", "10081977", "F", "Travel"));
		userList.add(new User("Shyam", "Singh", "10011980", "M", "Travel"));
		
		userList.stream().forEach(user -> userRepository.save(user));
	}
	
	
	@Test
	public void testGetUserList() {
		List<User> users = userService.getUsers();
		User[] actualUserList= users.toArray(new User[users.size()]);
		User [] expectedUserList = userList.toArray(new User[userList.size()]);
		
		assertArrayEquals(expectedUserList, actualUserList);
	}

	@Test
	public void testGetUserWithExistingId() {
		User user= userService.getUser(1l);
		System.out.println("hello");
	}
	
	@Test
	public void testGetUserWithoutExistingId() {
		User user= userService.getUser(4l);
		System.out.println("hello");
	}
	
	@Test
	public void testUpdateUser() {
		User user= userService.getUser(1l);
		user.setDepartment("XYZ");
		userService.createUser(user);
		System.out.println("hello");
	}
	
	@Test
	public void testDeleteUser() {
		boolean deleteUserConfirmation= userService.deleteUser(1l);
		System.out.println("hello");
	}
	
	@Test
	public void testCreateUser() {
		User createdUser = userService.createUser(new User("Ankur", "Agrawal", "30091986", "M", "Finance"));
		System.out.println("hello");
	}
	
}
