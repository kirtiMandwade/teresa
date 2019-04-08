package com.formapp.model.mysql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="`800`")
public class FirmaElectrónicaPedimento extends AuditBase {


	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private long id;
	
	private int clave_del_Tipo_de_Registro; 
	private long número_de_pedimento;
	private int tipo_figura;
	@Column(length=360)
	private String firma_electrónica_avanzada_agente ;
	@Column(length=25)
	private String número_serie_certificado_firma;
	
	
	
	public FirmaElectrónicaPedimento() {
		
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
	
	public long getNúmero_de_pedimento() {
		return número_de_pedimento;
	}
	public void setNúmero_de_pedimento(long número_de_pedimento) {
		this.número_de_pedimento = número_de_pedimento;
	}
	public int getTipo_figura() {
		return tipo_figura;
	}
	public void setTipo_figura(int tipo_figura) {
		this.tipo_figura = tipo_figura;
	}
	public String getFirma_electrónica_avanzada_agente() {
		return firma_electrónica_avanzada_agente;
	}
	public void setFirma_electrónica_avanzada_agente(String firma_electrónica_avanzada_agente) {
		this.firma_electrónica_avanzada_agente = firma_electrónica_avanzada_agente;
	}
	public String getNúmero_serie_certificado_firma() {
		return número_serie_certificado_firma;
	}
	public void setNúmero_serie_certificado_firma(String número_serie_certificado_firma) {
		this.número_serie_certificado_firma = número_serie_certificado_firma;
	}
	@Override
	public String toString() {
		return "FirmaElectrónicaPedimento [id=" + id + ", clave_del_Tipo_de_Registro=" + clave_del_Tipo_de_Registro
				+ ", número_de_pedimento=" + número_de_pedimento + ", tipo_figura=" + tipo_figura
				+ ", firma_electrónica_avanzada_agente=" + firma_electrónica_avanzada_agente
				+ ", número_serie_certificado_firma=" + número_serie_certificado_firma + "]";
	}
	
	
	

}
