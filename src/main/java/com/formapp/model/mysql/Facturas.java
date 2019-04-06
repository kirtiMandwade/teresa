package com.formapp.model.mysql;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="`505`")
public class Facturas  extends AuditBase{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private long id;
	
	private int Clave_del_Tipo_de_Registro; 
	private long  Número_de_Pedimento;
	Date Fecha_de_facturación;
	private String Número_de_Factura_acuse_de_valor_o_CFDI;
	private String Término_de_Facturación;
	private String Moneda_de_Facturación;
	private double Valor_Total_de_las_Mercancías_en_Dólares;
	private double Valor_Total_de_las_Mercancías_en_facturaciónl;

	private String Pais_de_Facturación;
	private String Entidad_Federativa_de_Facturación;
	private String Identificación_Fiscal_del_Proveedor_o_Comprador;
	private String Nombre_del_Proveedor_o_Comprador;
	private String Calle_del_domicilio_del_Proveedor_o_Comprador;
	private String Número_interior_del_domicilio_del_Proveedor_o_Comprador;
	private String Número_exterior_del_domicilio_del_Proveedor_o_Comprador;
	private String Código_postal_del_domicilio_del_Proveedor_o_Comprador;
	private String Municipio_del_domicilio_del_Proveedor_o_Comprador;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getClave_del_Tipo_de_Registro() {
		return Clave_del_Tipo_de_Registro;
	}
	public void setClave_del_Tipo_de_Registro(int clave_del_Tipo_de_Registro) {
		Clave_del_Tipo_de_Registro = clave_del_Tipo_de_Registro;
	}
	public long getNúmero_de_Pedimento() {
		return Número_de_Pedimento;
	}
	public void setNúmero_de_Pedimento(long número_de_Pedimento) {
		Número_de_Pedimento = número_de_Pedimento;
	}
	public Date getFecha_de_facturación() {
		return Fecha_de_facturación;
	}
	public void setFecha_de_facturación(Date fecha_de_facturación) {
		Fecha_de_facturación = fecha_de_facturación;
	}
	public String getNúmero_de_Factura_acuse_de_valor_o_CFDI() {
		return Número_de_Factura_acuse_de_valor_o_CFDI;
	}
	public void setNúmero_de_Factura_acuse_de_valor_o_CFDI(String número_de_Factura_acuse_de_valor_o_CFDI) {
		Número_de_Factura_acuse_de_valor_o_CFDI = número_de_Factura_acuse_de_valor_o_CFDI;
	}
	public String getTérmino_de_Facturación() {
		return Término_de_Facturación;
	}
	public void setTérmino_de_Facturación(String término_de_Facturación) {
		Término_de_Facturación = término_de_Facturación;
	}
	public String getMoneda_de_Facturación() {
		return Moneda_de_Facturación;
	}
	public void setMoneda_de_Facturación(String moneda_de_Facturación) {
		Moneda_de_Facturación = moneda_de_Facturación;
	}
	public double getValor_Total_de_las_Mercancías_en_Dólares() {
		return Valor_Total_de_las_Mercancías_en_Dólares;
	}
	public void setValor_Total_de_las_Mercancías_en_Dólares(double valor_Total_de_las_Mercancías_en_Dólares) {
		Valor_Total_de_las_Mercancías_en_Dólares = valor_Total_de_las_Mercancías_en_Dólares;
	}
	
	public String getPais_de_Facturación() {
		return Pais_de_Facturación;
	}
	public void setPais_de_Facturación(String pais_de_Facturación) {
		Pais_de_Facturación = pais_de_Facturación;
	}
	public String getEntidad_Federativa_de_Facturación() {
		return Entidad_Federativa_de_Facturación;
	}
	public void setEntidad_Federativa_de_Facturación(String entidad_Federativa_de_Facturación) {
		Entidad_Federativa_de_Facturación = entidad_Federativa_de_Facturación;
	}
	public String getIdentificación_Fiscal_del_Proveedor_o_Comprador() {
		return Identificación_Fiscal_del_Proveedor_o_Comprador;
	}
	public void setIdentificación_Fiscal_del_Proveedor_o_Comprador(String identificación_Fiscal_del_Proveedor_o_Comprador) {
		Identificación_Fiscal_del_Proveedor_o_Comprador = identificación_Fiscal_del_Proveedor_o_Comprador;
	}
	public String getNombre_del_Proveedor_o_Comprador() {
		return Nombre_del_Proveedor_o_Comprador;
	}
	public void setNombre_del_Proveedor_o_Comprador(String nombre_del_Proveedor_o_Comprador) {
		Nombre_del_Proveedor_o_Comprador = nombre_del_Proveedor_o_Comprador;
	}
	public String getCalle_del_domicilio_del_Proveedor_o_Comprador() {
		return Calle_del_domicilio_del_Proveedor_o_Comprador;
	}
	public void setCalle_del_domicilio_del_Proveedor_o_Comprador(String calle_del_domicilio_del_Proveedor_o_Comprador) {
		Calle_del_domicilio_del_Proveedor_o_Comprador = calle_del_domicilio_del_Proveedor_o_Comprador;
	}
	public String getNúmero_interior_del_domicilio_del_Proveedor_o_Comprador() {
		return Número_interior_del_domicilio_del_Proveedor_o_Comprador;
	}
	public void setNúmero_interior_del_domicilio_del_Proveedor_o_Comprador(
			String número_interior_del_domicilio_del_Proveedor_o_Comprador) {
		Número_interior_del_domicilio_del_Proveedor_o_Comprador = número_interior_del_domicilio_del_Proveedor_o_Comprador;
	}
	public String getNúmero_exterior_del_domicilio_del_Proveedor_o_Comprador() {
		return Número_exterior_del_domicilio_del_Proveedor_o_Comprador;
	}
	public void setNúmero_exterior_del_domicilio_del_Proveedor_o_Comprador(
			String número_exterior_del_domicilio_del_Proveedor_o_Comprador) {
		Número_exterior_del_domicilio_del_Proveedor_o_Comprador = número_exterior_del_domicilio_del_Proveedor_o_Comprador;
	}
	public String getCódigo_postal_del_domicilio_del_Proveedor_o_Comprador() {
		return Código_postal_del_domicilio_del_Proveedor_o_Comprador;
	}
	public void setCódigo_postal_del_domicilio_del_Proveedor_o_Comprador(
			String código_postal_del_domicilio_del_Proveedor_o_Comprador) {
		Código_postal_del_domicilio_del_Proveedor_o_Comprador = código_postal_del_domicilio_del_Proveedor_o_Comprador;
	}
	public String getMunicipio_del_domicilio_del_Proveedor_o_Comprador() {
		return Municipio_del_domicilio_del_Proveedor_o_Comprador;
	}
	public void setMunicipio_del_domicilio_del_Proveedor_o_Comprador(
			String municipio_del_domicilio_del_Proveedor_o_Comprador) {
		Municipio_del_domicilio_del_Proveedor_o_Comprador = municipio_del_domicilio_del_Proveedor_o_Comprador;
	}

	public double getValor_Total_de_las_Mercancías_en_facturaciónl() {
		return Valor_Total_de_las_Mercancías_en_facturaciónl;
	}
	public void setValor_Total_de_las_Mercancías_en_facturaciónl(double valor_Total_de_las_Mercancías_en_facturaciónl) {
		Valor_Total_de_las_Mercancías_en_facturaciónl = valor_Total_de_las_Mercancías_en_facturaciónl;
	}
	public Facturas() {
		
	}  


}
