package com.formapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class DependentForm {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String formid;
	private String dependentFormId ;
	private String code ;
	@Column(name="form_manager_id")
	private long formmanagerid ;
	
	public long getId() {
		return id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFormid() {
		return formid;
	}
	public void setFormid(String formid) {
		this.formid = formid;
	}
	
	public String getDependentFormId() {
		return dependentFormId;
	}
	public void setDependentFormId(String dependentFormId) {
		this.dependentFormId = dependentFormId;
	}
	
	
	
	public long getFormmanagerid() {
		return formmanagerid;
	}
	public void setFormmanagerid(long formmanagerid) {
		this.formmanagerid = formmanagerid;
	}
	@Override
	public String toString() {
		return "DependentForm [id=" + id + ", formid=" + formid + ", dependentFormId=" + dependentFormId + ", code="
				+ code + ", formmanagerid=" + formmanagerid + "]";
	}
	 


}
