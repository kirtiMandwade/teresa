package com.formapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formapp.model.mysql.Contribuciones;
import com.formapp.model.mysql.ContribucionesNivelPartida;
import com.formapp.model.mysql.TasasNivelPartida;

public interface TasasNivelPartidaRepository extends JpaRepository<TasasNivelPartida, Long>{
	List<TasasNivelPartidaRepository> findByNúmerodepedimento(long id);


}