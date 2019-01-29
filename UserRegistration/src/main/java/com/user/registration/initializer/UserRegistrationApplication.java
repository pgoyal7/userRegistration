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
		userRepository.save(new User("shilpi", "Goyal", "10081989", "female", "Travel"));
		userRepository.save(new User("honey", "Goyal", "25061990", "female", "IT"));
	}

}

