package com.formapp.model.mysql;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="`555`")
public class GarantiaNivelPartida extends AuditBase{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private long id;
	
	private int clave_del_Tipo_de_Registro; 
	private long número_de_pedimento; 
	private String fracción_Arancelaria  ;
	private int número_Partida;
	
	private int institución_Cuenta_Garantía  ;
	
	private long número_Cuenta_Garantía ;
	@Column(length=17)
	private String folio_Constancia ; 
	Date fecha_Constancia  ;
	private int tipo_Garantía;
	private double valor_unitario_título  ;
	private double importe_Total_Garantía ;
	private double cantidad_Unidades_Medida ;
	private double titulos_Asignados ;
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
	public int getInstitución_Cuenta_Garantía() {
		return institución_Cuenta_Garantía;
	}
	public void setInstitución_Cuenta_Garantía(int institución_Cuenta_Garantía) {
		this.institución_Cuenta_Garantía = institución_Cuenta_Garantía;
	}
	public long getNúmero_Cuenta_Garantía() {
		return número_Cuenta_Garantía;
	}
	public void setNúmero_Cuenta_Garantía(long número_Cuenta_Garantía) {
		this.número_Cuenta_Garantía = número_Cuenta_Garantía;
	}
	public String getFolio_Constancia() {
		return folio_Constancia;
	}
	public void setFolio_Constancia(String folio_Constancia) {
		this.folio_Constancia = folio_Constancia;
	}
	public Date getFecha_Constancia() {
		return fecha_Constancia;
	}
	public void setFecha_Constancia(Date fecha_Constancia) {
		this.fecha_Constancia = fecha_Constancia;
	}
	public int getTipo_Garantía() {
		return tipo_Garantía;
	}
	public void setTipo_Garantía(int tipo_Garantía) {
		this.tipo_Garantía = tipo_Garantía;
	}
	public double getValor_unitario_título() {
		return valor_unitario_título;
	}
	public void setValor_unitario_título(double valor_unitario_título) {
		this.valor_unitario_título = valor_unitario_título;
	}
	public double getImporte_Total_Garantía() {
		return importe_Total_Garantía;
	}
	public void setImporte_Total_Garantía(double importe_Total_Garantía) {
		this.importe_Total_Garantía = importe_Total_Garantía;
	}
	public double getCantidad_Unidades_Medida() {
		return cantidad_Unidades_Medida;
	}
	public void setCantidad_Unidades_Medida(double cantidad_Unidades_Medida) {
		this.cantidad_Unidades_Medida = cantidad_Unidades_Medida;
	}
	public double getTitulos_Asignados() {
		return titulos_Asignados;
	}
	public void setTitulos_Asignados(double titulos_Asignados) {
		this.titulos_Asignados = titulos_Asignados;
	}
	
	
}
