package com.formapp.model.mysql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="`551`")
public class Partidas extends AuditBase{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private long id;
	
	private int clave_del_Tipo_de_Registro; 
	private long número_de_pedimento; 
	private String fracción_Arancelaria;
	private int número_Partida; 
	private long subdivision_Fracción ; 
	private String descripcion_Mercancía; 
	private double precio_Unitario ;
	private long valor_Aduana ;
	
	private long importe_precio_pagado;
	private double valor_Dólares ; 
	
	private double cantidad_mercancía_Unidades;
	private int unidad_Medida_Comercialización ;
	private double cantidad_mercancía_Unidades_LIGIE ;
	
	private int unidad_Medida_LIGIE;
	
	private int valor_Agregado ;
	
	private String vinculación ;
	private String código_producto ;
	private int método_Valoración ;
	 @Column(length=80)
	private String marca_mercancía;
	 @Column(length=80)
	private String modelo_Lote_mercancía;
	private String país_Origen_Destino_mercancía ;
    private String país_Vendedor_Comprador ;
	
    private String entidad_Federativa_Origen_mercancías;
    private String entidad_Federativa_Destino_mercancías;
    private String entidad_Federativa_Comprador_mercancías;
    private String entidad_Federativa_Vendedor_mercancías;
	
    
    
    
    public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public long getSubdivision_Fracción() {
		return subdivision_Fracción;
	}
	public void setSubdivision_Fracción(long subdivision_Fracción) {
		this.subdivision_Fracción = subdivision_Fracción;
	}
	public String getDescripcion_Mercancía() {
		return descripcion_Mercancía;
	}
	public void setDescripcion_Mercancía(String descripcion_Mercancía) {
		this.descripcion_Mercancía = descripcion_Mercancía;
	}
	public double getPrecio_Unitario() {
		return precio_Unitario;
	}
	public void setPrecio_Unitario(double precio_Unitario) {
		this.precio_Unitario = precio_Unitario;
	}
	public long getValor_Aduana() {
		return valor_Aduana;
	}
	public void setValor_Aduana(long valor_Aduana) {
		this.valor_Aduana = valor_Aduana;
	}
	public long getImporte_precio_pagado() {
		return importe_precio_pagado;
	}
	public void setImporte_precio_pagado(long importe_precio_pagado) {
		this.importe_precio_pagado = importe_precio_pagado;
	}
	public double getValor_Dólares() {
		return valor_Dólares;
	}
	public void setValor_Dólares(double valor_Dólares) {
		this.valor_Dólares = valor_Dólares;
	}
	public double getCantidad_mercancía_Unidades() {
		return cantidad_mercancía_Unidades;
	}
	public void setCantidad_mercancía_Unidades(double cantidad_mercancía_Unidades) {
		this.cantidad_mercancía_Unidades = cantidad_mercancía_Unidades;
	}
	public int getUnidad_Medida_Comercialización() {
		return unidad_Medida_Comercialización;
	}
	public void setUnidad_Medida_Comercialización(int unidad_Medida_Comercialización) {
		this.unidad_Medida_Comercialización = unidad_Medida_Comercialización;
	}
	public double getCantidad_mercancía_Unidades_LIGIE() {
		return cantidad_mercancía_Unidades_LIGIE;
	}
	public void setCantidad_mercancía_Unidades_LIGIE(double cantidad_mercancía_Unidades_LIGIE) {
		this.cantidad_mercancía_Unidades_LIGIE = cantidad_mercancía_Unidades_LIGIE;
	}
	public int getUnidad_Medida_LIGIE() {
		return unidad_Medida_LIGIE;
	}
	public void setUnidad_Medida_LIGIE(int unidad_Medida_LIGIE) {
		this.unidad_Medida_LIGIE = unidad_Medida_LIGIE;
	}
	public int getValor_Agregado() {
		return valor_Agregado;
	}
	public void setValor_Agregado(int valor_Agregado) {
		this.valor_Agregado = valor_Agregado;
	}
	public String getVinculación() {
		return vinculación;
	}
	public void setVinculación(String vinculación) {
		this.vinculación = vinculación;
	}
	public String getCódigo_producto() {
		return código_producto;
	}
	public void setCódigo_producto(String código_producto) {
		this.código_producto = código_producto;
	}
	public int getMétodo_Valoración() {
		return método_Valoración;
	}
	public void setMétodo_Valoración(int método_Valoración) {
		this.método_Valoración = método_Valoración;
	}
	public String getMarca_mercancía() {
		return marca_mercancía;
	}
	public void setMarca_mercancía(String marca_mercancía) {
		this.marca_mercancía = marca_mercancía;
	}
	public String getModelo_Lote_mercancía() {
		return modelo_Lote_mercancía;
	}
	public void setModelo_Lote_mercancía(String modelo_Lote_mercancía) {
		this.modelo_Lote_mercancía = modelo_Lote_mercancía;
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
	public String getEntidad_Federativa_Origen_mercancías() {
		return entidad_Federativa_Origen_mercancías;
	}
	public void setEntidad_Federativa_Origen_mercancías(String entidad_Federativa_Origen_mercancías) {
		this.entidad_Federativa_Origen_mercancías = entidad_Federativa_Origen_mercancías;
	}
	public String getEntidad_Federativa_Destino_mercancías() {
		return entidad_Federativa_Destino_mercancías;
	}
	public void setEntidad_Federativa_Destino_mercancías(String entidad_Federativa_Destino_mercancías) {
		this.entidad_Federativa_Destino_mercancías = entidad_Federativa_Destino_mercancías;
	}
	public String getEntidad_Federativa_Comprador_mercancías() {
		return entidad_Federativa_Comprador_mercancías;
	}
	public void setEntidad_Federativa_Comprador_mercancías(String entidad_Federativa_Comprador_mercancías) {
		this.entidad_Federativa_Comprador_mercancías = entidad_Federativa_Comprador_mercancías;
	}
	public String getEntidad_Federativa_Vendedor_mercancías() {
		return entidad_Federativa_Vendedor_mercancías;
	}
	public void setEntidad_Federativa_Vendedor_mercancías(String entidad_Federativa_Vendedor_mercancías) {
		this.entidad_Federativa_Vendedor_mercancías = entidad_Federativa_Vendedor_mercancías;
	}
	@Override
	public String toString() {
		return "Partidas [id=" + id + ", clave_del_Tipo_de_Registro=" + clave_del_Tipo_de_Registro
				+ ", número_de_pedimento=" + número_de_pedimento + ", fracción_Arancelaria=" + fracción_Arancelaria
				+ ", número_Partida=" + número_Partida + ", subdivision_Fracción=" + subdivision_Fracción
				+ ", descripcion_Mercancía=" + descripcion_Mercancía + ", precio_Unitario=" + precio_Unitario
				+ ", valor_Aduana=" + valor_Aduana + ", importe_precio_pagado=" + importe_precio_pagado
				+ ", valor_Dólares=" + valor_Dólares + ", cantidad_mercancía_Unidades=" + cantidad_mercancía_Unidades
				+ ", unidad_Medida_Comercialización=" + unidad_Medida_Comercialización
				+ ", cantidad_mercancía_Unidades_LIGIE=" + cantidad_mercancía_Unidades_LIGIE + ", unidad_Medida_LIGIE="
				+ unidad_Medida_LIGIE + ", valor_Agregado=" + valor_Agregado + ", vinculación=" + vinculación
				+ ", código_producto=" + código_producto + ", método_Valoración=" + método_Valoración
				+ ", marca_mercancía=" + marca_mercancía + ", modelo_Lote_mercancía=" + modelo_Lote_mercancía
				+ ", país_Origen_Destino_mercancía=" + país_Origen_Destino_mercancía + ", país_Vendedor_Comprador="
				+ país_Vendedor_Comprador + ", entidad_Federativa_Origen_mercancías="
				+ entidad_Federativa_Origen_mercancías + ", entidad_Federativa_Destino_mercancías="
				+ entidad_Federativa_Destino_mercancías + ", entidad_Federativa_Comprador_mercancías="
				+ entidad_Federativa_Comprador_mercancías + ", entidad_Federativa_Vendedor_mercancías="
				+ entidad_Federativa_Vendedor_mercancías + "]";
	}
	public long getNúmero_de_pedimento() {
		return número_de_pedimento;
	}
	public void setNúmero_de_pedimento(long número_de_pedimento) {
		this.número_de_pedimento = número_de_pedimento;
	}
	public int getclave_del_Tipo_de_Registro() {
		return clave_del_Tipo_de_Registro;
	}
	public void setclave_del_Tipo_de_Registro(int clave_del_Tipo_de_Registro) {
		this.clave_del_Tipo_de_Registro = clave_del_Tipo_de_Registro;
	}
	


}
