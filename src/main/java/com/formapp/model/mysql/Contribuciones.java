package com.formapp.model.mysql;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="`510`")
public class Contribuciones extends AuditBase {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private long id;
	
	private int clave_del_Tipo_de_Registro;
	private long número_de_pedimento;


	private int clave_Contribución; 
	private int clave_Forma_Pago; 
	private long importe_Contribución;
	
	 
	
	public Contribuciones() {
	
	}
	
	public long getNúmero_de_pedimento() {
		return número_de_pedimento;
	}
	public void setNúmero_de_pedimento(long número_de_pedimento) {
		this.número_de_pedimento = número_de_pedimento;
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
	
	public int getClave_Contribución() {
		return clave_Contribución;
	}
	public void setClave_Contribución(int clave_Contribución) {
		this.clave_Contribución = clave_Contribución;
	}
	public int getClave_Forma_Pago() {
		return clave_Forma_Pago;
	}
	public void setClave_Forma_Pago(int clave_Forma_Pago) {
		this.clave_Forma_Pago = clave_Forma_Pago;
	}
	public long getImporte_Contribución() {
		return importe_Contribución;
	}
	public void setImporte_Contribución(long importe_Contribución) {
		this.importe_Contribución = importe_Contribución;
	}

	@Override
	public String toString() {
		return "Contribuciones [id=" + id + ", clave_del_Tipo_de_Registro=" + clave_del_Tipo_de_Registro
				+ ", número_de_pedimento=" + número_de_pedimento + ", clave_Contribución=" + clave_Contribución
				+ ", clave_Forma_Pago=" + clave_Forma_Pago + ", importe_Contribución=" + importe_Contribución + "]";
	}  
	
	

}
