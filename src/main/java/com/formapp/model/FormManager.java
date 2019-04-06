package com.formapp.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="formManager")
public class FormManager {


	@Id
	private int id;
	
	private String name;
	private String formid;
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "formdata_manager",  joinColumns = { 
			@JoinColumn(name = "id", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "formid", 
					nullable = false, updatable = false) })
	private List<FormData> arrForms;

	private String code ;
	private String motion;
	private String formname;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getFormid() {
		return formid;
	}
	public void setFormid(String formid) {
		this.formid = formid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMotion() {
		return motion;
	}
	public void setMotion(String motion) {
		this.motion = motion;
	}
	public String getFormname() {
		return formname;
	}
	public void setFormname(String formname) {
		this.formname = formname;
	}
	public List<FormData> getArrForms() {
		return arrForms;
	}
	public void setArrForms(List<FormData> arrForms) {
		this.arrForms = arrForms;
	}

	
}
