package com.formapp.userservice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import org.json.JSONObject;
import org.omg.CORBA.TCKind;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.formapp.TableToClassMapping;
import com.formapp.model.DependentForm;
import com.formapp.model.FormData;
import com.formapp.model.FormFields;
import com.formapp.model.FormManager;
import com.formapp.model.mysql.Pedimento;
import com.formapp.repository.Appendice1Repository;
import com.formapp.repository.DependentFormRepo;
import com.formapp.userdao.FormDaoImpl;
import com.formapp.userdao.Genericdao;
import com.formapp.utility.Constants;
import com.formapp.utility.Convertor;
import com.formapp.utility.DateUtility;

@Service
public class FormDataServiceImpl implements FormDataService {
	@Value("${upload.output.file.directory}")
	private String outputUploadDirectory;
	
	@Value("${upload.file.directory}")
	private String upload;
	
	@Value("${package.path}")
	private String pckgpath;
	@Autowired
	FormDaoImpl formdaoImpl;

	@Autowired
	Appendice1Repository appendice1;
	
	@Autowired
	Genericdao generic;
	
	@Autowired
	TableToClassMapping tableToClassMapping;
		
	@Autowired 
	DependentFormRepo dependentFormRepo;
	@Override
	public List<FormData> getAll() {
		return formdaoImpl.getAll();

	}

	public <S extends FormData> FormData save(FormData formData) {
		return formdaoImpl.save(formData);

	}

	@Override
	public ArrayList<FormData> findByCodeIn(ArrayList<String> arrCode) {
		return formdaoImpl.findByCodeIn(arrCode);
	}

