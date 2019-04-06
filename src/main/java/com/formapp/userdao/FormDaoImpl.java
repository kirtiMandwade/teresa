package com.formapp.userdao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.formapp.model.FormData;
import com.formapp.repository.FormDataRepository;

@Repository
@Transactional
public class FormDaoImpl {

	@Autowired
	private FormDataRepository formDataRepository;

	public List<FormData> getAll() {
		return formDataRepository.findAll();

	}
	
	
	public <S extends FormData> FormData save(FormData formData) {
		return formDataRepository.save(formData);
		
	}
	
	public ArrayList<FormData> findByCodeIn(ArrayList<String> arrCode){
		return formDataRepository.findByCodeIn(arrCode);
	}
	
	public FormData findByCode(String arrCode) {
		return formDataRepository.findByCode(arrCode);
	}

}
