package com.formapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import javax.persistence.Id;

@Entity
@Table(name="appendicemanager")
public class AppendiceManager {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int aid;
	private String valueCol ;
	private String textCol;
	
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getValueCol() {
		return valueCol;
	}
	public void setValueCol(String valueCol) {
		this.valueCol = valueCol;
	}
	public String getTextCol() {
		return textCol;
	}
	public void setTextCol(String textCol) {
		this.textCol = textCol;
	}
	
	
	
	
	
	
	
}
