package com.formapp.model.mysql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="`560`")
public class PartidasInformeIA extends AuditBase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private long id;
	
	private int clave_del_Tipo_de_Registro; 
	private long número_pedimento; 
	private String fracción_Arancelaria;
	private int número_Partida; 
	private long importe_precio_pagado_mercancía;
	private double valor_factura_Dólares ;
	private double cantidad_mercancía_Unidades;
	private int clave_Unidad_Medida_Comercialización;
	private double cantidad_mercancía_Unidades_Medida_LIGIE;
	private int clave_unidad_Medida_LIGIE;

	private String país_Origen_Destino_mercancía ;
    private String país_Vendedor_Comprador ;
	public PartidasInformeIA() {
		
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
	public long getImporte_precio_pagado_mercancía() {
		return importe_precio_pagado_mercancía;
	}
	public void setImporte_precio_pagado_mercancía(long importe_precio_pagado_mercancía) {
		this.importe_precio_pagado_mercancía = importe_precio_pagado_mercancía;
	}
	public double getValor_factura_Dólares() {
		return valor_factura_Dólares;
	}
	public void setValor_factura_Dólares(double valor_factura_Dólares) {
		this.valor_factura_Dólares = valor_factura_Dólares;
	}
	public double getCantidad_mercancía_Unidades() {
		return cantidad_mercancía_Unidades;
	}
	public void setCantidad_mercancía_Unidades(double cantidad_mercancía_Unidades) {
		this.cantidad_mercancía_Unidades = cantidad_mercancía_Unidades;
	}
	public int getClave_Unidad_Medida_Comercialización() {
		return clave_Unidad_Medida_Comercialización;
	}
	public void setClave_Unidad_Medida_Comercialización(int clave_Unidad_Medida_Comercialización) {
		this.clave_Unidad_Medida_Comercialización = clave_Unidad_Medida_Comercialización;
	}
	public double getCantidad_mercancía_Unidades_Medida_LIGIE() {
		return cantidad_mercancía_Unidades_Medida_LIGIE;
	}
	public void setCantidad_mercancía_Unidades_Medida_LIGIE(double cantidad_mercancía_Unidades_Medida_LIGIE) {
		this.cantidad_mercancía_Unidades_Medida_LIGIE = cantidad_mercancía_Unidades_Medida_LIGIE;
	}
	public int getClave_unidad_Medida_LIGIE() {
		return clave_unidad_Medida_LIGIE;
	}
	public void setClave_unidad_Medida_LIGIE(int clave_unidad_Medida_LIGIE) {
		this.clave_unidad_Medida_LIGIE = clave_unidad_Medida_LIGIE;
	}
	public String getPaís_Origen_Destino_mercancía() {
		return país_Origen_Destino_mercancía;
	}
	public void setPaís_Origen_Destino_mercancía(String país_Origen_Destino_mercancía) {
		this.país_Origen_Destino_mercancía = país_Origen_Destino_mercancía;
	}
	public String getPaís_Vendedor_Comprador() {
		return país_Vendedor_Comprador;
	}
	public void setPaís_Vendedor_Comprador(String país_Vendedor_Comprador) {
		this.país_Vendedor_Comprador = país_Vendedor_Comprador;
	}
	

	@Override
	public String toString() {
		return "PartidasInformeIA [id=" + id + ", clave_del_Tipo_de_Registro=" + clave_del_Tipo_de_Registro + ", número_pedimento="
				+ número_pedimento + ", fracción_Arancelaria=" + fracción_Arancelaria + ", número_Partida="
				+ número_Partida + ", importe_precio_pagado_mercancía=" + importe_precio_pagado_mercancía
				+ ", valor_factura_Dólares=" + valor_factura_Dólares + ", cantidad_mercancía_Unidades="
				+ cantidad_mercancía_Unidades + ", clave_Unidad_Medida_Comercialización="
				+ clave_Unidad_Medida_Comercialización + ", cantidad_mercancía_Unidades_Medida_LIGIE="
				+ cantidad_mercancía_Unidades_Medida_LIGIE + ", clave_unidad_Medida_LIGIE=" + clave_unidad_Medida_LIGIE
				+ ", país_Origen_Destino_mercancía=" + país_Origen_Destino_mercancía + ", país_Vendedor_Comprador="
				+ país_Vendedor_Comprador + "]";
	}
    
	
	
	
	
    
    

    


}
