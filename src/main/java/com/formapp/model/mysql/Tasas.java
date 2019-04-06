package com.formapp.model.mysql;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="`509`")
public class Tasas extends AuditBase {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private long id;
	
	private int clave_del_Tipo_de_Registro;
	private long número_Pedimento;
	private int clave_Contribución;
	private double tasa_Contribución;
	private int clave_Tipo_Tasa;
	
	
	
	
	public Tasas() {
		
	}
	
	public Tasas(int clave_del_Tipo_de_Registro, long número_Pedimento, int clave_Contribución,
			double tasa_Contribución, int clave_Tipo_Tasa) {
	
		this.clave_del_Tipo_de_Registro = clave_del_Tipo_de_Registro;
		número_Pedimento = número_Pedimento;
		clave_Contribución = clave_Contribución;
		tasa_Contribución = tasa_Contribución;
		clave_Tipo_Tasa = clave_Tipo_Tasa;
	}

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

	
	
	public long getNúmero_Pedimento() {
		return número_Pedimento;
	}

	public void setNúmero_Pedimento(long número_Pedimento) {
		this.número_Pedimento = número_Pedimento;
	}

	public int getClave_Contribución() {
		return clave_Contribución;
	}

	public void setClave_Contribución(int clave_Contribución) {
		this.clave_Contribución = clave_Contribución;
	}

	
	
	
	public double getTasa_Contribución() {
		return tasa_Contribución;
	}

	public void setTasa_Contribución(double tasa_Contribución) {
		this.tasa_Contribución = tasa_Contribución;
	}

	public int getClave_Tipo_Tasa() {
		return clave_Tipo_Tasa;
	}

	public void setClave_Tipo_Tasa(int clave_Tipo_Tasa) {
		this.clave_Tipo_Tasa = clave_Tipo_Tasa;
	}

	@Override
	public String toString() {
		return "Tasas [id=" + id + ", clave_del_Tipo_de_Registro=" + clave_del_Tipo_de_Registro + ", número_Pedimento="
				+ número_Pedimento + ", clave_Contribución=" + clave_Contribución + ", tasa_Contribución="
				+ tasa_Contribución + ", clave_Tipo_Tasa=" + clave_Tipo_Tasa + "]";
	}
	
	
}
