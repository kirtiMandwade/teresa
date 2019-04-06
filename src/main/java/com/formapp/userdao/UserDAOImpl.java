package com.formapp.userdao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.formapp.model.mysql.User;
import com.formapp.repository.UserRepository;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	private UserRepository userRepository;
	
	

	@Override
	public <S extends User> S save(S user) {
		return userRepository.save(user);
		
	}

	@Override
	public List<User> findAll() {

		return userRepository.findAll();
	}

	@Override
	public void deleteUser(String userId) {
//		 userRepository.delete(userId);
		
	}

	@Override
	public <S extends User> S updateUser(S user) {
//		User tempUser =userRepository.findOneB(user.getId());
//		
//		if(user.getPassword().isEmpty())
//		{
//			user.setPassword(tempUser.getPassword());
//		}	
//		
//		
	return null;
	}}
