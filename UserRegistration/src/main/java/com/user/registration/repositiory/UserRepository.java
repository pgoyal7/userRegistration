package com.user.registration.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.registration.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
