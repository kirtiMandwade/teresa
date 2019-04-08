package com.formapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formapp.model.mysql.Tasas;

public interface TasasRepository extends JpaRepository<Tasas, Long>{
	List<Tasas> findByNúmerodepedimento(long id);


}