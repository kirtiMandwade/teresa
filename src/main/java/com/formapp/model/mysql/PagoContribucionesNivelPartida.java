package com.formapp.model.mysql;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="`355`")
public class PagoContribucionesNivelPartida extends AuditBase {


	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private long id;
	
	private int clave_del_Tipo_de_Registro; 
	private long número_pedimento;
	private String país_Destino_mercancía ;
	private long fracción_Arancelaria;
	private int número_Partida;
	
	private int clave_Contribución  ;
	
	private int forma_Pago;
	private long importe_Pago;
	
	
	public PagoContribucionesNivelPartida() {
		
		
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
	public long getNúmero_pedimento() {
		return número_pedimento;
	}
	public void setNúmero_pedimento(long número_pedimento) {
		this.número_pedimento = número_pedimento;
	}
	public String getPaís_Destino_mercancía() {
		return país_Destino_mercancía;
	}
	public void setPaís_Destino_mercancía(String país_Destino_mercancía) {
		this.país_Destino_mercancía = país_Destino_mercancía;
	}
	public long getFracción_Arancelaria() {
		return fracción_Arancelaria;
	}
	public void setFracción_Arancelaria(long fracción_Arancelaria) {
		this.fracción_Arancelaria = fracción_Arancelaria;
	}
	public int getNúmero_Partida() {
		return número_Partida;
	}
	public void setNúmero_Partida(int número_Partida) {
		this.número_Partida = número_Partida;
	}
	public int getClave_Contribución() {
		return clave_Contribución;
	}
	public void setClave_Contribución(int clave_Contribución) {
		this.clave_Contribución = clave_Contribución;
	}
	public int getForma_Pago() {
		return forma_Pago;
	}
	public void setForma_Pago(int forma_Pago) {
		this.forma_Pago = forma_Pago;
	}
	public long getImporte_Pago() {
		return importe_Pago;
	}
	public void setImporte_Pago(long importe_Pago) {
		this.importe_Pago = importe_Pago;
	}
	
	
	@Override
	public String toString() {
		return "PagoContribucionesNivelPartida [id=" + id + ", clave_del_Tipo_de_Registro=" + clave_del_Tipo_de_Registro
				+ ", número_pedimento=" + número_pedimento + ", país_Destino_mercancía=" + país_Destino_mercancía
				+ ", fracción_Arancelaria=" + fracción_Arancelaria + ", número_Partida=" + número_Partida
				+ ", clave_Contribución=" + clave_Contribución + ", forma_Pago=" + forma_Pago + ", importe_Pago="
				+ importe_Pago + "]";
	}
	
	

}
