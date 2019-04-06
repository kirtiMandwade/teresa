package com.formapp.userservice;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.formapp.error.InvalidFileException;
import com.formapp.model.mysql.User;

public interface UserService {
	
	public <S extends User> S save(S user);

	public List<User> findAll();
	
	public void deleteUser(String userId);

	public <S extends User> S updateUser(S user);
	File uploadFile(MultipartFile file, String uploadDirectory) throws InvalidFileException, IOException;

}
