package com.user.registration;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
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
	static List<User> userList = new ArrayList<User>();

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	/*
	 * Data setup before every test
	 * 
	 * */
	@Before
	public void setUpTestData() {
		userList = new ArrayList<User>();

		userList.add(new User("Rohit", "Goyal", "21071988", "M", "IT"));
		userList.add(new User("Rinki", "Gupta", "10081977", "F", "Travel"));
		userList.add(new User("Shyam", "Singh", "10011980", "M", "Travel"));

		userList.stream().forEach(user -> userRepository.save(user));
	}

	/*
	 * test to Get the list of the users
	 * 
	 * */
	@Test
	public void testGetUserList() {
		List<User> users = userService.getUsers();
		User[] actualUserList = users.toArray(new User[users.size()]);
		User[] expectedUserList = userList.toArray(new User[userList.size()]);

		for (int index = 0; index < actualUserList.length && index < expectedUserList.length; index++) {

			assertEquals(expectedUserList[index].getId(), actualUserList[index].getId());
		}
	}

	/*
	 * test Get the user using given id
	 * 
	 * */
	@Test
	public void testGetUserWithExistingId() {
		Long id = 14l;
		User actualResult = userService.getUser(id);

		assertEquals(id, actualResult.getId());
	}

	/*
	 * test to Get the user without existing id
	 * 
	 * */
	@Test
	public void testGetUserWithoutExistingId() {
		assertEquals(null, userService.getUser(27l));
	}

	/*
	 * test to update the user using given id
	 * 
	 * */
	@Test
	public void testUpdateUser() {
		Long id = 1l;
		User expectedUser = new User("Rohit", "Goyal", "21071988", "M", "XYZ");
		User actualUpdatedUser = null;
		for (User userTemp : userList) {
			if (userTemp.getId() == id) {
				userTemp.setDepartment("XYZ");
				actualUpdatedUser = userService.updateUser(userTemp);
				break;
			}
		}

		assertEquals(expectedUser.getDepartment(), actualUpdatedUser.getDepartment());
	}

	/*
	 * test to delete the user with existing id
	 * 
	 * */
	@Test
	public void testDeleteUserWithExistingID() {
		Long id = 7l;
		boolean expectedDeleteUserConfirmation = true;
		boolean actualDeleteUserConfirmation = false;
		for (User user : userList) {
			if (user.getId() == id) {
				userList.remove(user);
				actualDeleteUserConfirmation = userService.deleteUser(id);
				break;
			}
		}

		assertEquals(expectedDeleteUserConfirmation, actualDeleteUserConfirmation);
	}

	/*
	 * test to delete the user without existing id
	 * 
	 * */
	@Test
	public void testDeleteUserWithoutExistingID() {
		Long id = 99l;
		boolean expectedDeleteUserConfirmation = false;
		boolean actualDeleteUserConfirmation = false;
		for (User user : userList) {
			if (user.getId() == id) {
				userList.remove(user);
				actualDeleteUserConfirmation = userService.deleteUser(id);
				break;
			}
		}

		assertEquals(expectedDeleteUserConfirmation, actualDeleteUserConfirmation);
	}

	/*
	 * test to create the user in the database
	 * 
	 * */
	@Test
	public void testCreateUser() {
		User expectedUser = new User("Ankur", "Agrawal", "30091986", "M", "Finance");
		User actualCreatedUser = userService.createUser(new User("Ankur", "Agrawal", "30091986", "M", "Finance"));
		userList.add(actualCreatedUser);

		assertEquals(expectedUser.getDepartment(), actualCreatedUser.getDepartment());
	}

	/*
	 * cleanup after every test case
	 * 
	 * */
	@After
	public void tearDown() {
		userList = null;
		userRepository.deleteAll();
	}

}
