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
		private long Número_Pedimento;
		private String Clave_Identificador; 
		
		private String Complemento1 ;
		@Column(length=30)
		private String Complemento2 ;
		@Column(length=40)
		private String Complemento3 ;
		
		
		
		public Identificadores() {
			
		}
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getclave_del_Tipo_de_Registro() {
			return clave_del_Tipo_de_Registro;
		}
		public void setclave_del_Tipo_de_Registro(int clave_del_Tipo_de_Registro) {
			clave_del_Tipo_de_Registro = clave_del_Tipo_de_Registro;
		}
		public long getNúmero_Pedimento() {
			return Número_Pedimento;
		}
		public void setNúmero_Pedimento(long número_Pedimento) {
			Número_Pedimento = número_Pedimento;
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
			return "Identificadores [id=" + id + ", clave_del_Tipo_de_Registro=" + clave_del_Tipo_de_Registro + ", Número_Pedimento="
					+ Número_Pedimento + ", Clave_Identificador=" + Clave_Identificador + ", Complemento1="
					+ Complemento1 + ", Complemento2=" + Complemento2 + ", Complemento3=" + Complemento3 + "]";
		}
		
		

}
