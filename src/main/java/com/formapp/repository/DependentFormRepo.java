package com.formapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formapp.model.Appendice;
import com.formapp.model.DependentForm;

public interface DependentFormRepo extends JpaRepository<DependentForm, String> {
	 
	List<DependentForm> findByFormidAndFormmanagerid(String formid,long formmanagerid);
	List<DependentForm> findByFormmanageridOrderByCode(long formmanagerid);
	DependentForm findByDependentFormIdAndFormmanagerid(String DependentForm,long formmanagerid);
	
}
