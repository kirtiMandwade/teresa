package com.formapp.model.mysql;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="`358`")
public class ObservacionesPedimentComplementario extends AuditBase {


	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private long id;
	
	private int clave_del_Tipo_de_Registro; 
	private long número_pedimento;
	private String país_Destino_mercancía ;
	private String fracción_Arancelaria;
	private int número_Partida;
	
	private int secuencia_Observaciones  ;
	
	private String observaciones ;

	public ObservacionesPedimentComplementario() {
		
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

	public String getPaís_Destino_mercancía() {
		return país_Destino_mercancía;
	}

	public void setPaís_Destino_mercancía(String país_Destino_mercancía) {
		this.país_Destino_mercancía = país_Destino_mercancía;
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

	public int getSecuencia_Observaciones() {
		return secuencia_Observaciones;
	}

	public void setSecuencia_Observaciones(int secuencia_Observaciones) {
		this.secuencia_Observaciones = secuencia_Observaciones;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	
	

	@Override
	public String toString() {
		return "ObservacionesPedimentComplementario [id=" + id + ", clave_del_Tipo_de_Registro=" + clave_del_Tipo_de_Registro
				+ ", número_pedimento=" + número_pedimento + ", país_Destino_mercancía=" + país_Destino_mercancía
				+ ", fracción_Arancelaria=" + fracción_Arancelaria + ", número_Partida=" + número_Partida
				+ ", secuencia_Observaciones=" + secuencia_Observaciones + ", observaciones=" + observaciones + "]";
	}
	
	
	
	
	

}