	public String createHTML( FormManager formsa) {
		StringBuilder divCreator = new StringBuilder();
		
		divCreator.append("<ul class=\"nav nav-tabs\">");
		int counter = 0;
		boolean hideNshow = true;
		for (FormData form : formsa.getArrForms()) {
			boolean mandatoryValue = formsa.getId() == 8 ? true : form.isMandatory();

			if (form.isDisplayed()) {
				if (mandatoryValue) {
					counter++;
					System.out.println(" form name" + form.getName());

					String activeClass = counter == 1 ? "active" : "";
					divCreator.append("<li  class=\"" + activeClass + "\"> <a data-toggle=\"tab\"  href=\"#tab"
							+ form.getFormid() + "\">");

					divCreator.append(form.getName());
					divCreator.append("</a><li>");
				}

			}

		}
		divCreator.append("</ul>");
		divCreator.append("<div class=\"tab-content\">");
		divCreator.append("<br>");
		int activeCounter = 0;			
				for (FormData form : formsa.getArrForms()) {
					if(form.isDisplayed())
					{
						activeCounter++;
						String actclass =  activeCounter==1?" in active":"";
						
				divCreator.append("<div id=\"tab" + form.getFormid() + "\"  class=\"tab-pane fade "+actclass+"\">");
				
				//divCreator.append("<div><p ng-show=\"isLock"+form.getFormid()+"\" >Sus datos están bloqueados con éxito</p></div>");
				
			/*divCreator.append("<div id=\"collapse" + form.getFormid() + "\" class=\"panel-collapse collapse\">");
			divCreator.append("<div class=\"panel-body\">");
			divCreator.append("<div><p ng-show=\"isLock"+form.getFormid()+"\" >Sus datos están bloqueados con éxito</p></div>");
			*/

				if (!(Integer.parseInt(form.getFormid()) == 1)) {
					boolean s_h_button = Integer.parseInt(form.getFormid()) == 28 ? true : false;
					divCreator.append("<div ");
					if (Integer.parseInt(form.getFormid()) == 28) {
						divCreator.append("ng-show= \"tabDiv\"");

					}
					divCreator.append(">");
					divCreator.append("<button  class=\"btn btn-theme\"  ng-show=\"" + s_h_button
							+ "\" ng-click=\"showDiv()\">Agregar Pedimento</button>");
					divCreator.append("<div class=\"table-responsive\">");
					divCreator.append("<table id=\"tableId\" class=\"table table-striped table-advance table-hover\">");
					divCreator.append("<thead> <tr>");

					List<FormFields> fsList = null;
					for (FormFields fields : form.getFields()) {
						if (fields.isShow()) {
							divCreator.append(" <th>" + fields.getName().toUpperCase().replace("_", " ") + "</th>");

						}

					}
					divCreator.append(" <th>Accciones</th>");
					divCreator.append("</tr></thead><tbody>");

					List<Object[]> ls = new ArrayList<Object[]>();
					ls = generic.getAll(form);

					for (Object[] object : ls) {
						divCreator.append("<tr>");
						for (int i = 1; i < object.length; i++) {

							divCreator.append(" <td>" + object[i].toString() + "</td>");

						}
						divCreator.append(" <td><button class=\"btn btn-primary btn-xs\" ng-click=\"editTableData("
								+ form.getFormid() + "," + form.getCode() + " ," + object[0]
								+ ")\"><i class=\"fa fa-pencil\"></i></button>"
								+ "<button class=\"btn btn-danger btn-xs\" ng-click=\"deleteTableData(" + form.getCode()
								+ " ," + object[0] + ")\"><i class=\"fa fa-trash-o \"></i></button></td>");
						divCreator.append("</tr>");
					}
					divCreator.append("</thead></table></div> ");
					divCreator.append("<hr>");
					divCreator.append("</div>");
				}	
					
				
			boolean formParentdiv =  Integer.parseInt(form.getFormid())== 28?false:true;
			divCreator.append("<div ");
			if(Integer.parseInt(form.getFormid())== 28)
			{
				divCreator.append("ng-show= \"formParentdiv\"");
				
			}
			divCreator.append(">");		
			divCreator.append("<form novalidate id=\"form");
			divCreator.append(form.getFormid());
			divCreator.append("\" name=\"form");
			divCreator.append(form.getFormid());
			divCreator.append("\">");

			divCreator.append("<h2>");
			divCreator.append("</h2><br>");
			// this div for hidden form field
			
			/*divCreator.append("<div class=\"form-group\">");
			divCreator.append("<div class=\"col-sm-6\">");
			divCreator.append("<input class=\"form-control\" ng-model=\"formdata\"");
			divCreator.append(form.getFormid());
			divCreator.append(".");
			divCreator.append("clave_formulario_principal");
			divCreator.append(" type=\"text\" id=\"clave_formulario_principal\" >");
			divCreator.append("</div></div>");*/
					//+ "1.clave_formulario_principal\"  type=\"hidden\" id=\"clave_formulario_principal\" >");
			boolean flag=true;
			for (FormFields field : form.getFields()) {

				divCreator.append("<div class=\"form-group\">");
				
				divCreator.append(
						"<label class=\"col-sm-2 control-label\" for=\"keyofrecord\">");

				divCreator.append(field.getName().replaceAll("_", " ").toUpperCase());
				divCreator.append("</label>");
				System.out.println("********"+field.getName());
				if (field.getType().equalsIgnoreCase("select")) {
					divCreator.append("<div class=\"col-sm-6\">");

					divCreator.append("<select id=\"second-choice\" ng-model=\"formdata");
					divCreator.append(form.getFormid());
					divCreator.append(".");
					divCreator.append(field.getName().replaceAll(" ", ""));
					divCreator.append("\" required=\"required\" class=\"form-control\" >");

					ArrayList<JSONObject> arrData = (ArrayList<JSONObject>) Convertor.getJSONFromExcel(
							upload+"/"+ field.getAppendiceData().getAppendiceName() + ".xls");
					
							//"/home/ubuntu/formApp/apendiceData/" + field.getAppendiceData().getAppendiceName() + ".xls");


					for (JSONObject obj : arrData) {
						divCreator.append("<option value=\"");
						divCreator.append(obj.get(field.getAppendiceData().getValueCol()));
						divCreator.append("\">");
						divCreator.append(obj.get(field.getAppendiceData().getTextCol()));

						divCreator.append("</option>");

					}
					divCreator.append("</select></div>");
					divCreator.append("<div class=\"col-sm-offset-8 col-sm-4\">");
					divCreator.append("</div></div></br>");


				}

				else if (field.getType().equalsIgnoreCase("number")) {
					divCreator.append("<div class=\"col-sm-6\">");

					divCreator.append("<input class=\"form-control\"   ng-model=\"formdata");
					divCreator.append(form.getFormid());
					divCreator.append(".");
					divCreator.append(field.getName().replaceAll(" ", ""));
					divCreator.append("\" ng-disabled=");
					divCreator.append(field.getIsDisabled());
					if (field.getDefaultValue() != null && !field.getDefaultValue().isEmpty()) {
						divCreator.append(" ng-init=\"formdata");
						divCreator.append(form.getFormid());
						divCreator.append(".");
						divCreator.append(field.getName().replaceAll(" ", ""));
						divCreator.append("=");
						divCreator.append(field.getDefaultValue());
						divCreator.append("\"");
					}
					divCreator.append(" name=\"");
					divCreator.append(field.getName().replaceAll(" ", ""));
					divCreator.append("\"");

					divCreator.append(" type=\"");
					divCreator.append(field.getType());
					divCreator.append("\" id=\"");
					divCreator.append(field.getName());
					divCreator.append("\" name=\"");
					divCreator.append(field.getName());
					divCreator.append("\"  value=\"");
					divCreator.append(field.getDefaultValue());
					divCreator.append("\"  required");
					
					if (field.getLength()!=null && field.getLength().contains(".")) {
						String[] precision = field.getLength().split("\\.");
						int maxLength= Integer.parseInt(precision[0])+Integer.parseInt(precision[1])+1;
						divCreator.append(" ng-pattern=\"/^\\d{0,"+precision[0]+"}(\\.\\d{1,"+precision[1]+"})?$/\"");
						//divCreator.append(" ng-pattern=\"/^([0-9]{1,"+precision[0]+"})+(\\.[0-9]{1,"+precision[1]+"})?$/\"");
						divCreator.append(" limit-to=\"");	
						divCreator.append(maxLength);
						divCreator.append("\" ");
						divCreator.append( "maxlength=\"");
						divCreator.append(maxLength);
						divCreator.append("\" ");
						divCreator.append( "placeholder=\"El campo contiene hasta "+precision[0]+" enteros y hasta  "+precision[1]+" fracciones.");
						divCreator.append("\" ");

					}
					else if(field.getName().equalsIgnoreCase("número_de_Pedimento") || field.getName().equalsIgnoreCase("número_pedimento"))
					{
					int lastDigit = Calendar.getInstance().get(Calendar.YEAR) % 10;
					divCreator.append(" ng-pattern=\"/^["+lastDigit+"]{1}[0-9]{6}?$/\"");
					divCreator.append(" limit-to=\"");	
					divCreator.append(field.getLength());
					divCreator.append("\" ");
					divCreator.append( "maxlength=\"");
					divCreator.append(field.getLength());
					divCreator.append("\" ");
					divCreator.append( "data-tooltip-append-to-body=\"true");
					divCreator.append("\" ");

					divCreator.append("data-tooltip=\"El primer dígito debe corresponder al último dígito del año en curso, mientras que los seis dígitos restantes son un número único de control asignado por el agente aduanal,apoderado aduanal o mandatario conservando los CEROS a la izquierda para que en conjunto sean siempre 7 dígitos. ");
					divCreator.append("\" ");
					
					
					
					}
					
					else {

						divCreator.append(" ng-pattern=\"/^[1-9][0-9]*$/\"");
						divCreator.append(" limit-to=\"");	
						divCreator.append(field.getLength());
						divCreator.append("\" ");
						divCreator.append( "maxlength=\"");
						divCreator.append(field.getLength());
						divCreator.append("\" ");

					}

					divCreator.append("></input></div> ");
					divCreator.append("<div class=\"col-sm-offset-8 col-sm-4\">");

					if (field.getIsRequired() != null && field.getIsRequired().equalsIgnoreCase("true")) {
						divCreator.append("<div class=\"col-sm-6\" style=\"color:red\" ng-show=\"");
						divCreator.append("form" + form.getFormid() + "." + field.getName().replaceAll(" ", ""));
						divCreator.append(".$error.required");
						divCreator.append("\">This Field is Required*</div></br>");
					}
					if (field.getCanBeNull() != null && (field.getCanBeNull().equals("false")
							|| field.getLength().contains("."))) {
						divCreator.append("<div class=\"col-sm-6\" style=\"color:red\" ng-show=\"");
						divCreator.append("form" + form.getFormid() + "." + field.getName().replaceAll(" ", ""));
						divCreator.append(".$error.pattern");
						divCreator.append("\">This Field cannot be null or zero</div>");
					}
					
					
					divCreator.append("</div></div></br>");
				} else {
					divCreator.append("<div class=\"col-sm-6\">");

					divCreator.append("<input class=\"form-control\"  required   ng-model=\"formdata");
					divCreator.append(form.getFormid());
					divCreator.append(".");
					divCreator.append(field.getName().replaceAll(" ", ""));
					divCreator.append("\" ng-disabled=");
					divCreator.append(field.getIsDisabled());
					divCreator.append(" type=\"");
					divCreator.append(field.getType());
					divCreator.append("\" id=\"");
					divCreator.append(field.getName());
					divCreator.append("\" limit-to=\"");
					divCreator.append(field.getLength());
					divCreator.append("\" name=\"");
					divCreator.append(field.getName());
					divCreator.append("\"  maxlength=\"");
					divCreator.append(field.getLength());
					divCreator.append("\"  value=\"");
					divCreator.append(field.getDefaultValue());
					divCreator.append("\" ");
					if(field.getSpecialCharsAllowed()!=null&&field.getSpecialCharsAllowed().equalsIgnoreCase("false")) {
					divCreator.append(" ng-pattern=\""+Constants.SPECIALCHARS_PATTERN+"\"");
					}
					else if(field.getAllowSpacesAndHyphen()!=null&&field.getAllowSpacesAndHyphen().equals("false")) {
						divCreator.append(" ng-pattern=\""+Constants.NOSPACE_HYPHEN_PATTERN+"\"");
	
					}
					
					divCreator.append("></input></div>");
					if (flag) {
						flag =false;
						divCreator.append(
						"<div class=\"form-group\"><div class=\"col-sm-6\">"
						+ "<input name=\"clave_formulario_principal\" type=\"hidden\" id=\"clave_formulario_principal\" ");
						divCreator.append("ng-model=\"formdata");
						divCreator.append(form.getFormid());
						divCreator.append(".");
						divCreator.append("clave_formulario_principal\"");
						divCreator.append("></div></div>");
						/*
						* +
						* "ng-disabled=\"true\" name=\"clave_formulario_principal\" type=\"hidden\" id=\"clave_formulario_principal\" "
						* +"></div></div> ");
						*/

						}
					divCreator.append("<div class=\"col-sm-offset-8 col-sm-4\">");

					if (field.getIsRequired() != null && field.getIsRequired().equalsIgnoreCase("true")) {
						divCreator.append("<div style=\"color:red\" ng-show=\"");
						divCreator.append("form" + form.getFormid() + "." + field.getName().replaceAll(" ", ""));
						divCreator.append(".$error.required");
						divCreator.append("\">This Field is Required*</div></br>");
					}
					if (field.getCanBeNull() != null && field.getCanBeNull().equals("false")) {
						divCreator.append("<div style=\"color:red\" ng-show=\"");
						divCreator.append("form" + form.getFormid() + "." + field.getName().replaceAll(" ", ""));
						divCreator.append(".$error.pattern");
						divCreator.append("\">This Field cannot be null or zero*</div>");

					}
				
					divCreator.append("</div></div></br>");

				}

			
			}
			

            divCreator.append("<div class=\"form-group\">");
            divCreator.append("<div class=\"col-lg-offset-2 col-lg-10\">");
			divCreator.append("<button ng-disabled=\"isDisabled"+form.getFormid()+" || form"+form.getFormid()+".$invalid\" class=\"btn btn-theme\"" );
			//divCreator.append(form.getFormid());
			
			divCreator.append("ng-click=isDisabled");
			divCreator.append(form.getFormid());
			divCreator.append("=true;isLock"+form.getFormid()+"=true;$event.preventDefault();save(formdata");
			divCreator.append(form.getFormid());
			divCreator.append(","+form.getFormid()+","+formsa.getId()+") >Guardar</button>");
			
		/*	divCreator.append(form.getFormid());
			divCreator.append(",event) >Guardar</button>");*/
			
			if(Integer.parseInt(form.getFormid())==1) {
				divCreator.append("<button class=\"btn btn-theme buttonclass\" > <a data-toggle=\"tab\"  href=\"#tab1\">");
				divCreator.append("Return back");
				divCreator.append("</a></button>");	
			}
			
			if(Integer.parseInt(form.getFormid())==28) {
				divCreator.append("<button class=\"btn btn-theme buttonclass\" > <a data-toggle=\"tab\"  href=\"#tab28\">");
				divCreator.append("Return back");
				divCreator.append("</a></button>");	
			}
			
			List<DependentForm> formidList1 = dependentFormRepo.findByFormidAndFormmanagerid("1",formsa.getId());
			List<DependentForm> formidList2 = dependentFormRepo.findByFormidAndFormmanagerid("28",formsa.getId());
			
				for (DependentForm dependentForm : formidList1) {
					if(dependentForm.getDependentFormId().equals(form.getFormid()))
					{
						divCreator.append("<button class=\"btn btn-theme buttonclass\" > <a data-toggle=\"tab\"  href=\"#tab1\">");
						
						divCreator.append("Return back");
						divCreator.append("</a></button>");	
					}
				}
				for (DependentForm dependentForm : formidList2) {
					if(dependentForm.getDependentFormId().equals(form.getFormid()))
					{
						divCreator.append("<button class=\"btn btn-theme buttonclass\" > <a data-toggle=\"tab\"  href=\"#tab28\">");
						
						divCreator.append("Return back");
						divCreator.append("</a></button>");	
					}
				}
			/*	if(Integer.parseInt(form.getFormid())==5) {
					divCreator.append("<button class=\"btn btn-theme buttonclass\" > <a data-toggle=\"tab\"  href=\"#tab5\">");
					
					divCreator.append("Return back");
					divCreator.append("</a></button>");	
				}
				*/
			
			
			
				
	            

			String motion = "";
					motion = form.getMotion();

		

			if (!motion.isEmpty() && motion.equalsIgnoreCase("n")) {
			   	
				divCreator.append("<button class=\"btn btn-theme\" ng-disabled=\"!isDisabled");
				divCreator.append(form.getFormid());
				divCreator.append("\"  ng-click=isDisabled");
				divCreator.append(form.getFormid());
				divCreator.append("=false;isLock"+form.getFormid()+"=false;$event.preventDefault();formdata");
				divCreator.append(form.getFormid());
				divCreator.append("={");
				divCreator.append("\"" + form.getFields().get(0).getName().replace(" ", ""));
				divCreator.append("\":" + form.getFields().get(0).getDefaultValue());


				divCreator.append("}>ADD Form</button>");
				  
				
			}
			 divCreator.append("</div>");
	         divCreator.append("</div>");

	            
	            
			divCreator.append("</form>");
			
			//boolean show	= form.getFormid().equals("1")?true:false;
			
			if(Integer.parseInt(form.getFormid())==1) {
				
				divCreator.append("<br>");	
			  divCreator.append("<div class=\"col-sm-12\" >" );
				System.out.println(form.getFormid() +" formsa.getId()  "+formsa.getId());
				List<DependentForm> formidList = dependentFormRepo.findByFormidAndFormmanagerid(form.getFormid(),formsa.getId());
				System.out.println("formidList  "+formidList);
				for (DependentForm dependentForm : formidList) {
					String className = tableToClassMapping.getClass(dependentForm.getCode());
					divCreator.append("<button class=\"btn btn-theme buttonclass\" > <a data-toggle=\"tab\"  href=\"#tab"
							+ dependentForm.getDependentFormId() + "\">");
					
					divCreator.append(className.split("\\.")[4]);
					divCreator.append("</a></button>");	
			}
				divCreator.append("</div>");
		}
			if(Integer.parseInt(form.getFormid())==28) {
				
				divCreator.append("</br>");	
				  divCreator.append("<div class=\"col-sm-12\" >" );
					System.out.println(form.getFormid() +" formsa.getId()  "+formsa.getId());
					List<DependentForm> formidList = dependentFormRepo.findByFormidAndFormmanagerid(form.getFormid(),formsa.getId());
					System.out.println("formidList  "+formidList);
					for (DependentForm dependentForm : formidList) {
						String className = tableToClassMapping.getClass(dependentForm.getCode());
						divCreator.append("<button class=\"btn btn-theme buttonclass\" > <a data-toggle=\"tab\"  href=\"#tab"
								+ dependentForm.getDependentFormId() + "\">");
						
						divCreator.append(className.split("\\.")[4]);
						divCreator.append("</a></button>");	
				}
					divCreator.append("</div>");
			}
			divCreator.append("</div>"); // form tab div end
			if(Integer.parseInt(form.getFormid())==5)
			{
				
				for (FormData CNPForm : formsa.getArrForms()) {
						if(Integer.parseInt(CNPForm.getFormid())==6)
						{
							divCreator.append(getContribucionesNivelPartida(CNPForm ,formsa));
						}
				}
					
				
					
			}
				
			divCreator.append("</div>"); // tab div end

				
			//divCreator.append("</br>");
			/*
			if(Integer.parseInt(form.getFormid())==2)
			{*/
		
			
		
			}
					
					
			}
			/*	
				divCreator.append("<div class=\"col-sm-12\"  >");
				
				for (FormData formData : formsa.getArrForms()) {
					
					if(!formData.isMandatory()) {
						System.out.println("check button for loop");
						divCreator.append("<button class=\"btn btn-theme buttonclass\" ng-show=\"true\"> <a data-toggle=\"tab\"  href=\"#tab"
								+ formData.getFormid() + "\">");
						
						divCreator.append(formData.getName());
						divCreator.append("</a></button>");	
						
						
					}
				}
				divCreator.append("</div>");*/
				
		divCreator.append("</div>"); // tab content div 
		divCreator.append("</br></br>");
		
		
		
		//divCreator.append("<button  class=\"btn btn-theme\" ng-click=\"save()\">Save</button>");
		return divCreator.toString();
		
	}

