package com.formapp.model.mysql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="`501`")
public class Generales extends AuditBase{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private long id;
	
	private int clave_del_Tipo_de_Registro; 
	private int Patente_o_autorización; 
	private long Número_de_pedimento; 
	private String Aduana_sección_de_Despacho;
	private int Tipo_de_Operación; 
	private String Clave_de_pedimento; 
	private String Aduana_sección_de_Entrada_o_Salida; 
	private String Curp_importador_o_exportador;
	private String Rfc_importador_o_exportador;
	private String Curp_AAduanal_RLegal_ApoderadoA_Mandatario;
	private double Tipo_de_cambio;
	private long Importe_del_Pago_de_Fletes;
	private long Importe_del_Pago_de_Primas_de_Seguros; 
	
	private long Importe_del_Pago_de_Embalajes;
	private long Importe_del_Pago_de_Otros_Incrementables;
	private double Peso_Bruto_Total_de_la_Mercancíap;
	
	private int Medio_transporte_salida_aduana_seccion_salida;
	
	private int Medio_transporte_arribo_aduana_seccion_arribo;
	
	private int Medio_transporte_entrada_salida_mercancia_territorio_nacional;
	
	private int Origen_o_Destino_de_la_mercancía;
	 @Column(length=120)
	private String Nombre_del_Importador_o_Exportador;
	 @Column(length=80)
	private String Calle_domicilio_importador_o_exportador;
	private String Numero_interior_importador_exportador;
    private String Numero_exterior_importador_exportador;
	
   

