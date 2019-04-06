package com.formapp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="formdata")
public class FormData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String formid;
	private String name;
	private String code;
	private String motion;
	private  boolean displayed;
	private  boolean mandatory;
	
	
	@OneToMany(mappedBy = "formData", cascade = CascadeType.REMOVE)
	  @OrderBy("id ASC")
	@JsonManagedReference
	List<FormFields> fields;
	
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "arrForms")
List<FormManager> formManagers;
	public String getFormid() {
		return formid;
	}
	
	public void setFormid(String formid) {
		this.formid = formid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<FormFields> getFields() {
		return fields;
	}

	public void setFields(ArrayList<FormFields> fields) {
		this.fields = fields;
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
	
	public boolean isDisplayed() {
		return displayed;
	}

	public void setDisplayed(boolean displayed) {
		this.displayed = displayed;
	}

	public boolean isMandatory() {
		return mandatory;
	}

	public void setMandatory(boolean mandatory) {
		this.mandatory = mandatory;
	}
	
	@Override
	public String toString() {
		return "FormData [id=" + id + ", formid=" + formid + ", name=" + name + ", code=" + code + ", motion=" + motion
				+ ", displayed=" + displayed + ", mandatory=" + mandatory + ", fields=" + fields + ", formManagers="
				+ formManagers + "]";
	}

}
