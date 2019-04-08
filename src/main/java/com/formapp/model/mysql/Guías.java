package com.formapp.model.mysql;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="`503`")
public class Guías extends AuditBase{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private long id;
	
	private int Clave_del_Tipo_de_Registro;
	private long número_de_pedimento;
	private String Número_de_guía,_manifiesto_o_conocimiento_de_embarque;
	private String Identificador_de_Guía;
	
	public Guías() {
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

	public String getNúmero_de_guía() {
		return Número_de_guía;
	}

	public void setNúmero_de_guía(String número_de_guía) {
		Número_de_guía = número_de_guía;
	}

	public String get_manifiesto_o_conocimiento_de_embarque() {
		return _manifiesto_o_conocimiento_de_embarque;
	}

	public void set_manifiesto_o_conocimiento_de_embarque(String _manifiesto_o_conocimiento_de_embarque) {
		this._manifiesto_o_conocimiento_de_embarque = _manifiesto_o_conocimiento_de_embarque;
	}

	public String getIdentificador_de_Guía() {
		return Identificador_de_Guía;
	}

	public void setIdentificador_de_Guía(String identificador_de_Guía) {
		Identificador_de_Guía = identificador_de_Guía;
	}

	@Override
	public String toString() {
		return "Guías [id=" + id + ", Clave_del_Tipo_de_Registro=" + Clave_del_Tipo_de_Registro
				+ ", número_de_pedimento=" + número_de_pedimento + ", Número_de_guía=" + Número_de_guía
				+ ", _manifiesto_o_conocimiento_de_embarque=" + _manifiesto_o_conocimiento_de_embarque
				+ ", Identificador_de_Guía=" + Identificador_de_Guía + "]";
	}
	
	
	
}
