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
	private long número_de_pedimento;
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
	
	public String getIdentificador_transporte() {
		return identificador_transporte;
	}
	public void setIdentificador_transporte(String identificador_transporte) {
		this.identificador_transporte = identificador_transporte;
	}
	
	
	public long getNúmero_de_pedimento() {
		return número_de_pedimento;
	}
	public void setNúmero_de_pedimento(long número_de_pedimento) {
		this.número_de_pedimento = número_de_pedimento;
	}
	public String getNúmero_candado() {
		return número_candado;
	}
	public void setNúmero_candado(String número_candado) {
		this.número_candado = número_candado;
	}
	

	@Override
	public String toString() {
		return "Candados [id=" + id + ", clave_del_Tipo_de_Registro=" + clave_del_Tipo_de_Registro
				+ ", número_de_pedimento=" + número_de_pedimento + ", identificador_transporte="
				+ identificador_transporte + ", número_candado=" + número_candado + "]";
	}
	
	
	
	

	
	

}
