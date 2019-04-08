package com.formapp.model.mysql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="`601`")
public class PrevioConsolidado extends AuditBase{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private long id;
	
	private int clave_del_Tipo_de_Registro;
	private int patente_autorización;
	private long número_de_pedimento;
	private String aduana_sección_despacho ;
	private String clave_pedimento ;
	private int tipo_Operación;
	private String CURP_Importador_Exportador;
	private String RFC_Importador_Exportador; 
	private String CURP_agente_aduanal;
	private int  origen_Destino_mercancía ;
	private String RFC_Facturación_Servicios_Operación ;
	
	
	
	
	public PrevioConsolidado() {
		
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
	public int getPatente_autorización() {
		return patente_autorización;
	}
	public void setPatente_autorización(int patente_autorización) {
		this.patente_autorización = patente_autorización;
	}
	
	public long getNúmero_de_pedimento() {
		return número_de_pedimento;
	}

	public void setNúmero_de_pedimento(long número_de_pedimento) {
		this.número_de_pedimento = número_de_pedimento;
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
	public int getTipo_Operación() {
		return tipo_Operación;
	}
	public void setTipo_Operación(int tipo_Operación) {
		this.tipo_Operación = tipo_Operación;
	}
	public String getCURP_Importador_Exportador() {
		return CURP_Importador_Exportador;
	}
	public void setCURP_Importador_Exportador(String cURP_Importador_Exportador) {
		CURP_Importador_Exportador = cURP_Importador_Exportador;
	}
	public String getRFC_Importador_Exportador() {
		return RFC_Importador_Exportador;
	}
	public void setRFC_Importador_Exportador(String rFC_Importador_Exportador) {
		RFC_Importador_Exportador = rFC_Importador_Exportador;
	}
	public String getCURP_agente_aduanal() {
		return CURP_agente_aduanal;
	}
	public void setCURP_agente_aduanal(String cURP_agente_aduanal) {
		CURP_agente_aduanal = cURP_agente_aduanal;
	}
	public int getOrigen_Destino_mercancía() {
		return origen_Destino_mercancía;
	}
	public void setOrigen_Destino_mercancía(int origen_Destino_mercancía) {
		this.origen_Destino_mercancía = origen_Destino_mercancía;
	}
	public String getRFC_Facturación_Servicios_Operación() {
		return RFC_Facturación_Servicios_Operación;
	}
	public void setRFC_Facturación_Servicios_Operación(String rFC_Facturación_Servicios_Operación) {
		RFC_Facturación_Servicios_Operación = rFC_Facturación_Servicios_Operación;
	}
	
	
	

	@Override
	public String toString() {
		return "PrevioConsolidado [id=" + id + ", clave_del_Tipo_de_Registro=" + clave_del_Tipo_de_Registro
				+ ", patente_autorización=" + patente_autorización + ", número_de_pedimento=" + número_de_pedimento
				+ ", aduana_sección_despacho=" + aduana_sección_despacho + ", clave_pedimento=" + clave_pedimento
				+ ", tipo_Operación=" + tipo_Operación + ", CURP_Importador_Exportador=" + CURP_Importador_Exportador
				+ ", RFC_Importador_Exportador=" + RFC_Importador_Exportador + ", CURP_agente_aduanal="
				+ CURP_agente_aduanal + ", origen_Destino_mercancía=" + origen_Destino_mercancía
				+ ", RFC_Facturación_Servicios_Operación=" + RFC_Facturación_Servicios_Operación + "]";
	}
	
	
	
	
	

}
