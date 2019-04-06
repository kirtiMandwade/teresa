package com.formapp.model.mysql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="`552`")
public class Mercancías extends AuditBase {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private long id;
	
	private int clave_del_Tipo_de_Registro; 
	private long número_pedimento; 
	
	private String fracción_Arancelaria ; 
	private int número_Partida ; 
	@Column(length=25)
	private String número_identificación_vehicular; 
	private long kilometraje_vehículo ;
	
	
	
	public Mercancías() {
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getclave_del_Tipo_de_Registro() {
		return clave_del_Tipo_de_Registro;
	}
	public void setclave_del_Tipo_de_Registro(int clave_del_Tipo_de_Registro) {
		this.clave_del_Tipo_de_Registro = clave_del_Tipo_de_Registro;
	}
	public long getNúmero_pedimento() {
		return número_pedimento;
	}
	public void setNúmero_pedimento(long número_pedimento) {
		this.número_pedimento = número_pedimento;
	}
	public String getFracción_Arancelaria() {
		return fracción_Arancelaria;
	}
	public void setFracción_Arancelaria(String fracción_Arancelaria) {
		this.fracción_Arancelaria = fracción_Arancelaria;
	}
	public int getNúmero_Partida() {
		return número_Partida;
	}
	public void setNúmero_Partida(int número_Partida) {
		this.número_Partida = número_Partida;
	}
	public String getNúmero_identificación_vehicular() {
		return número_identificación_vehicular;
	}
	public void setNúmero_identificación_vehicular(String número_identificación_vehicular) {
		this.número_identificación_vehicular = número_identificación_vehicular;
	}
	public long getKilometraje_vehículo() {
		return kilometraje_vehículo;
	}
	public void setKilometraje_vehículo(long kilometraje_vehículo) {
		this.kilometraje_vehículo = kilometraje_vehículo;
	}
	
	
	@Override
	public String toString() {
		return "Mercancías [id=" + id + ", clave_del_Tipo_de_Registro=" + clave_del_Tipo_de_Registro + ", número_pedimento="
				+ número_pedimento + ", fracción_Arancelaria=" + fracción_Arancelaria + ", número_Partida="
				+ número_Partida + ", número_identificación_vehicular=" + número_identificación_vehicular
				+ ", kilometraje_vehículo=" + kilometraje_vehículo + "]";
	}
	
	

}
