	package com.formapp.model.mysql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="`516`")
public class Candados extends AuditBase {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private long id;
	
	private int clave_del_Tipo_de_Registro;
	private long número_Pedimento;
	private String identificador_transporte;
	@Column(length=21)
	private String número_candado;
	
	
	
	public Candados() {
	
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
	public long getNúmero_Pedimento() {
		return número_Pedimento;
	}
	public void setNúmero_Pedimento(long número_Pedimento) {
		this.número_Pedimento = número_Pedimento;
	}
	public String getIdentificador_transporte() {
		return identificador_transporte;
	}
	public void setIdentificador_transporte(String identificador_transporte) {
		this.identificador_transporte = identificador_transporte;
	}
	public String getNúmero_candado() {
		return número_candado;
	}
	public void setNúmero_candado(String número_candado) {
		this.número_candado = número_candado;
	}
	

	@Override
	public String toString() {
		return "Candados [id=" + id + ", clave_del_Tipo_de_Registro=" + clave_del_Tipo_de_Registro + ", número_Pedimento="
				+ número_Pedimento + ", identificador_transporte=" + identificador_transporte + ", número_candado="
				+ número_candado + "]";
	}
	
	
	
	

	
	

}
