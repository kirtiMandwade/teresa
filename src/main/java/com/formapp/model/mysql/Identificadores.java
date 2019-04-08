package com.formapp.model.mysql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="`507`")
public class Identificadores extends AuditBase{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private int id;
	
		private int clave_del_Tipo_de_Registro ;
		private long número_de_pedimento;
		private String Clave_Identificador; 
		
		private String Complemento1 ;
		@Column(length=30)
		private String Complemento2 ;
		@Column(length=40)
		private String Complemento3 ;
		public int getId() {
			return id;
		}
		public void setId(int id) {
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
		public String getClave_Identificador() {
			return Clave_Identificador;
		}
		public void setClave_Identificador(String clave_Identificador) {
			Clave_Identificador = clave_Identificador;
		}
		public String getComplemento1() {
			return Complemento1;
		}
		public void setComplemento1(String complemento1) {
			Complemento1 = complemento1;
		}
		public String getComplemento2() {
			return Complemento2;
		}
		public void setComplemento2(String complemento2) {
			Complemento2 = complemento2;
		}
		public String getComplemento3() {
			return Complemento3;
		}
		public void setComplemento3(String complemento3) {
			Complemento3 = complemento3;
		}
		@Override
		public String toString() {
			return "Identificadores [id=" + id + ", clave_del_Tipo_de_Registro=" + clave_del_Tipo_de_Registro
					+ ", número_de_pedimento=" + número_de_pedimento + ", Clave_Identificador=" + Clave_Identificador
					+ ", Complemento1=" + Complemento1 + ", Complemento2=" + Complemento2 + ", Complemento3="
					+ Complemento3 + "]";
		}
	

}
