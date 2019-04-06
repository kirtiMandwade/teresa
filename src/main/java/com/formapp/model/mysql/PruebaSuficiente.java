package com.formapp.model.mysql;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="`302`")
public class PruebaSuficiente extends AuditBase{



	
	public PruebaSuficiente() {
		
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private long id;
	
	private int clave_del_Tipo_de_Registro;
	private long número_Pedimento;
	private String país_Destino ;
	private String número_Pedimento_EUA_CAN;
	private int prueba_Suficiente ;
	Date fecha_Documento;
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
	public String getPaís_Destino() {
		return país_Destino;
	}
	public void setPaís_Destino(String país_Destino) {
		this.país_Destino = país_Destino;
	}
	public String getNúmero_Pedimento_EUA_CAN() {
		return número_Pedimento_EUA_CAN;
	}
	public void setNúmero_Pedimento_EUA_CAN(String número_Pedimento_EUA_CAN) {
		this.número_Pedimento_EUA_CAN = número_Pedimento_EUA_CAN;
	}
	public int getPrueba_Suficiente() {
		return prueba_Suficiente;
	}
	public void setPrueba_Suficiente(int prueba_Suficiente) {
		this.prueba_Suficiente = prueba_Suficiente;
	}
	public Date getFecha_Documento() {
		return fecha_Documento;
	}
	public void setFecha_Documento(Date fecha_Documento) {
		this.fecha_Documento = fecha_Documento;
	}
	
	
	
	@Override
	public String toString() {
		return "PruebaSuficiente [id=" + id + ", clave_del_Tipo_de_Registro=" + clave_del_Tipo_de_Registro + ", número_Pedimento="
				+ número_Pedimento + ", país_Destino=" + país_Destino + ", número_Pedimento_EUA_CAN="
				+ número_Pedimento_EUA_CAN + ", prueba_Suficiente=" + prueba_Suficiente + ", fecha_Documento="
				+ fecha_Documento + "]";
	}
	
	
	
}
