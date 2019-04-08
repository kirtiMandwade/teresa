package com.formapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formapp.model.mysql.Contribuciones;

public interface ContribucionRepository extends JpaRepository<Contribuciones, Long>{
	List<Contribuciones> findByNúmerodepedimento(long id);


}