package com.user.registration.initializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.user.registration.entities.User;
import com.user.registration.repositiory.UserRepository;

@SpringBootApplication
@ComponentScan({"com.user.registration"})
@EntityScan("com.user.registration.entities")
@EnableJpaRepositories("com.user.registration")
public class UserRegistrationApplication implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(UserRegistrationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userRepository.save(new User("piyush", "Goyal", "21071988", "male", "IT"));
		System.out.println(userRepository.findAll().get(0).getId());
	}

}

