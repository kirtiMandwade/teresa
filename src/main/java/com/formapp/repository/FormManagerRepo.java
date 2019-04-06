package com.formapp.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.formapp.model.FormManager;

public interface FormManagerRepo extends JpaRepository<FormManager, Integer> {

	FormManager findByFormid(String name);
	FormManager findById(int id);
	@Query("SELECT DISTINCT a.name FROM FormManager a")
	ArrayList<String> findDistinct();
	

}
