package com.formapp.model.mysql;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="`701`")
public class Rectificación extends AuditBase {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private long id;
	
	private int clave_del_Tipo_de_Registro;
	private int patente_autorización;
	private long número_de_pedimento;
	private String aduana_sección_despacho ;
	private String clave_pedimento_rectificar;
	Date fecha_pago ;
	private long número_Pedimento_operacion_original_rectificación ;
	private int patente_autorización_original ;
	private String aduana_sección_realizó_original_rectificación; 
	private String clave_documento_original_rectificación;
	Date fecha_original_rectificación  ;
	
	
	
	
	public Rectificación() {
		
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
	public String getClave_pedimento_rectificar() {
		return clave_pedimento_rectificar;
	}
	public void setClave_pedimento_rectificar(String clave_pedimento_rectificar) {
		this.clave_pedimento_rectificar = clave_pedimento_rectificar;
	}
	public Date getFecha_pago() {
		return fecha_pago;
	}
	public void setFecha_pago(Date fecha_pago) {
		this.fecha_pago = fecha_pago;
	}
	public long getNúmero_Pedimento_operacion_original_rectificación() {
		return número_Pedimento_operacion_original_rectificación;
	}
	public void setNúmero_Pedimento_operacion_original_rectificación(
			long número_Pedimento_operacion_original_rectificación) {
		this.número_Pedimento_operacion_original_rectificación = número_Pedimento_operacion_original_rectificación;
	}
	public int getPatente_autorización_original() {
		return patente_autorización_original;
	}
	public void setPatente_autorización_original(int patente_autorización_original) {
		this.patente_autorización_original = patente_autorización_original;
	}
	public String getAduana_sección_realizó_original_rectificación() {
		return aduana_sección_realizó_original_rectificación;
	}
	public void setAduana_sección_realizó_original_rectificación(String aduana_sección_realizó_original_rectificación) {
		this.aduana_sección_realizó_original_rectificación = aduana_sección_realizó_original_rectificación;
	}
	public String getClave_documento_original_rectificación() {
		return clave_documento_original_rectificación;
	}
	public void setClave_documento_original_rectificación(String clave_documento_original_rectificación) {
		this.clave_documento_original_rectificación = clave_documento_original_rectificación;
	}
	public Date getFecha_original_rectificación() {
		return fecha_original_rectificación;
	}
	public void setFecha_original_rectificación(Date fecha_original_rectificación) {
		this.fecha_original_rectificación = fecha_original_rectificación;
	}
	
	
	@Override
	public String toString() {
		return "Rectificación [id=" + id + ", clave_del_Tipo_de_Registro=" + clave_del_Tipo_de_Registro
				+ ", patente_autorización=" + patente_autorización + ", número_de_pedimento=" + número_de_pedimento
				+ ", aduana_sección_despacho=" + aduana_sección_despacho + ", clave_pedimento_rectificar="
				+ clave_pedimento_rectificar + ", fecha_pago=" + fecha_pago
				+ ", número_Pedimento_operacion_original_rectificación="
				+ número_Pedimento_operacion_original_rectificación + ", patente_autorización_original="
				+ patente_autorización_original + ", aduana_sección_realizó_original_rectificación="
				+ aduana_sección_realizó_original_rectificación + ", clave_documento_original_rectificación="
				+ clave_documento_original_rectificación + ", fecha_original_rectificación="
				+ fecha_original_rectificación + "]";
	}
	
	
	
	
	
	



}
