package com.formapp.model.mysql;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="`557`")
public class ContribucionesNivelPartida extends AuditBase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private long id;
	
	private int clave_del_Tipo_de_Registro; 
	private long número_pedimento; 
	private String fracción_Arancelaria  ;
	private int número_Partida;
	
	private int clave_Contribución_pagar  ;
	private int forma_pago ;

	private long importe_Contribución  ;

	public ContribucionesNivelPartida() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	

	public long getNúmero_pedimento() {
		return número_pedimento;
	}

	public void setNúmero_pedimento(long número_pedimento) {
		this.número_pedimento = número_pedimento;
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

	public int getClave_Contribución_pagar() {
		return clave_Contribución_pagar;
	}

	public void setClave_Contribución_pagar(int clave_Contribución_pagar) {
		this.clave_Contribución_pagar = clave_Contribución_pagar;
	}

	public int getForma_pago() {
		return forma_pago;
	}

	public void setForma_pago(int forma_pago) {
		this.forma_pago = forma_pago;
	}

	public long getImporte_Contribución() {
		return importe_Contribución;
	}

	public void setImporte_Contribución(long importe_Contribución) {
		this.importe_Contribución = importe_Contribución;
	}
	

	public int getClave_del_Tipo_de_Registro() {
		return clave_del_Tipo_de_Registro;
	}

	public void setClave_del_Tipo_de_Registro(int clave_del_Tipo_de_Registro) {
		this.clave_del_Tipo_de_Registro = clave_del_Tipo_de_Registro;
	}

	@Override
	public String toString() {
		return "ContribucionesNivelPartida [id=" + id + ", clave_del_Tipo_de_Registro=" + clave_del_Tipo_de_Registro
				+ ", número_pedimento=" + número_pedimento + ", fracción_Arancelaria=" + fracción_Arancelaria
				+ ", número_Partida=" + número_Partida + ", clave_Contribución_pagar=" + clave_Contribución_pagar
				+ ", forma_pago=" + forma_pago + ", importe_Contribución=" + importe_Contribución + "]";
	}

	
	


}
