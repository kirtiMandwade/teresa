package com.formapp.model.mysql;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="`512`")
public class Descargos  extends AuditBase{

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private long id;
	
	private int clave_del_Tipo_de_Registro;
	private long número_Pedimento;
	private int  patente_autorización_original;

	private int número_Pedimento_operación_original; 
	
	private String aduana_secció_realizó_operacion_original;
	
	private String clave_documento_tramite_operacion_original_última_rectificación; 
	
	Date fecha_pago_pedimento_original; 
	
	private String fracción_arancelaria_descargando;
	
	private int clave_medida_LIGIE; 

	private int cantidad_mercancía_descarga_fracción;

	
	public Descargos() {
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
	

	


	public int getPatente_autorización_original() {
		return patente_autorización_original;
	}

	public void setPatente_autorización_original(int patente_autorización_original) {
		this.patente_autorización_original = patente_autorización_original;
	}

	public int getNúmero_Pedimento_operación_original() {
		return número_Pedimento_operación_original;
	}

	public void setNúmero_Pedimento_operación_original(int número_Pedimento_operación_original) {
		this.número_Pedimento_operación_original = número_Pedimento_operación_original;
	}

	public String getAduana_secció_realizó_operacion_original() {
		return aduana_secció_realizó_operacion_original;
	}

	public void setAduana_secció_realizó_operacion_original(String aduana_secció_realizó_operacion_original) {
		this.aduana_secció_realizó_operacion_original = aduana_secció_realizó_operacion_original;
	}

	public String getClave_documento_tramite_operacion_original_última_rectificación() {
		return clave_documento_tramite_operacion_original_última_rectificación;
	}

	public void setClave_documento_tramite_operacion_original_última_rectificación(
			String clave_documento_tramite_operacion_original_última_rectificación) {
		this.clave_documento_tramite_operacion_original_última_rectificación = clave_documento_tramite_operacion_original_última_rectificación;
	}

	public Date getFecha_pago_pedimento_original() {
		return fecha_pago_pedimento_original;
	}

	public void setFecha_pago_pedimento_original(Date fecha_pago_pedimento_original) {
		this.fecha_pago_pedimento_original = fecha_pago_pedimento_original;
	}

	public String getFracción_arancelaria_descargando() {
		return fracción_arancelaria_descargando;
	}

	public void setFracción_arancelaria_descargando(String fracción_arancelaria_descargando) {
		this.fracción_arancelaria_descargando = fracción_arancelaria_descargando;
	}

	public int getClave_medida_LIGIE() {
		return clave_medida_LIGIE;
	}

	public void setClave_medida_LIGIE(int clave_medida_LIGIE) {
		this.clave_medida_LIGIE = clave_medida_LIGIE;
	}

	public int getCantidad_mercancía_descarga_fracción() {
		return cantidad_mercancía_descarga_fracción;
	}

	public void setCantidad_mercancía_descarga_fracción(int cantidad_mercancía_descarga_fracción) {
		this.cantidad_mercancía_descarga_fracción = cantidad_mercancía_descarga_fracción;
	} 
	@Override
	public String toString() {
		return "Descargos [id=" + id + ", clave_del_Tipo_de_Registro=" + clave_del_Tipo_de_Registro + ", número_Pedimento="
				+ número_Pedimento + ", patente_autorización_original=" + patente_autorización_original
				+ ", número_Pedimento_operación_original=" + número_Pedimento_operación_original
				+ ", aduana_secció_realizó_operacion_original=" + aduana_secció_realizó_operacion_original
				+ ", clave_documento_tramite_operacion_original_última_rectificación="
				+ clave_documento_tramite_operacion_original_última_rectificación + ", fecha_pago_pedimento_original="
				+ fecha_pago_pedimento_original + ", fracción_arancelaria_descargando="
				+ fracción_arancelaria_descargando + ", clave_medida_LIGIE=" + clave_medida_LIGIE
				+ ", cantidad_mercancía_descarga_fracción=" + cantidad_mercancía_descarga_fracción + "]";
	}
	
	
}
