package com.formapp.model.mysql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="`553`")
public class Permisos extends AuditBase{


	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private long id;
	
	private int clave_del_Tipo_de_Registro; 
	private long número_de_pedimento; 
	private String fracción_Arancelaria  ;
	private int número_Partida;
	private String clave_Permiso ;
	@Column(length=40)
	private String firma_descargo ;
	@Column(length=25)
	private String número_permisos_autorización ; 
	private double valor_comercial_dólares ;
	private double cantidad_Mercancía_UMTorUMC ;
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
	public String getClave_Permiso() {
		return clave_Permiso;
	}
	public void setClave_Permiso(String clave_Permiso) {
		this.clave_Permiso = clave_Permiso;
	}
	public String getFirma_descargo() {
		return firma_descargo;
	}
	public void setFirma_descargo(String firma_descargo) {
		this.firma_descargo = firma_descargo;
	}
	public String getNúmero_permisos_autorización() {
		return número_permisos_autorización;
	}
	public void setNúmero_permisos_autorización(String número_permisos_autorización) {
		this.número_permisos_autorización = número_permisos_autorización;
	}
	public double getValor_comercial_dólares() {
		return valor_comercial_dólares;
	}
	public void setValor_comercial_dólares(double valor_comercial_dólares) {
		this.valor_comercial_dólares = valor_comercial_dólares;
	}
	public double getCantidad_Mercancía_UMTorUMC() {
		return cantidad_Mercancía_UMTorUMC;
	}
	public void setCantidad_Mercancía_UMTorUMC(double cantidad_Mercancía_UMTorUMC) {
		this.cantidad_Mercancía_UMTorUMC = cantidad_Mercancía_UMTorUMC;
	}
	@Override
	public String toString() {
		return "Permisos [id=" + id + ", clave_del_Tipo_de_Registro=" + clave_del_Tipo_de_Registro
				+ ", número_de_pedimento=" + número_de_pedimento + ", fracción_Arancelaria=" + fracción_Arancelaria
				+ ", número_Partida=" + número_Partida + ", clave_Permiso=" + clave_Permiso + ", firma_descargo="
				+ firma_descargo + ", número_permisos_autorización=" + número_permisos_autorización
				+ ", valor_comercial_dólares=" + valor_comercial_dólares + ", cantidad_Mercancía_UMTorUMC="
				+ cantidad_Mercancía_UMTorUMC + "]";
	}
		
}
