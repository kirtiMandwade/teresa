package com.formapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formapp.model.Appendice;



public interface Appendice1Repository extends JpaRepository<Appendice, String> {

	Appendice findByAppendiceName(String appName);

}
