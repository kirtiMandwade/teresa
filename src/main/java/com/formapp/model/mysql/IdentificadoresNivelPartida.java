package com.formapp.model.mysql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="`554`")
public class IdentificadoresNivelPartida  extends AuditBase {


	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private long id;
	
	private int clave_del_Tipo_de_Registro; 
	private long número_de_pedimento; 
	private String fracción_Arancelaria  ;
	private int número_Partida;
	private String clave_identificador ;

	@Column(length=20)
	private String Complemento1 ;
	@Column(length=50)
	private String Complemento2  ;
	@Column(length=40)
	private String Complemento3  ;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getClave_del_Tipo_de_Registro() {
		return clave_del_Tipo_de_Registro;
	}
	public void setClave_del_Tipo_de_Registro(int clave_del_Tipo_de_Registro) {
		this.clave_del_Tipo_de_Registro = clave_del_Tipo_de_Registro;
	}
	public long getNúmero_de_pedimento() {
		return número_de_pedimento;
	}
	public void setNúmero_de_pedimento(long número_de_pedimento) {
		this.número_de_pedimento = número_de_pedimento;
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
	public String getClave_identificador() {
		return clave_identificador;
	}
	public void setClave_identificador(String clave_identificador) {
		this.clave_identificador = clave_identificador;
	}
	public String getComplemento1() {
		return Complemento1;
	}
	public void setComplemento1(String complemento1) {
		Complemento1 = complemento1;
	}
	public String getComplemento2() {
		return Complemento2;
	}
	public void setComplemento2(String complemento2) {
		Complemento2 = complemento2;
	}
	public String getComplemento3() {
		return Complemento3;
	}
	public void setComplemento3(String complemento3) {
		Complemento3 = complemento3;
	}
	@Override
	public String toString() {
		return "IdentificadoresNivelPartida [id=" + id + ", clave_del_Tipo_de_Registro=" + clave_del_Tipo_de_Registro
				+ ", número_de_pedimento=" + número_de_pedimento + ", fracción_Arancelaria=" + fracción_Arancelaria
				+ ", número_Partida=" + número_Partida + ", clave_identificador=" + clave_identificador
				+ ", Complemento1=" + Complemento1 + ", Complemento2=" + Complemento2 + ", Complemento3=" + Complemento3
				+ "]";
	}

}
