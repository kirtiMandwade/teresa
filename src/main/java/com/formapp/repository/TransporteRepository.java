package com.formapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formapp.model.mysql.Generales;
import com.formapp.model.mysql.Transporte;

public interface TransporteRepository extends JpaRepository<Transporte, Long>{


}