	@Override
	public FormData findByCode(String arrCode) {
		return formdaoImpl.findByCode(arrCode);
	}
	
	public String saveOutput(StringBuilder finalString, String petent) throws IOException {
		OutputStream os = null;
		Date d = new Date();

		String julianDay = DateUtility.dateToJulian(d);
		String count = DateUtility.getCounter(d);
		String fileName = "m" + petent + "" + count + "." + julianDay;
		os = new FileOutputStream(new File(outputUploadDirectory + "/" + fileName), true);
		System.out.println("Read Final String "+finalString);
		os.write(finalString.toString().getBytes(), 0, finalString.length());
		os.write('\n');
		os.close();
return fileName;
	}
	
public Object saveData(JSONObject arObj,String classname) {
	Object obj= null;
	System.out.println("arObj"+arObj);
		try {
			
			Class cls = Class.forName(pckgpath+classname);
			cls.getSimpleName();
			ObjectMapper mapper = new ObjectMapper();

			obj =  cls.newInstance();
			obj = mapper.readValue(arObj.toString(), cls);
			obj = generic.create(obj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}

public void deleteData(JSONObject arObj,String classname) {
	Object obj= null;
	System.out.println("arObj"+arObj);
		try {
			
			Class cls = Class.forName(pckgpath+classname);
			cls.getSimpleName();
			ObjectMapper mapper = new ObjectMapper();

			obj =  cls.newInstance();
			obj = mapper.readValue(arObj.toString(), cls);
			generic.delete(obj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
public String getContribucionesNivelPartida( FormData form  ,FormManager formsa) {

	StringBuilder divCreator= new StringBuilder();
	
		divCreator.append("<div ");
		divCreator.append(">");
		divCreator.append("<div class=\"table-responsive\">");
		divCreator.append("<table id=\"tableId\" class=\"table table-striped table-advance table-hover\">");
		divCreator.append("<thead> <tr>");
		List<FormFields> fsList = null;
		for (FormFields fields : form.getFields()) {
			if (fields.isShow()) {
				divCreator.append(" <th>" + fields.getName().toUpperCase().replace("_", " ") + "</th>");

			}

		}
		divCreator.append(" <th>Accciones</th>");
		divCreator.append("</tr></thead><tbody>");

		List<Object[]> ls = new ArrayList<Object[]>();
		ls = generic.getAll(form);

		for (Object[] object : ls) {
			divCreator.append("<tr>");
			for (int i = 1; i < object.length; i++) {

				divCreator.append(" <td>" + object[i].toString() + "</td>");

			}
			divCreator.append(" <td><button class=\"btn btn-primary btn-xs\" ng-click=\"editTableData("
					+ form.getFormid() + "," + form.getCode() + " ," + object[0]
					+ ")\"><i class=\"fa fa-pencil\"></i></button>"
					+ "<button class=\"btn btn-danger btn-xs\" ng-click=\"deleteTableData(" + form.getCode()
					+ " ," + object[0] + ")\"><i class=\"fa fa-trash-o \"></i></button></td>");
			divCreator.append("</tr>");
		}
		divCreator.append("</thead></table></div> ");
		divCreator.append("<hr>");
		divCreator.append("</div>");
		
		
	
divCreator.append("<div ");
divCreator.append(">");		
divCreator.append("<form novalidate id=\"form");
divCreator.append(form.getFormid());
divCreator.append("\" name=\"form");
divCreator.append(form.getFormid());
divCreator.append("\">");

divCreator.append("<h2>");
divCreator.append("</h2><br>");

for (FormFields field : form.getFields()) {

	divCreator.append("<div class=\"form-group\">");

	divCreator.append(
			"<label class=\"col-sm-2 control-label\" for=\"keyofrecord\">");

	divCreator.append(field.getName().replaceAll("_", " ").toUpperCase());
	divCreator.append("</label>");
	System.out.println("********"+field.getName());
	if (field.getType().equalsIgnoreCase("select")) {
		divCreator.append("<div class=\"col-sm-6\">");

		divCreator.append("<select id=\"second-choice\" ng-model=\"formdata");
		divCreator.append(form.getFormid());
		divCreator.append(".");
		divCreator.append(field.getName().replaceAll(" ", ""));
		divCreator.append("\" required=\"required\" class=\"form-control\" >");

		ArrayList<JSONObject> arrData = (ArrayList<JSONObject>) Convertor.getJSONFromExcel(
				upload+"/"+ field.getAppendiceData().getAppendiceName() + ".xls");
		
				//"/home/ubuntu/formApp/apendiceData/" + field.getAppendiceData().getAppendiceName() + ".xls");


		for (JSONObject obj : arrData) {
			divCreator.append("<option value=\"");
			divCreator.append(obj.get(field.getAppendiceData().getValueCol()));
			divCreator.append("\">");
			divCreator.append(obj.get(field.getAppendiceData().getTextCol()));

			divCreator.append("</option>");

		}
		divCreator.append("</select></div>");
		divCreator.append("<div class=\"col-sm-offset-8 col-sm-4\">");
		divCreator.append("</div></div></br>");


	}

	else if (field.getType().equalsIgnoreCase("number")) {
		divCreator.append("<div class=\"col-sm-6\">");

		divCreator.append("<input class=\"form-control\"   ng-model=\"formdata");
		divCreator.append(form.getFormid());
		divCreator.append(".");
		divCreator.append(field.getName().replaceAll(" ", ""));
		divCreator.append("\" ng-disabled=");
		divCreator.append(field.getIsDisabled());
		if (field.getDefaultValue() != null && !field.getDefaultValue().isEmpty()) {
			divCreator.append(" ng-init=\"formdata");
			divCreator.append(form.getFormid());
			divCreator.append(".");
			divCreator.append(field.getName().replaceAll(" ", ""));
			divCreator.append("=");
			divCreator.append(field.getDefaultValue());
			divCreator.append("\"");
		}
		divCreator.append(" name=\"");
		divCreator.append(field.getName().replaceAll(" ", ""));
		divCreator.append("\"");

		divCreator.append(" type=\"");
		divCreator.append(field.getType());
		divCreator.append("\" id=\"");
		divCreator.append(field.getName());
		divCreator.append("\" name=\"");
		divCreator.append(field.getName());
		divCreator.append("\"  value=\"");
		divCreator.append(field.getDefaultValue());
		divCreator.append("\"  required");
		
		if (field.getLength()!=null && field.getLength().contains(".")) {
			String[] precision = field.getLength().split("\\.");
			int maxLength= Integer.parseInt(precision[0])+Integer.parseInt(precision[1])+1;
			divCreator.append(" ng-pattern=\"/^\\d{0,"+precision[0]+"}(\\.\\d{1,"+precision[1]+"})?$/\"");
			//divCreator.append(" ng-pattern=\"/^([0-9]{1,"+precision[0]+"})+(\\.[0-9]{1,"+precision[1]+"})?$/\"");
			divCreator.append(" limit-to=\"");	
			divCreator.append(maxLength);
			divCreator.append("\" ");
			divCreator.append( "maxlength=\"");
			divCreator.append(maxLength);
			divCreator.append("\" ");
			divCreator.append( "placeholder=\"El campo contiene hasta "+precision[0]+" enteros y hasta  "+precision[1]+" fracciones.");
			divCreator.append("\" ");

		}
		else if(field.getName().equalsIgnoreCase("número_de_Pedimento") || field.getName().equalsIgnoreCase("número_pedimento"))
		{
		int lastDigit = Calendar.getInstance().get(Calendar.YEAR) % 10;
		divCreator.append(" ng-pattern=\"/^["+lastDigit+"]{1}[0-9]{6}?$/\"");
		divCreator.append(" limit-to=\"");	
		divCreator.append(field.getLength());
		divCreator.append("\" ");
		divCreator.append( "maxlength=\"");
		divCreator.append(field.getLength());
		divCreator.append("\" ");
		divCreator.append( "data-tooltip-append-to-body=\"true");
		divCreator.append("\" ");

		divCreator.append("data-tooltip=\"El primer dígito debe corresponder al último dígito del año en curso, mientras que los seis dígitos restantes son un número único de control asignado por el agente aduanal,apoderado aduanal o mandatario conservando los CEROS a la izquierda para que en conjunto sean siempre 7 dígitos. ");
		divCreator.append("\" ");
		
		
		
		}
		
		else {

			divCreator.append(" ng-pattern=\"/^[1-9][0-9]*$/\"");
			divCreator.append(" limit-to=\"");	
			divCreator.append(field.getLength());
			divCreator.append("\" ");
			divCreator.append( "maxlength=\"");
			divCreator.append(field.getLength());
			divCreator.append("\" ");

		}

		divCreator.append("></input></div> ");
		divCreator.append("<div class=\"col-sm-offset-8 col-sm-4\">");

		if (field.getIsRequired() != null && field.getIsRequired().equalsIgnoreCase("true")) {
			divCreator.append("<div class=\"col-sm-6\" style=\"color:red\" ng-show=\"");
			divCreator.append("form" + form.getFormid() + "." + field.getName().replaceAll(" ", ""));
			divCreator.append(".$error.required");
			divCreator.append("\">This Field is Required*</div></br>");
		}
		if (field.getCanBeNull() != null && (field.getCanBeNull().equals("false")
				|| field.getLength().contains("."))) {
			divCreator.append("<div class=\"col-sm-6\" style=\"color:red\" ng-show=\"");
			divCreator.append("form" + form.getFormid() + "." + field.getName().replaceAll(" ", ""));
			divCreator.append(".$error.pattern");
			divCreator.append("\">This Field cannot be null or zero</div>");
		}
		
		
		divCreator.append("</div></div></br>");
	} else {
		divCreator.append("<div class=\"col-sm-6\">");

		divCreator.append("<input class=\"form-control\"  required   ng-model=\"formdata");
		divCreator.append(form.getFormid());
		divCreator.append(".");
		divCreator.append(field.getName().replaceAll(" ", ""));
		divCreator.append("\" ng-disabled=");
		divCreator.append(field.getIsDisabled());
		divCreator.append(" type=\"");
		divCreator.append(field.getType());
		divCreator.append("\" id=\"");
		divCreator.append(field.getName());
		divCreator.append("\" limit-to=\"");
		divCreator.append(field.getLength());
		divCreator.append("\" name=\"");
		divCreator.append(field.getName());
		divCreator.append("\"  maxlength=\"");
		divCreator.append(field.getLength());
		divCreator.append("\"  value=\"");
		divCreator.append(field.getDefaultValue());
		divCreator.append("\" ");
		if(field.getSpecialCharsAllowed()!=null&&field.getSpecialCharsAllowed().equalsIgnoreCase("false")) {
		divCreator.append(" ng-pattern=\""+Constants.SPECIALCHARS_PATTERN+"\"");
		}
		else if(field.getAllowSpacesAndHyphen()!=null&&field.getAllowSpacesAndHyphen().equals("false")) {
			divCreator.append(" ng-pattern=\""+Constants.NOSPACE_HYPHEN_PATTERN+"\"");

		}
		
		divCreator.append("></input></div>");
		divCreator.append("<div class=\"col-sm-offset-8 col-sm-4\">");

		if (field.getIsRequired() != null && field.getIsRequired().equalsIgnoreCase("true")) {
			divCreator.append("<div style=\"color:red\" ng-show=\"");
			divCreator.append("form" + form.getFormid() + "." + field.getName().replaceAll(" ", ""));
			divCreator.append(".$error.required");
			divCreator.append("\">This Field is Required*</div></br>");
		}
		if (field.getCanBeNull() != null && field.getCanBeNull().equals("false")) {
			divCreator.append("<div style=\"color:red\" ng-show=\"");
			divCreator.append("form" + form.getFormid() + "." + field.getName().replaceAll(" ", ""));
			divCreator.append(".$error.pattern");
			divCreator.append("\">This Field cannot be null or zero*</div>");

		}
	
		divCreator.append("</div></div></br>");

	}


}


divCreator.append("<div class=\"form-group\">");
divCreator.append("<div class=\"col-lg-offset-2 col-lg-10\">");
divCreator.append("<button ng-disabled=\"isDisabled"+form.getFormid()+" || form"+form.getFormid()+".$invalid\" class=\"btn btn-theme\"" );
//divCreator.append(form.getFormid());

divCreator.append("ng-click=isDisabled");
divCreator.append(form.getFormid());
divCreator.append("=true;isLock"+form.getFormid()+"=true;$event.preventDefault();save(formdata");
divCreator.append(form.getFormid());
divCreator.append(","+form.getFormid()+","+formsa.getId()+") >Guardar</button>");






divCreator.append("</br>");	

	
    

String motion = "";
		motion = form.getMotion();



if (!motion.isEmpty() && motion.equalsIgnoreCase("n")) {
   	
	divCreator.append("<button class=\"btn btn-theme\" ng-disabled=\"!isDisabled");
	divCreator.append(form.getFormid());
	divCreator.append("\"  ng-click=isDisabled");
	divCreator.append(form.getFormid());
	divCreator.append("=false;isLock"+form.getFormid()+"=false;$event.preventDefault();formdata");
	divCreator.append(form.getFormid());
	divCreator.append("={");
	divCreator.append("\"" + form.getFields().get(0).getName().replace(" ", ""));
	divCreator.append("\":" + form.getFields().get(0).getDefaultValue());


	divCreator.append("}>ADD Form</button>");
	  
	
}
 divCreator.append("</div>");
 divCreator.append("</div>");

    
    
divCreator.append("</form>");
divCreator.append("</div>");
return divCreator .toString();
}



@Override
public String createHTMLForTable(FormManager arrForms) {
	StringBuilder tablediv = new StringBuilder();
	
	FormData formData = null;
	
	/*if(arrForms.getFormname().equals("0")) 
	{
		System.out.println("0 form");
		formData=arrForms.getArrForms().get(0);
	}
	else {
		System.out.println("1 form");
		formData=arrForms.getArrForms().get(1);
	}*/
	
	formData=arrForms.getArrForms().get(1);
	tablediv.append("<button  class=\"btn btn-theme\" ng-click=\"formParentdiv=false;tabDiv=true;showMessage("+arrForms.getFormid()+")\"");
	if((Integer.parseInt(arrForms.getFormid())==1) || (Integer.parseInt(arrForms.getFormid())==9) ) 
	{
		tablediv.append(" ng-show=\"false\"");
	}
	tablediv.append(" >Agregar Pedimento</button>");	
	
	tablediv.append("<div class=\"table-responsive\">");
	tablediv.append("<table class=\"table table-striped table-advance table-hover\">");
	tablediv.append("<thead> <tr>");
	
	/*List<String> columnList = new ArrayList<String>();
	columnList = generic.getAllColumName(form);
		tablediv.append(" <th>"+headerName.toUpperCase()+"</th>");
	}
	tablediv.append("</tr></thead><tbody>");
	*/
	/*System.out.println(arrForms.getCode() +" ************* "+ formData);*/
//	FormFields ff = formData.getFields().get(1);
	  Stream<FormFields> stream1 = formData.getFields().stream();
	  stream1.limit(4).forEach((a) ->{
//	for (FormFields fields: formData.getFields()) {
		System.out.println(a.getCode()+ " fields "+a.getName());
			tablediv.append(" <th>"+a.getName().toUpperCase().replace("_"," ")+"</th>");
		});
	tablediv.append(" <th>Accciones</th>");
	tablediv.append("</tr></thead><tbody>");

	
	List<Object[]> ls = new ArrayList<Object[]>();
		ls= generic.getgenerlasData(formData);
			
			 
			for (Object[] object : ls) {
				tablediv.append("<tr>");
				
				for (int i = 1; i < object.length; i++) {
					//System.out.println(i+" stringdata "+object[i].toString());
					tablediv.append(" <td>"+object[i].toString()+"</td>");
							 
                      
				}
				tablediv.append(" <td><button class=\"btn btn-primary btn-xs\" ng-click=\"editTableData("+formData.getFormid()+","+formData.getCode()+" ,"+object[0]+")\"><i class=\"fa fa-pencil\"></i></button>"
						+ "<button class=\"btn btn-danger btn-xs\" ng-click=\"deleteTableData("+formData.getCode()+" ,"+object[0]+")\"><i class=\"fa fa-trash-o \"></i></button></td>");
				tablediv.append("</tr>");
			}
			tablediv.append("</thead></table></div> ");
			tablediv.append("<div class=\"col-md-9\">");
			
			if((Integer.parseInt(arrForms.getFormid())==1)) 
			{	
				tablediv.append("<div>");
				tablediv.append("<button  class=\"btn btn-theme\"");
				tablediv.append(" >Generar</button>");	
				tablediv.append("</div>");
			}
			
			if((Integer.parseInt(arrForms.getFormid())==9)) 
			{
				tablediv.append("<div>");
				tablediv.append("<form novalidate id=\"tableform\"");
				tablediv.append("<div class=\"form-group\">");

				tablediv.append(
						"<label class=\"col-sm-2 control-label\" for=\"keyofrecord\">");

				tablediv.append("Tipo de movimiento ");
				tablediv.append("</label>");
				tablediv.append("<div class=\"col-sm-6\">");

				tablediv.append("<select id=\"second\" ng-model=\"tabledata\"");
				tablediv.append(" required=\"required\" class=\"form-control\" >");



				for (Object[] object : ls) {
					
					
						tablediv.append("<option value=\"");
						tablediv.append(object[2].toString());
						tablediv.append("\">");
						tablediv.append(object[2].toString());

						tablediv.append("</option>");
						
					
					

				}
				tablediv.append("</select></div>");
				
				tablediv.append("<button  class=\"btn btn-theme\"");
				tablediv.append(" >Generar</button>");	
				tablediv.append("</div>");
			}
			tablediv.append("</div>");
			
	
	return tablediv.toString();
	
}


}