package com.formapp.userservice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.formapp.model.FormData;
import com.formapp.model.FormFields;
import com.formapp.model.FormManager;

public interface FormDataService {
	public List<FormData> getAll() ;
	public <S extends FormData> FormData save(FormData formData) ;
	public 	ArrayList<FormData> findByCodeIn(ArrayList<String> arrCode);
	public String createHTML(FormManager forms) ;
	public FormData findByCode(String arrCode);
	public String saveOutput(StringBuilder finalString, String petent) throws IOException ;
	public Object saveData(JSONObject arObj,String classname);
	public String createHTMLForTable(FormManager arrForms);
	public void deleteData(JSONObject arObj,String classname);
}
