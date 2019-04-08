package com.formapp.model.mysql;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.google.gson.annotations.Expose;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AuditBase {
	
	
	private static final long serialVersionUID = 1L;

	@Expose
	@Column(columnDefinition = "TIMESTAMP  DEFAULT CURRENT_TIMESTAMP", updatable = false)
	private Timestamp fecha_creacion;
	@Expose
	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp fecha_modificacion;
	
	@Expose
	@Column
	private int clave_formulario_principal;

	
	
	@PrePersist
	protected void onPrePersist() {
		fecha_creacion = new Timestamp(new Date().getTime());
		fecha_modificacion= new Timestamp(new Date().getTime());
	}

	@PreUpdate
	protected void onPreUpdate() {
		fecha_modificacion = new Timestamp(new Date().getTime());
	}

	
	
	public Timestamp getFecha_creacion() {
		return fecha_creacion;
	}
	public void setFecha_creacion(Timestamp fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	public Timestamp getFecha_modificacion() {
		return fecha_modificacion;
	}
	public void setFecha_modificacion(Timestamp fecha_modificacion) {
		this.fecha_modificacion = fecha_modificacion;
	}

	public int getClave_formulario_principal() {
		return clave_formulario_principal;
	}

	public void setClave_formulario_principal(int clave_formulario_principal) {
		this.clave_formulario_principal = clave_formulario_principal;
	}
	
	
}
