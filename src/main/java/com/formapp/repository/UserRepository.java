package com.formapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formapp.model.mysql.User;

public interface UserRepository  extends JpaRepository<User, Long>{

	User findByUsername(String username);

}
