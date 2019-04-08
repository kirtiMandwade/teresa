package com.formapp.model.mysql;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="`351`")
public class DeterContriA_303TLCAN extends AuditBase {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private long id;
	
	private int clave_del_Tipo_de_Registro; 
	private long número_de_pedimento;
	private String país_Destino_mercancía ;
	private String fracción_Arancelaria;
	private int número_Partida; 
	private long valor_Mercancía_originaria ;
	private long monto_IGI_sobre_mercancía_originaria;
	private long impuesto_Total_pagado_importación_EUA_CAN;
	private int tipo_Moneda;
	private long monto_exento;
	public DeterContriA_303TLCAN() {
		
		
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
	public long getValor_Mercancía_originaria() {
		return valor_Mercancía_originaria;
	}
	public void setValor_Mercancía_originaria(long valor_Mercancía_originaria) {
		this.valor_Mercancía_originaria = valor_Mercancía_originaria;
	}
	public long getMonto_IGI_sobre_mercancía_originaria() {
		return monto_IGI_sobre_mercancía_originaria;
	}
	public void setMonto_IGI_sobre_mercancía_originaria(long monto_IGI_sobre_mercancía_originaria) {
		this.monto_IGI_sobre_mercancía_originaria = monto_IGI_sobre_mercancía_originaria;
	}
	public long getImpuesto_Total_pagado_importación_EUA_CAN() {
		return impuesto_Total_pagado_importación_EUA_CAN;
	}
	public void setImpuesto_Total_pagado_importación_EUA_CAN(long impuesto_Total_pagado_importación_EUA_CAN) {
		this.impuesto_Total_pagado_importación_EUA_CAN = impuesto_Total_pagado_importación_EUA_CAN;
	}
	public int getTipo_Moneda() {
		return tipo_Moneda;
	}
	public void setTipo_Moneda(int tipo_Moneda) {
		this.tipo_Moneda = tipo_Moneda;
	}
	public long getMonto_exento() {
		return monto_exento;
	}
	public void setMonto_exento(long monto_exento) {
		this.monto_exento = monto_exento;
	}
	
	@Override
	public String toString() {
		return "DeterContriA_303TLCAN [id=" + id + ", clave_del_Tipo_de_Registro=" + clave_del_Tipo_de_Registro
				+ ", número_de_pedimento=" + número_de_pedimento + ", país_Destino_mercancía=" + país_Destino_mercancía
				+ ", fracción_Arancelaria=" + fracción_Arancelaria + ", número_Partida=" + número_Partida
				+ ", valor_Mercancía_originaria=" + valor_Mercancía_originaria
				+ ", monto_IGI_sobre_mercancía_originaria=" + monto_IGI_sobre_mercancía_originaria
				+ ", impuesto_Total_pagado_importación_EUA_CAN=" + impuesto_Total_pagado_importación_EUA_CAN
				+ ", tipo_Moneda=" + tipo_Moneda + ", monto_exento=" + monto_exento + "]";
	}

	
	
	
	
}
