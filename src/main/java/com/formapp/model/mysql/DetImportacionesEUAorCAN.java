package com.formapp.model.mysql;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="`352`")
public class DetImportacionesEUAorCAN extends AuditBase {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private long id;
	
	private int clave_del_Tipo_de_Registro; 
	private long número_pedimento;
	private String país_Destino_mercancía ;
	private String fracción_Arancelaria;
	private int número_Partida; 
	
	private int unidad_Medida_Tarifa_EUA_CAN;
	private double cantidad_mercancía_Uni_Tarifa_EUA_CAN ;
	private String fracción_Arancelaria_EUA_CAN;
	private long impuesto_pagado_importación_EUA_CAN;
	private double tasa_arancel_EUA_CAN ;
	private int moneda;
	
	
	public DetImportacionesEUAorCAN() {
	
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
	public int getUnidad_Medida_Tarifa_EUA_CAN() {
		return unidad_Medida_Tarifa_EUA_CAN;
	}
	public void setUnidad_Medida_Tarifa_EUA_CAN(int unidad_Medida_Tarifa_EUA_CAN) {
		this.unidad_Medida_Tarifa_EUA_CAN = unidad_Medida_Tarifa_EUA_CAN;
	}
	public double getCantidad_mercancía_Uni_Tarifa_EUA_CAN() {
		return cantidad_mercancía_Uni_Tarifa_EUA_CAN;
	}
	public void setCantidad_mercancía_Uni_Tarifa_EUA_CAN(double cantidad_mercancía_Uni_Tarifa_EUA_CAN) {
		this.cantidad_mercancía_Uni_Tarifa_EUA_CAN = cantidad_mercancía_Uni_Tarifa_EUA_CAN;
	}
	public String getFracción_Arancelaria_EUA_CAN() {
		return fracción_Arancelaria_EUA_CAN;
	}
	public void setFracción_Arancelaria_EUA_CAN(String fracción_Arancelaria_EUA_CAN) {
		this.fracción_Arancelaria_EUA_CAN = fracción_Arancelaria_EUA_CAN;
	}
	public long getImpuesto_pagado_importación_EUA_CAN() {
		return impuesto_pagado_importación_EUA_CAN;
	}
	public void setImpuesto_pagado_importación_EUA_CAN(long impuesto_pagado_importación_EUA_CAN) {
		this.impuesto_pagado_importación_EUA_CAN = impuesto_pagado_importación_EUA_CAN;
	}
	public double getTasa_arancel_EUA_CAN() {
		return tasa_arancel_EUA_CAN;
	}
	public void setTasa_arancel_EUA_CAN(double tasa_arancel_EUA_CAN) {
		this.tasa_arancel_EUA_CAN = tasa_arancel_EUA_CAN;
	}
	public int getMoneda() {
		return moneda;
	}
	public void setMoneda(int moneda) {
		this.moneda = moneda;
	}
	@Override
	public String toString() {
		return "DetImportacionesEUAorCAN [id=" + id + ", clave_del_Tipo_de_Registro=" + clave_del_Tipo_de_Registro
				+ ", número_pedimento=" + número_pedimento + ", país_Destino_mercancía=" + país_Destino_mercancía
				+ ", fracción_Arancelaria=" + fracción_Arancelaria + ", número_Partida=" + número_Partida
				+ ", unidad_Medida_Tarifa_EUA_CAN=" + unidad_Medida_Tarifa_EUA_CAN
				+ ", cantidad_mercancía_Uni_Tarifa_EUA_CAN=" + cantidad_mercancía_Uni_Tarifa_EUA_CAN
				+ ", fracción_Arancelaria_EUA_CAN=" + fracción_Arancelaria_EUA_CAN
				+ ", impuesto_pagado_importación_EUA_CAN=" + impuesto_pagado_importación_EUA_CAN
				+ ", tasa_arancel_EUA_CAN=" + tasa_arancel_EUA_CAN + ", moneda=" + moneda + "]";
	}
	
	

}
