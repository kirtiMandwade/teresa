package com.formapp.model.mysql;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="`702`")
public class DiferenciasContribuciones  extends AuditBase{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private long id;
	
	private int clave_del_Tipo_de_Registro;
	private int clave_Contribución ;
	private long número_de_pedimento;
	private int clave_forma_pago  ;
	private long importe_Pago ;
	
	
	
	
	
	public DiferenciasContribuciones() {
		
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
	
	public long getNúmero_de_pedimento() {
		return número_de_pedimento;
	}
	public void setNúmero_de_pedimento(long número_de_pedimento) {
		this.número_de_pedimento = número_de_pedimento;
	}
	public int getClave_forma_pago() {
		return clave_forma_pago;
	}
	public void setClave_forma_pago(int clave_forma_pago) {
		this.clave_forma_pago = clave_forma_pago;
	}
	public long getImporte_Pago() {
		return importe_Pago;
	}
	public void setImporte_Pago(long importe_Pago) {
		this.importe_Pago = importe_Pago;
	}
	@Override
	public String toString() {
		return "DiferenciasContribuciones [id=" + id + ", clave_del_Tipo_de_Registro=" + clave_del_Tipo_de_Registro
				+ ", clave_Contribución=" + clave_Contribución + ", número_de_pedimento=" + número_de_pedimento
				+ ", clave_forma_pago=" + clave_forma_pago + ", importe_Pago=" + importe_Pago + "]";
	}
	
	
	

}
