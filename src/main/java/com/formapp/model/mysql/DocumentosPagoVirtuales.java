package com.formapp.model.mysql;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="`514`")
public class DocumentosPagoVirtuales extends AuditBase { 

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private long id;
	
	private int clave_del_Tipo_de_Registro;
	private long número_Pedimento;
	private int clave_Forma_Pago;
	@Column(length=120)
	private String dependencia_institución_expide_documento;
	@Column(length=40)
	private String número_Documento ;
	Date fecha_Expedición_Documento;
	private double importe_total_amparado_Documento; 
	
	private double saldo_Disponible_Documento ;
	private long importe_Total_Pagar_Pedimento ;
	
	
	
	public DocumentosPagoVirtuales() {
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
	public long getNúmero_Pedimento() {
		return número_Pedimento;
	}
	public void setNúmero_Pedimento(long número_Pedimento) {
		this.número_Pedimento = número_Pedimento;
	}
	public int getClave_Forma_Pago() {
		return clave_Forma_Pago;
	}
	public void setClave_Forma_Pago(int clave_Forma_Pago) {
		this.clave_Forma_Pago = clave_Forma_Pago;
	}
	public String getDependencia_institución_expide_documento() {
		return dependencia_institución_expide_documento;
	}
	public void setDependencia_institución_expide_documento(String dependencia_institución_expide_documento) {
		this.dependencia_institución_expide_documento = dependencia_institución_expide_documento;
	}
	public String getNúmero_Documento() {
		return número_Documento;
	}
	public void setNúmero_Documento(String número_Documento) {
		this.número_Documento = número_Documento;
	}
	public Date getFecha_Expedición_Documento() {
		return fecha_Expedición_Documento;
	}
	public void setFecha_Expedición_Documento(Date fecha_Expedición_Documento) {
		this.fecha_Expedición_Documento = fecha_Expedición_Documento;
	}
	public double getImporte_total_amparado_Documento() {
		return importe_total_amparado_Documento;
	}
	public void setImporte_total_amparado_Documento(double importe_total_amparado_Documento) {
		this.importe_total_amparado_Documento = importe_total_amparado_Documento;
	}
	public double getSaldo_Disponible_Documento() {
		return saldo_Disponible_Documento;
	}
	public void setSaldo_Disponible_Documento(double saldo_Disponible_Documento) {
		this.saldo_Disponible_Documento = saldo_Disponible_Documento;
	}
	public long getImporte_Total_Pagar_Pedimento() {
		return importe_Total_Pagar_Pedimento;
	}
	public void setImporte_Total_Pagar_Pedimento(long importe_Total_Pagar_Pedimento) {
		this.importe_Total_Pagar_Pedimento = importe_Total_Pagar_Pedimento;
	}
	@Override
	public String toString() {
		return "DocumentosPagoVirtuales [id=" + id + ", clave_del_Tipo_de_Registro=" + clave_del_Tipo_de_Registro
				+ ", número_Pedimento=" + número_Pedimento + ", clave_Forma_Pago=" + clave_Forma_Pago
				+ ", dependencia_institución_expide_documento=" + dependencia_institución_expide_documento
				+ ", número_Documento=" + número_Documento + ", fecha_Expedición_Documento="
				+ fecha_Expedición_Documento + ", importe_total_amparado_Documento=" + importe_total_amparado_Documento
				+ ", saldo_Disponible_Documento=" + saldo_Disponible_Documento + ", importe_Total_Pagar_Pedimento="
				+ importe_Total_Pagar_Pedimento + "]";
	}
	
	
	
	
	
	


}
