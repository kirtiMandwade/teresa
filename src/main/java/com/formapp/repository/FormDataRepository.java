package com.formapp.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formapp.model.FormData;

public interface FormDataRepository extends JpaRepository<FormData, String> {

	ArrayList<FormData> findByCodeIn(ArrayList<String> arrCode);
	FormData findByCode(String arrCode);
	FormData findByFormid(String formid);
	
	//findByMandatoryAndF

}
