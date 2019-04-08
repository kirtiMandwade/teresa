package com.formapp.model.mysql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="`520`")
public class Destinatario extends AuditBase {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private long id;
	
	private int clave_del_Tipo_de_Registro;
	private long número_de_pedimento;
	


	private String identificación_Fiscal_destinatario ;
	@Column(length=120)
	private String nombre_destinatario ;
	@Column(length=80)
	private String calle_domicilio_destinatario;
	private String número_interior_domicilio_Destinatario  ;
	private String número_exterior_domicilio_Destinatario; 
	private String código_postal_domicilio_Destinatario ; 
	@Column(length=80)
	private String muni_ciudad_domicilio_Destinatario ; 
	private String país_domicilio_Destinatario;
	
	public Destinatario() {
		
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

	

	public String getIdentificación_Fiscal_destinatario() {
		return identificación_Fiscal_destinatario;
	}

	public void setIdentificación_Fiscal_destinatario(String identificación_Fiscal_destinatario) {
		this.identificación_Fiscal_destinatario = identificación_Fiscal_destinatario;
	}

	public String getNombre_destinatario() {
		return nombre_destinatario;
	}

	public void setNombre_destinatario(String nombre_destinatario) {
		this.nombre_destinatario = nombre_destinatario;
	}

	public String getCalle_domicilio_destinatario() {
		return calle_domicilio_destinatario;
	}

	public void setCalle_domicilio_destinatario(String calle_domicilio_destinatario) {
		this.calle_domicilio_destinatario = calle_domicilio_destinatario;
	}

	public String getNúmero_interior_domicilio_Destinatario() {
		return número_interior_domicilio_Destinatario;
	}

	public void setNúmero_interior_domicilio_Destinatario(String número_interior_domicilio_Destinatario) {
		this.número_interior_domicilio_Destinatario = número_interior_domicilio_Destinatario;
	}

	public String getNúmero_exterior_domicilio_Destinatario() {
		return número_exterior_domicilio_Destinatario;
	}

	public void setNúmero_exterior_domicilio_Destinatario(String número_exterior_domicilio_Destinatario) {
		this.número_exterior_domicilio_Destinatario = número_exterior_domicilio_Destinatario;
	}

	public String getCódigo_postal_domicilio_Destinatario() {
		return código_postal_domicilio_Destinatario;
	}

	public void setCódigo_postal_domicilio_Destinatario(String código_postal_domicilio_Destinatario) {
		this.código_postal_domicilio_Destinatario = código_postal_domicilio_Destinatario;
	}

	public String getMuni_ciudad_domicilio_Destinatario() {
		return muni_ciudad_domicilio_Destinatario;
	}

	public void setMuni_ciudad_domicilio_Destinatario(String muni_ciudad_domicilio_Destinatario) {
		this.muni_ciudad_domicilio_Destinatario = muni_ciudad_domicilio_Destinatario;
	}

	public String getPaís_domicilio_Destinatario() {
		return país_domicilio_Destinatario;
	}

	public void setPaís_domicilio_Destinatario(String país_domicilio_Destinatario) {
		this.país_domicilio_Destinatario = país_domicilio_Destinatario;
	}
	public long getNúmero_de_pedimento() {
		return número_de_pedimento;
	}

	public void setNúmero_de_pedimento(long número_de_pedimento) {
		this.número_de_pedimento = número_de_pedimento;
	}

	

	@Override
	public String toString() {
		return "Destinatario [id=" + id + ", clave_del_Tipo_de_Registro=" + clave_del_Tipo_de_Registro
				+ ", número_de_pedimento=" + número_de_pedimento + ", identificación_Fiscal_destinatario="
				+ identificación_Fiscal_destinatario + ", nombre_destinatario=" + nombre_destinatario
				+ ", calle_domicilio_destinatario=" + calle_domicilio_destinatario
				+ ", número_interior_domicilio_Destinatario=" + número_interior_domicilio_Destinatario
				+ ", número_exterior_domicilio_Destinatario=" + número_exterior_domicilio_Destinatario
				+ ", código_postal_domicilio_Destinatario=" + código_postal_domicilio_Destinatario
				+ ", muni_ciudad_domicilio_Destinatario=" + muni_ciudad_domicilio_Destinatario
				+ ", país_domicilio_Destinatario=" + país_domicilio_Destinatario + "]";
	}
	
	
	

	

}
