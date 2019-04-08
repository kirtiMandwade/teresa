package com.formapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formapp.model.mysql.Contribuciones;
import com.formapp.model.mysql.ContribucionesNivelPartida;

public interface ContribucionNivelPartidaRepository extends JpaRepository<ContribucionesNivelPartida, Long>{
	List<ContribucionesNivelPartida> findByNúmerodepedimento(long id);


}