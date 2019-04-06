package com.formapp.model.mysql;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="`504`")
public class Contenedores extends AuditBase {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private long id;
	
	private int Clave_del_Tipo_de_Registro;
	private long Número_de_Pedimento;
	private String Número_de_Contenedor;
	private int Tipo_de_Contenedor;
	public Contenedores() {
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getClave_del_Tipo_de_Registro() {
		return Clave_del_Tipo_de_Registro;
	}
	public void setClave_del_Tipo_de_Registro(int clave_del_Tipo_de_Registro) {
		Clave_del_Tipo_de_Registro = clave_del_Tipo_de_Registro;
	}
	public long getNúmero_de_Pedimento() {
		return Número_de_Pedimento;
	}
	public void setNúmero_de_Pedimento(long número_de_Pedimento) {
		Número_de_Pedimento = número_de_Pedimento;
	}
	public String getNúmero_de_Contenedor() {
		return Número_de_Contenedor;
	}
	public void setNúmero_de_Contenedor(String número_de_Contenedor) {
		Número_de_Contenedor = número_de_Contenedor;
	}
	public int getTipo_de_Contenedor() {
		return Tipo_de_Contenedor;
	}
	public void setTipo_de_Contenedor(int tipo_de_Contenedor) {
		Tipo_de_Contenedor = tipo_de_Contenedor;
	}
	
	@Override
	public String toString() {
		return "Contenedores [id=" + id + ", Clave_del_Tipo_de_Registro=" + Clave_del_Tipo_de_Registro
				+ ", Número_de_Pedimento=" + Número_de_Pedimento + ", Número_de_Contenedor=" + Número_de_Contenedor
				+ ", Tipo_de_Contenedor=" + Tipo_de_Contenedor + "]";
	}



}
