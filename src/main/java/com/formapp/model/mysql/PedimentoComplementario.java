package com.formapp.model.mysql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="`301`")
public class PedimentoComplementario extends AuditBase {


	
	public PedimentoComplementario() {
		
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private long id;
	
	private int clave_del_Tipo_de_Registro;
	private int patente_autorización;
	private long número_Pedimento;
	
	private String aduana_sección_despacho ;
	private String clave_pedimento;
	private double tipo_Cambio ;
	private String RFC_Exportador; 
	private String CURP_Exportador;
	@Column(length=120)
	private String número_Exportador ;
	
	private String CURP_agente_aduanal_representante;
	private String RFC_Facturación_Servicios ;
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
	public String getClave_pedimento() {
		return clave_pedimento;
	}
	public void setClave_pedimento(String clave_pedimento) {
		this.clave_pedimento = clave_pedimento;
	}
	public double getTipo_Cambio() {
		return tipo_Cambio;
	}
	public void setTipo_Cambio(double tipo_Cambio) {
		this.tipo_Cambio = tipo_Cambio;
	}
	public String getRFC_Exportador() {
		return RFC_Exportador;
	}
	public void setRFC_Exportador(String rFC_Exportador) {
		RFC_Exportador = rFC_Exportador;
	}
	public String getCURP_Exportador() {
		return CURP_Exportador;
	}
	public void setCURP_Exportador(String cURP_Exportador) {
		CURP_Exportador = cURP_Exportador;
	}
	public String getNúmero_Exportador() {
		return número_Exportador;
	}
	public void setNúmero_Exportador(String número_Exportador) {
		this.número_Exportador = número_Exportador;
	}
	public String getCURP_agente_aduanal_representante() {
		return CURP_agente_aduanal_representante;
	}
	public void setCURP_agente_aduanal_representante(String cURP_agente_aduanal_representante) {
		CURP_agente_aduanal_representante = cURP_agente_aduanal_representante;
	}
	public String getRFC_Facturación_Servicios() {
		return RFC_Facturación_Servicios;
	}
	public void setRFC_Facturación_Servicios(String rFC_Facturación_Servicios) {
		RFC_Facturación_Servicios = rFC_Facturación_Servicios;
	}
	
	
	@Override
	public String toString() {
		return "PedimentoComplementario [id=" + id + ", clave_del_Tipo_de_Registro=" + clave_del_Tipo_de_Registro
				+ ", patente_autorización=" + patente_autorización + ", número_Pedimento=" + número_Pedimento
				+ ", aduana_sección_despacho=" + aduana_sección_despacho + ", clave_pedimento=" + clave_pedimento
				+ ", tipo_Cambio=" + tipo_Cambio + ", RFC_Exportador=" + RFC_Exportador + ", CURP_Exportador="
				+ CURP_Exportador + ", número_Exportador=" + número_Exportador + ", CURP_agente_aduanal_representante="
				+ CURP_agente_aduanal_representante + ", RFC_Facturación_Servicios=" + RFC_Facturación_Servicios + "]";
	}

	

}