	private String Codigo_postal_domicilio_fiscal_importador_exportador;
    @Column(length=80)
    private String Municipio_del_domicilio_del_importador_o_exportador;
    private String Entidad_federativa_del_domicilio_del_importador_o_exportador;
    private String	País_del_domicilio_fiscal_del_importador_o_exportador;
    private String rfc_de_facturación_de_los_servicios_de_la_operación;

	
    public Generales() {
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

	public int getPatente_o_autorización() {
		return Patente_o_autorización;
	}

	public void setPatente_o_autorización(int patente_o_autorización) {
		Patente_o_autorización = patente_o_autorización;
	}

	public long getNúmero_de_pedimento() {
		return Número_de_pedimento;
	}

	public void setNúmero_de_pedimento(long número_de_pedimento) {
		Número_de_pedimento = número_de_pedimento;
	}

	public String getAduana_sección_de_Despacho() {
		return Aduana_sección_de_Despacho;
	}

	public void setAduana_sección_de_Despacho(String aduana_sección_de_Despacho) {
		Aduana_sección_de_Despacho = aduana_sección_de_Despacho;
	}

	public int getTipo_de_Operación() {
		return Tipo_de_Operación;
	}

	public void setTipo_de_Operación(int tipo_de_Operación) {
		Tipo_de_Operación = tipo_de_Operación;
	}

	public String getClave_de_pedimento() {
		return Clave_de_pedimento;
	}

	public void setClave_de_pedimento(String clave_de_pedimento) {
		Clave_de_pedimento = clave_de_pedimento;
	}

	public String getAduana_sección_de_Entrada_o_Salida() {
		return Aduana_sección_de_Entrada_o_Salida;
	}

	public void setAduana_sección_de_Entrada_o_Salida(String aduana_sección_de_Entrada_o_Salida) {
		Aduana_sección_de_Entrada_o_Salida = aduana_sección_de_Entrada_o_Salida;
	}

	public String getCurp_importador_o_exportador() {
		return Curp_importador_o_exportador;
	}

	public void setCurp_importador_o_exportador(String curp_importador_o_exportador) {
		Curp_importador_o_exportador = curp_importador_o_exportador;
	}

	public String getRfc_importador_o_exportador() {
		return Rfc_importador_o_exportador;
	}

	public void setRfc_importador_o_exportador(String rfc_importador_o_exportador) {
		Rfc_importador_o_exportador = rfc_importador_o_exportador;
	}

	public String getCurp_AAduanal_RLegal_ApoderadoA_Mandatario() {
		return Curp_AAduanal_RLegal_ApoderadoA_Mandatario;
	}

	public void setCurp_AAduanal_RLegal_ApoderadoA_Mandatario(String curp_AAduanal_RLegal_ApoderadoA_Mandatario) {
		Curp_AAduanal_RLegal_ApoderadoA_Mandatario = curp_AAduanal_RLegal_ApoderadoA_Mandatario;
	}

	public double getTipo_de_cambio() {
		return Tipo_de_cambio;
	}

	public void setTipo_de_cambio(double tipo_de_cambio) {
		Tipo_de_cambio = tipo_de_cambio;
	}

	public long getImporte_del_Pago_de_Fletes() {
		return Importe_del_Pago_de_Fletes;
	}

	public void setImporte_del_Pago_de_Fletes(long importe_del_Pago_de_Fletes) {
		Importe_del_Pago_de_Fletes = importe_del_Pago_de_Fletes;
	}

	public long getImporte_del_Pago_de_Primas_de_Seguros() {
		return Importe_del_Pago_de_Primas_de_Seguros;
	}

	public void setImporte_del_Pago_de_Primas_de_Seguros(long importe_del_Pago_de_Primas_de_Seguros) {
		Importe_del_Pago_de_Primas_de_Seguros = importe_del_Pago_de_Primas_de_Seguros;
	}

	public long getImporte_del_Pago_de_Embalajes() {
		return Importe_del_Pago_de_Embalajes;
	}

	public void setImporte_del_Pago_de_Embalajes(long importe_del_Pago_de_Embalajes) {
		Importe_del_Pago_de_Embalajes = importe_del_Pago_de_Embalajes;
	}

	public long getImporte_del_Pago_de_Otros_Incrementables() {
		return Importe_del_Pago_de_Otros_Incrementables;
	}

	public void setImporte_del_Pago_de_Otros_Incrementables(long importe_del_Pago_de_Otros_Incrementables) {
		Importe_del_Pago_de_Otros_Incrementables = importe_del_Pago_de_Otros_Incrementables;
	}

	

	public double getPeso_Bruto_Total_de_la_Mercancíap() {
		return Peso_Bruto_Total_de_la_Mercancíap;
	}

	public void setPeso_Bruto_Total_de_la_Mercancíap(double peso_Bruto_Total_de_la_Mercancíap) {
		Peso_Bruto_Total_de_la_Mercancíap = peso_Bruto_Total_de_la_Mercancíap;
	}

	public int getMedio_transporte_salida_aduana_seccion_salida() {
		return Medio_transporte_salida_aduana_seccion_salida;
	}

	public void setMedio_transporte_salida_aduana_seccion_salida(int medio_transporte_salida_aduana_seccion_salida) {
		Medio_transporte_salida_aduana_seccion_salida = medio_transporte_salida_aduana_seccion_salida;
	}

	public int getMedio_transporte_arribo_aduana_seccion_arribo() {
		return Medio_transporte_arribo_aduana_seccion_arribo;
	}

	public void setMedio_transporte_arribo_aduana_seccion_arribo(int medio_transporte_arribo_aduana_seccion_arribo) {
		Medio_transporte_arribo_aduana_seccion_arribo = medio_transporte_arribo_aduana_seccion_arribo;
	}

	public int getMedio_transporte_entrada_salida_mercancia_territorio_nacional() {
		return Medio_transporte_entrada_salida_mercancia_territorio_nacional;
	}

	public void setMedio_transporte_entrada_salida_mercancia_territorio_nacional(
			int medio_transporte_entrada_salida_mercancia_territorio_nacional) {
		Medio_transporte_entrada_salida_mercancia_territorio_nacional = medio_transporte_entrada_salida_mercancia_territorio_nacional;
	}

	public int getOrigen_o_Destino_de_la_mercancía() {
		return Origen_o_Destino_de_la_mercancía;
	}

	public void setOrigen_o_Destino_de_la_mercancía(int origen_o_Destino_de_la_mercancía) {
		Origen_o_Destino_de_la_mercancía = origen_o_Destino_de_la_mercancía;
	}

	public String getNombre_del_Importador_o_Exportador() {
		return Nombre_del_Importador_o_Exportador;
	}

	public void setNombre_del_Importador_o_Exportador(String nombre_del_Importador_o_Exportador) {
		Nombre_del_Importador_o_Exportador = nombre_del_Importador_o_Exportador;
	}

	public String getCalle_domicilio_importador_o_exportador() {
		return Calle_domicilio_importador_o_exportador;
	}

	public void setCalle_domicilio_importador_o_exportador(String calle_domicilio_importador_o_exportador) {
		Calle_domicilio_importador_o_exportador = calle_domicilio_importador_o_exportador;
	}

	public String getNumero_interior_importador_exportador() {
		return Numero_interior_importador_exportador;
	}

	public void setNumero_interior_importador_exportador(String numero_interior_importador_exportador) {
		Numero_interior_importador_exportador = numero_interior_importador_exportador;
	}

	public String getNumero_exterior_importador_exportador() {
		return Numero_exterior_importador_exportador;
	}

	public void setNumero_exterior_importador_exportador(String numero_exterior_importador_exportador) {
		Numero_exterior_importador_exportador = numero_exterior_importador_exportador;
	}

	public String getCodigo_postal_domicilio_fiscal_importador_exportador() {
		return Codigo_postal_domicilio_fiscal_importador_exportador;
	}

	public void setCodigo_postal_domicilio_fiscal_importador_exportador(
			String codigo_postal_domicilio_fiscal_importador_exportador) {
		Codigo_postal_domicilio_fiscal_importador_exportador = codigo_postal_domicilio_fiscal_importador_exportador;
	}

	public String getMunicipio_del_domicilio_del_importador_o_exportador() {
		return Municipio_del_domicilio_del_importador_o_exportador;
	}

	public void setMunicipio_del_domicilio_del_importador_o_exportador(
			String municipio_del_domicilio_del_importador_o_exportador) {
		Municipio_del_domicilio_del_importador_o_exportador = municipio_del_domicilio_del_importador_o_exportador;
	}

	public String getEntidad_federativa_del_domicilio_del_importador_o_exportador() {
		return Entidad_federativa_del_domicilio_del_importador_o_exportador;
	}

	public void setEntidad_federativa_del_domicilio_del_importador_o_exportador(
			String entidad_federativa_del_domicilio_del_importador_o_exportador) {
		Entidad_federativa_del_domicilio_del_importador_o_exportador = entidad_federativa_del_domicilio_del_importador_o_exportador;
	}

	public String getPaís_del_domicilio_fiscal_del_importador_o_exportador() {
		return País_del_domicilio_fiscal_del_importador_o_exportador;
	}

	public void setPaís_del_domicilio_fiscal_del_importador_o_exportador(
			String país_del_domicilio_fiscal_del_importador_o_exportador) {
		País_del_domicilio_fiscal_del_importador_o_exportador = país_del_domicilio_fiscal_del_importador_o_exportador;
	}

	public String getRfc_de_facturación_de_los_servicios_de_la_operación() {
		return rfc_de_facturación_de_los_servicios_de_la_operación;
	}

	public void setRfc_de_facturación_de_los_servicios_de_la_operación(
			String rfc_de_facturación_de_los_servicios_de_la_operación) {
		this.rfc_de_facturación_de_los_servicios_de_la_operación = rfc_de_facturación_de_los_servicios_de_la_operación;
	}

	
	
	
}
