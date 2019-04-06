package com.formapp.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "formfields")
public class FormFields {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String formid;
	private String code;
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	private FormData formData;
	private String isRequired;
	private String canBeNull;
	private String specialCharsAllowed;
	private String isDisabled;
	private String allowSpacesAndHyphen;
	private String defaultValue;
	private String name;
	private String type;
	private String appendZero;
	private String length;
	private String appendice;
	private boolean isShow;
	

	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	private Appendice appendiceData;

	public String getIsRequired() {
		return isRequired;
	}

	public void setIsRequired(String isRequired) {
		this.isRequired = isRequired;
	}

	public String getIsDisabled() {
		return isDisabled;
	}

	public void setIsDisabled(String isDisabled) {
		this.isDisabled = isDisabled;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAppendZero() {
		return appendZero;
	}

	public void setAppendZero(String appendZero) {
		this.appendZero = appendZero;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public Appendice getAppendiceData() {
		return appendiceData;
	}

	public void setAppendiceData(Appendice appendiceData) {
		this.appendiceData = appendiceData;
	}

	public String getAllowSpacesAndHyphen() {
		return allowSpacesAndHyphen;
	}

	public void setAllowSpacesAndHyphen(String allowSpacesAndHyphen) {
		this.allowSpacesAndHyphen = allowSpacesAndHyphen;
	}

	public String getCanBeNull() {
		return canBeNull;
	}

	public void setCanBeNull(String canBeNull) {
		this.canBeNull = canBeNull;
	}

	public String getSpecialCharsAllowed() {
		return specialCharsAllowed;
	}

	public void setSpecialCharsAllowed(String specialCharsAllowed) {
		this.specialCharsAllowed = specialCharsAllowed;
	}


	

	public FormData getFormData() {
		return formData;
	}

	public void setFormData(FormData formData) {
		this.formData = formData;
	}

	public long getId() {
		return id;
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
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public FormFields() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean isShow() {
		return isShow;
	}

	public void setShow(boolean isShow) {
		this.isShow = isShow;
	}
	public FormFields(String formid, String code, String isRequired, String canBeNull,
			String specialCharsAllowed, String isDisabled, String allowSpacesAndHyphen, String defaultValue,
			String name, String type, String appendZero, String length, String appendice) {
		super();
		this.formid = formid;
		this.code = code;
		this.isRequired = isRequired;
		this.canBeNull = canBeNull;
		this.specialCharsAllowed = specialCharsAllowed;
		this.isDisabled = isDisabled;
		this.allowSpacesAndHyphen = allowSpacesAndHyphen;
		this.defaultValue = defaultValue;
		this.name = name;
		this.type = type;
		this.appendZero = appendZero;
		this.length = length;
		this.appendice = appendice;
	}

	
}
