package com.formapp.model.mysql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="`801`")
public class FindeArchivo extends AuditBase {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
 private long id;

private int clave_del_Tipo_de_Registro; 
private String nombre_Archivo ;
private int cantidad_Pedimentos;

private int cantidad_Registros  ;

private String clave_Prevalidador;




public FindeArchivo() {
	
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

public String getNombre_Archivo() {
	return nombre_Archivo;
}

public void setNombre_Archivo(String nombre_Archivo) {
	this.nombre_Archivo = nombre_Archivo;
}

public int getCantidad_Pedimentos() {
	return cantidad_Pedimentos;
}

public void setCantidad_Pedimentos(int cantidad_Pedimentos) {
	this.cantidad_Pedimentos = cantidad_Pedimentos;
}

public int getCantidad_Registros() {
	return cantidad_Registros;
}

public void setCantidad_Registros(int cantidad_Registros) {
	this.cantidad_Registros = cantidad_Registros;
}

public String getClave_Prevalidador() {
	return clave_Prevalidador;
}

public void setClave_Prevalidador(String clave_Prevalidador) {
	this.clave_Prevalidador = clave_Prevalidador;
}

@Override
public String toString() {
	return "FindeArchivo [id=" + id + ", clave_del_Tipo_de_Registro=" + clave_del_Tipo_de_Registro + ", nombre_Archivo="
			+ nombre_Archivo + ", cantidad_Pedimentos=" + cantidad_Pedimentos + ", cantidad_Registros="
			+ cantidad_Registros + ", clave_Prevalidador=" + clave_Prevalidador + "]";
}





}
