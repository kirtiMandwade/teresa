package com.formapp.model.mysql;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="`500`")
public class Pedimento extends AuditBase {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private long id;
	 private int Clave_del_Tipo_de_Registro;
	 private int Tipo_de_Movimiento;
	 private int Patente_o_autorización; 
	 private long número_de_pedimento;
	 private String Aduana_Sección_de_Despacho;
	 private String Acuse_Electrónico_de_Validación;
	 private int tipo_de_Pedimento	 ;
	 public Pedimento() {
	}

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

	public int getTipo_de_Movimiento() {
		return Tipo_de_Movimiento;
	}

	public void setTipo_de_Movimiento(int tipo_de_Movimiento) {
		Tipo_de_Movimiento = tipo_de_Movimiento;
	}

	public int getPatente_o_autorización() {
		return Patente_o_autorización;
	}

	public void setPatente_o_autorización(int patente_o_autorización) {
		Patente_o_autorización = patente_o_autorización;
	}

	

	public long getNúmero_de_pedimento() {
		return número_de_pedimento;
	}

	public void setNúmero_de_pedimento(long número_de_pedimento) {
		this.número_de_pedimento = número_de_pedimento;
	}

	public String getAduana_Sección_de_Despacho() {
		return Aduana_Sección_de_Despacho;
	}

	public void setAduana_Sección_de_Despacho(String aduana_Sección_de_Despacho) {
		Aduana_Sección_de_Despacho = aduana_Sección_de_Despacho;
	}

	public String getAcuse_Electrónico_de_Validación() {
		return Acuse_Electrónico_de_Validación;
	}

	public void setAcuse_Electrónico_de_Validación(String acuse_Electrónico_de_Validación) {
		Acuse_Electrónico_de_Validación = acuse_Electrónico_de_Validación;
	}

	public int getTipo_de_Pedimento() {
		return tipo_de_Pedimento;
	}

	public void setTipo_de_Pedimento(int tipo_de_Pedimento) {
		this.tipo_de_Pedimento = tipo_de_Pedimento;
	}

	@Override
	public String toString() {
		return "Pedimento [id=" + id + ", Clave_del_Tipo_de_Registro=" + Clave_del_Tipo_de_Registro
				+ ", Tipo_de_Movimiento=" + Tipo_de_Movimiento + ", Patente_o_autorización=" + Patente_o_autorización
				+ ", número_de_pedimento=" + número_de_pedimento + ", Aduana_Sección_de_Despacho="
				+ Aduana_Sección_de_Despacho + ", Acuse_Electrónico_de_Validación=" + Acuse_Electrónico_de_Validación
				+ ", tipo_de_Pedimento=" + tipo_de_Pedimento + "]";
	}
	 
	 
	 
	 
	 
}
