package com.formapp.model.mysql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "`510`")
public class Contribuciones extends AuditBase {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private int clave_del_Tipo_de_Registro;
	@Column(name = "número_de_Pedimento")
	private long númerodepedimento;

	private int clave_Contribución;
	private int clave_Forma_Pago;
	private long importe_Contribución;

	@Transient
	private double tasa_Contribución;
	@Transient
	private int clave_Tipo_Tasa;

	public Contribuciones() {

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

	public long getNúmerodepedimento() {
		return númerodepedimento;
	}

	public void setNúmerodepedimento(long númerodepedimento) {
		this.númerodepedimento = númerodepedimento;
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
		return "Contribuciones [id=" + id + ", clave_del_Tipo_de_Registro=" + clave_del_Tipo_de_Registro
				+ ", númerodepedimento=" + númerodepedimento + ", clave_Contribución=" + clave_Contribución
				+ ", clave_Forma_Pago=" + clave_Forma_Pago + ", importe_Contribución=" + importe_Contribución + "]";
	}

}
