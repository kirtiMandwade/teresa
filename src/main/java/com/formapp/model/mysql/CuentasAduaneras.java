package com.formapp.model.mysql;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "`508`")
public class CuentasAduaneras extends AuditBase {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private int clave_del_Tipo_de_Registro;
	private long número_de_pedimento;
	private int Emisora_Cuenta;
	private long Número_Contrato;
	private String Folio_Constancia;
	Date Fecha_de_la_Constancia;
	private int Tipo_Cuenta;
	private int Tipo_de_Garantía;
	private double Valor_unitario_título;
	private double Importe_Total_Garantía;
	private double Cantidad_Unidades_Medida;
	private double Titulos_Asignados;

	public CuentasAduaneras() {

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
		clave_del_Tipo_de_Registro = clave_del_Tipo_de_Registro;
	}

	public long getNúmero_de_pedimento() {
		return número_de_pedimento;
	}

	public void setNúmero_de_pedimento(long número_de_pedimento) {
		this.número_de_pedimento = número_de_pedimento;
	}

	public int getEmisora_Cuenta() {
		return Emisora_Cuenta;
	}

	public void setEmisora_Cuenta(int emisora_Cuenta) {
		Emisora_Cuenta = emisora_Cuenta;
	}

	public long getNúmero_Contrato() {
		return Número_Contrato;
	}

	public void setNúmero_Contrato(long número_Contrato) {
		Número_Contrato = número_Contrato;
	}

	public String getFolio_Constancia() {
		return Folio_Constancia;
	}

	public void setFolio_Constancia(String folio_Constancia) {
		Folio_Constancia = folio_Constancia;
	}

	public Date getFecha_de_la_Constancia() {
		return Fecha_de_la_Constancia;
	}

	public void setFecha_de_la_Constancia(Date fecha_de_la_Constancia) {
		Fecha_de_la_Constancia = fecha_de_la_Constancia;
	}

	public int getTipo_Cuenta() {
		return Tipo_Cuenta;
	}

	public void setTipo_Cuenta(int tipo_Cuenta) {
		Tipo_Cuenta = tipo_Cuenta;
	}

	public int getTipo_de_Garantía() {
		return Tipo_de_Garantía;
	}

	public void setTipo_de_Garantía(int tipo_de_Garantía) {
		Tipo_de_Garantía = tipo_de_Garantía;
	}

	public double getValor_unitario_título() {
		return Valor_unitario_título;
	}

	public void setValor_unitario_título(double valor_unitario_título) {
		Valor_unitario_título = valor_unitario_título;
	}

	public double getImporte_Total_Garantía() {
		return Importe_Total_Garantía;
	}

	public void setImporte_Total_Garantía(double importe_Total_Garantía) {
		Importe_Total_Garantía = importe_Total_Garantía;
	}

	public double getCantidad_Unidades_Medida() {
		return Cantidad_Unidades_Medida;
	}

	public void setCantidad_Unidades_Medida(double cantidad_Unidades_Medida) {
		Cantidad_Unidades_Medida = cantidad_Unidades_Medida;
	}

	public double getTitulos_Asignados() {
		return Titulos_Asignados;
	}

	public void setTitulos_Asignados(double titulos_Asignados) {
		Titulos_Asignados = titulos_Asignados;
	}

	@Override
	public String toString() {
		return "CuentasAduaneras [id=" + id + ", clave_del_Tipo_de_Registro=" + clave_del_Tipo_de_Registro
				+ ", número_de_pedimento=" + número_de_pedimento + ", Emisora_Cuenta=" + Emisora_Cuenta
				+ ", Número_Contrato=" + Número_Contrato + ", Folio_Constancia=" + Folio_Constancia
				+ ", Fecha_de_la_Constancia=" + Fecha_de_la_Constancia + ", Tipo_Cuenta=" + Tipo_Cuenta
				+ ", Tipo_de_Garantía=" + Tipo_de_Garantía + ", Valor_unitario_título=" + Valor_unitario_título
				+ ", Importe_Total_Garantía=" + Importe_Total_Garantía + ", Cantidad_Unidades_Medida="
				+ Cantidad_Unidades_Medida + ", Titulos_Asignados=" + Titulos_Asignados + "]";
	}

}
