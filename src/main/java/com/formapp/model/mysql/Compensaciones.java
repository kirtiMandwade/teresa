package com.formapp.model.mysql;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="`513`")
public class Compensaciones extends AuditBase {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private long id;
	
	private int clave_del_Tipo_de_Registro;
	private long número_de_pedimento;
	
	private int patente_autorización_original;
	private long número_Pedimento_operación_original;
	private String clave_Aduana_sección_realizo_operación_original; 
	Date fecha_Pago_Operación_Original;
	private int clave_Contribución_Compensada;
	private long importe_Compensado;
	
	
	
	public Compensaciones() {
		
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
	public int getPatente_autorización_original() {
		return patente_autorización_original;
	}
	public void setPatente_autorización_original(int patente_autorización_original) {
		this.patente_autorización_original = patente_autorización_original;
	}
	public long getNúmero_Pedimento_operación_original() {
		return número_Pedimento_operación_original;
	}
	public void setNúmero_Pedimento_operación_original(long número_Pedimento_operación_original) {
		this.número_Pedimento_operación_original = número_Pedimento_operación_original;
	}
	public String getClave_Aduana_sección_realizo_operación_original() {
		return clave_Aduana_sección_realizo_operación_original;
	}
	public void setClave_Aduana_sección_realizo_operación_original(String clave_Aduana_sección_realizo_operación_original) {
		this.clave_Aduana_sección_realizo_operación_original = clave_Aduana_sección_realizo_operación_original;
	}
	public Date getFecha_Pago_Operación_Original() {
		return fecha_Pago_Operación_Original;
	}
	public void setFecha_Pago_Operación_Original(Date fecha_Pago_Operación_Original) {
		this.fecha_Pago_Operación_Original = fecha_Pago_Operación_Original;
	}
	public int getClave_Contribución_Compensada() {
		return clave_Contribución_Compensada;
	}
	public void setClave_Contribución_Compensada(int clave_Contribución_Compensada) {
		this.clave_Contribución_Compensada = clave_Contribución_Compensada;
	}
	public long getImporte_Compensado() {
		return importe_Compensado;
	}
	public void setImporte_Compensado(long importe_Compensado) {
		this.importe_Compensado = importe_Compensado;
	}
	
	
	
	@Override
	public String toString() {
		return "Compensaciones [id=" + id + ", clave_del_Tipo_de_Registro=" + clave_del_Tipo_de_Registro
				+ ", número_de_pedimento=" + número_de_pedimento + ", patente_autorización_original="
				+ patente_autorización_original + ", número_Pedimento_operación_original="
				+ número_Pedimento_operación_original + ", clave_Aduana_sección_realizo_operación_original="
				+ clave_Aduana_sección_realizo_operación_original + ", fecha_Pago_Operación_Original="
				+ fecha_Pago_Operación_Original + ", clave_Contribución_Compensada=" + clave_Contribución_Compensada
				+ ", importe_Compensado=" + importe_Compensado + "]";
	}
	
	
	


}
