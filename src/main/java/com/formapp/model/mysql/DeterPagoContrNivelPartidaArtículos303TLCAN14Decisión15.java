package com.formapp.model.mysql;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="`353`")
public class DeterPagoContrNivelPartidaArtículos303TLCAN14Decisión15 extends AuditBase {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private long id;
	
	private int clave_del_Tipo_de_Registro; 
	private long número_de_pedimento;
	private String fracción_Arancelaria;
	private int número_Partida; 
	
	private long valor_Mercancía_originaria ;
	
	private long monto_IGI;

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

	public long getNúmero_de_pedimento() {
		return número_de_pedimento;
	}

	public void setNúmero_de_pedimento(long número_de_pedimento) {
		this.número_de_pedimento = número_de_pedimento;
	}

	public String getFracción_Arancelaria() {
		return fracción_Arancelaria;
	}

	public void setFracción_Arancelaria(String fracción_Arancelaria) {
		this.fracción_Arancelaria = fracción_Arancelaria;
	}

	public int getNúmero_Partida() {
		return número_Partida;
	}

	public void setNúmero_Partida(int número_Partida) {
		this.número_Partida = número_Partida;
	}

	public long getValor_Mercancía_originaria() {
		return valor_Mercancía_originaria;
	}

	public void setValor_Mercancía_originaria(long valor_Mercancía_originaria) {
		this.valor_Mercancía_originaria = valor_Mercancía_originaria;
	}

	public long getMonto_IGI() {
		return monto_IGI;
	}

	public void setMonto_IGI(long monto_IGI) {
		this.monto_IGI = monto_IGI;
	}

	@Override
	public String toString() {
		return "DeterPagoContrNivelPartidaArtículos303TLCAN14Decisión15 [id=" + id + ", clave_del_Tipo_de_Registro="
				+ clave_del_Tipo_de_Registro + ", número_de_pedimento=" + número_de_pedimento
				+ ", fracción_Arancelaria=" + fracción_Arancelaria + ", número_Partida=" + número_Partida
				+ ", valor_Mercancía_originaria=" + valor_Mercancía_originaria + ", monto_IGI=" + monto_IGI + "]";
	}

}
