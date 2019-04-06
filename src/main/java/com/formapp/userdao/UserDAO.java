package com.formapp.userdao;

import java.util.List;

import com.formapp.model.mysql.User;

public interface UserDAO {

	public <S extends User> S save(S user);

	public List<User> findAll();

	public void deleteUser(String userId);

	public <S extends User> S updateUser(S user);
}
