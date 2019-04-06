package com.formapp.model.mysql;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="`515`")
public class IndustriaAutomotriz extends AuditBase {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private long id;
	
	private int clave_del_Tipo_de_Registro;
	private int patente_autorización;
	private long número_Pedimento;
	private String aduana_sección_despacho ;
	private String CURP_Agente;
	private String clave_pedimento;
	private String aduana_sección_entrada ;
	private String RFC_Empresa; 
	
	

	private double tipo_Cambio ;

	public int getClave_del_Tipo_de_Registro() {
		return clave_del_Tipo_de_Registro;
	}

	public void setClave_del_Tipo_de_Registro(int clave_del_Tipo_de_Registro) {
		this.clave_del_Tipo_de_Registro = clave_del_Tipo_de_Registro;
	}
	
	public IndustriaAutomotriz() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}



	public int getPatente_autorización() {
		return patente_autorización;
	}

	public void setPatente_autorización(int patente_autorización) {
		this.patente_autorización = patente_autorización;
	}

	public long getNúmero_Pedimento() {
		return número_Pedimento;
	}

	public void setNúmero_Pedimento(long número_Pedimento) {
		this.número_Pedimento = número_Pedimento;
	}

	public String getAduana_sección_despacho() {
		return aduana_sección_despacho;
	}

	public void setAduana_sección_despacho(String aduana_sección_despacho) {
		this.aduana_sección_despacho = aduana_sección_despacho;
	}

	public String getCURP_Agente() {
		return CURP_Agente;
	}

	public void setCURP_Agente(String cURP_Agente) {
		CURP_Agente = cURP_Agente;
	}

	public String getClave_pedimento() {
		return clave_pedimento;
	}

	public void setClave_pedimento(String clave_pedimento) {
		this.clave_pedimento = clave_pedimento;
	}

	public String getAduana_sección_entrada() {
		return aduana_sección_entrada;
	}

	public void setAduana_sección_entrada(String aduana_sección_entrada) {
		this.aduana_sección_entrada = aduana_sección_entrada;
	}

	public String getRFC_Empresa() {
		return RFC_Empresa;
	}

	public void setRFC_Empresa(String rFC_Empresa) {
		RFC_Empresa = rFC_Empresa;
	}

	public double getTipo_Cambio() {
		return tipo_Cambio;
	}

	public void setTipo_Cambio(double tipo_Cambio) {
		this.tipo_Cambio = tipo_Cambio;
	}

	@Override
	public String toString() {
		return "IndustriaAutomotriz [id=" + id + ", clave_del_Tipo_de_Registro=" + clave_del_Tipo_de_Registro
				+ ", patente_autorización=" + patente_autorización + ", número_Pedimento=" + número_Pedimento
				+ ", aduana_sección_despacho=" + aduana_sección_despacho + ", CURP_Agente=" + CURP_Agente
				+ ", clave_pedimento=" + clave_pedimento + ", aduana_sección_entrada=" + aduana_sección_entrada
				+ ", RFC_Empresa=" + RFC_Empresa + ", tipo_Cambio=" + tipo_Cambio + "]";
	}
	
	
	
	


}
