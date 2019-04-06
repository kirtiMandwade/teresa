package com.formapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formapp.model.mysql.Pedimento;

public interface PedimentoRepository extends JpaRepository<Pedimento, Long>{


}