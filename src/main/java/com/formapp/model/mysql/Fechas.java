package com.formapp.model.mysql;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="`506`")
public class Fechas  extends AuditBase{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private long id;
	
	private int clave_del_Tipo_de_Registro;
	private long Número_Pedimento;
	
	private int Tipo_fecha;
	Date Fecha;
	
	
	
	public Fechas() {
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
		clave_del_Tipo_de_Registro = clave_del_Tipo_de_Registro;
	}
	public long getNúmero_Pedimento() {
		return Número_Pedimento;
	}
	public void setNúmero_Pedimento(long número_Pedimento) {
		Número_Pedimento = número_Pedimento;
	}
	public int getTipo_fecha() {
		return Tipo_fecha;
	}
	public void setTipo_fecha(int tipo_fecha) {
		Tipo_fecha = tipo_fecha;
	}
	public Date getFecha() {
		return Fecha;
	}
	public void setFecha(Date fecha) {
		Fecha = fecha;
	}
	
	
	@Override
	public String toString() {
		return "Fechas [id=" + id + ", clave_del_Tipo_de_Registro=" + clave_del_Tipo_de_Registro + ", Número_Pedimento="
				+ Número_Pedimento + ", Tipo_fecha=" + Tipo_fecha + ", Fecha=" + Fecha + "]";
	} 
	 
	
}