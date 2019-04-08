package com.formapp.model.mysql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="`502`")
public class Transporte extends AuditBase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private long id;
	
	private int Clave_del_Tipo_de_Registro;
	private long  número_de_pedimento;
	private String  RFC_del_Transportista;
	
	private String CURP_del_Transportista;
	 @Column(length=120)
	private String Nombre_Transportista;
	private String  País_del_medio_de_Transporte;
	private String  Identificador_del_Transporte;
	private int  Total_de_Bultos;
	 @Column(length=150)
	private String Domicilio_fiscal_del_Transportista;

	 
	 
	 
	 public Transporte() {
		
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
	
	
	public long getNúmero_de_pedimento() {
		return número_de_pedimento;
	}
	public void setNúmero_de_pedimento(long número_de_pedimento) {
		this.número_de_pedimento = número_de_pedimento;
	}
	public String getRFC_del_Transportista() {
		return RFC_del_Transportista;
	}
	public void setRFC_del_Transportista(String rfc_del_Transportista) {
		RFC_del_Transportista = rfc_del_Transportista;
	}
	public String getCURP_del_Transportista() {
		return CURP_del_Transportista;
	}
	public void setCURP_del_Transportista(String curl_del_Transportista) {
		CURP_del_Transportista = curl_del_Transportista;
	}
	public String getNombre_Transportista() {
		return Nombre_Transportista;
	}
	public void setNombre_Transportista(String nombre_Transportista) {
		Nombre_Transportista = nombre_Transportista;
	}
	public String getPaís_del_medio_de_Transporte() {
		return País_del_medio_de_Transporte;
	}
	public void setPaís_del_medio_de_Transporte(String país_del_medio_de_Transporte) {
		País_del_medio_de_Transporte = país_del_medio_de_Transporte;
	}
	public String getIdentificador_del_Transporte() {
		return Identificador_del_Transporte;
	}
	public void setIdentificador_del_Transporte(String identificador_del_Transporte) {
		Identificador_del_Transporte = identificador_del_Transporte;
	}
	public int getTotal_de_Bultos() {
		return Total_de_Bultos;
	}
	public void setTotal_de_Bultos(int total_de_Bultos) {
		Total_de_Bultos = total_de_Bultos;
	}
	public String getDomicilio_fiscal_del_Transportista() {
		return Domicilio_fiscal_del_Transportista;
	}
	public void setDomicilio_fiscal_del_Transportista(String domicilio_fiscal_del_Transportista) {
		Domicilio_fiscal_del_Transportista = domicilio_fiscal_del_Transportista;
	}
	
	@Override
	public String toString() {
		return "Transporte [id=" + id + ", Clave_del_Tipo_de_Registro=" + Clave_del_Tipo_de_Registro
				+ ", número_de_pedimento=" + número_de_pedimento + ", RFC_del_Transportista=" + RFC_del_Transportista
				+ ", CURP_del_Transportista=" + CURP_del_Transportista + ", Nombre_Transportista="
				+ Nombre_Transportista + ", País_del_medio_de_Transporte=" + País_del_medio_de_Transporte
				+ ", Identificador_del_Transporte=" + Identificador_del_Transporte + ", Total_de_Bultos="
				+ Total_de_Bultos + ", Domicilio_fiscal_del_Transportista=" + Domicilio_fiscal_del_Transportista + "]";
	}
	
	
	 

}
