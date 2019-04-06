package com.formapp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Table(name="appendice")
//@Document(collection = "appendice")
public class Appendice {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String textCol;
	private String valueCol;
	private String appendiceName;
	private int columnsCount ;
	ArrayList<String> columnsName;
	@OneToMany(mappedBy = "appendiceData", cascade = CascadeType.REMOVE)
	@JsonManagedReference
	List<FormFields> fields;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTextCol() {
		return textCol;
	}
	public void setTextCol(String textCol) {
		this.textCol = textCol;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getValueCol() {
		return valueCol;
	}
	public void setValueCol(String valueCol) {
		this.valueCol = valueCol;
	}
	public String getAppendiceName() {
		return appendiceName;
	}
	public void setAppendiceName(String appendiceName) {
		this.appendiceName = appendiceName;
	}
	public int getColumnsCount() {
		return columnsCount;
	}
	public void setColumnsCount(int columnsCount) {
		this.columnsCount = columnsCount;
	}
	public ArrayList<String> getColumnsName() {
		return columnsName;
	}
	public void setColumnsName(ArrayList<String> columnsName) {
		this.columnsName = columnsName;
	}
	
	
}
