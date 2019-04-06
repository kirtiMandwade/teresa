package com.formapp.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Table;
import javax.websocket.server.PathParam;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.formapp.TableToClassMapping;
import com.formapp.model.Appendice;
import com.formapp.model.DependentForm;
import com.formapp.model.FormData;
import com.formapp.model.FormFields;
import com.formapp.model.FormManager;
import com.formapp.model.Response;
import com.formapp.model.mysql.AuditBase;
import com.formapp.model.mysql.Generales;
import com.formapp.model.mysql.Partidas;
import com.formapp.model.mysql.Pedimento;
import com.formapp.model.mysql.Tasas;
import com.formapp.model.mysql.TasasNivelPartida;
import com.formapp.model.mysql.Transporte;
import com.formapp.repository.Appendice1Repository;
import com.formapp.repository.AppendiceManagerRepo;
import com.formapp.repository.DependentFormRepo;
import com.formapp.repository.FormDataRepository;
import com.formapp.repository.FormFieldsRepository;
import com.formapp.repository.FormManagerRepo;
import com.formapp.repository.GeneralasRepository;
import com.formapp.repository.PartidasRepository;
import com.formapp.repository.PedimentoRepository;
import com.formapp.repository.TransporteRepository;
import com.formapp.userdao.Genericdao;
import com.formapp.userservice.FormDataService;
import com.google.gson.Gson;

@Controller
@RequestMapping("/user")
public class UserController {
	@Value("${package.path}")
	private String pckgpath;

	@Autowired
	FormDataService dataService;

	@Autowired
	PartidasRepository partidasRepo;
	
	@Autowired
	AppendiceManagerRepo appendiceManagerRepo;

	@Autowired
	Appendice1Repository appendice1;
	@Autowired
	PedimentoRepository   pedimentoRepository  ;
	
	@Autowired
	TransporteRepository transporteRepository;
	
	@Autowired
	FormManagerRepo formRepo;
	@Autowired
	
	FormDataRepository formDataRepo;
	@Autowired
	FormFieldsRepository fieldsRepository;
	
	@Autowired
	Genericdao genericdao;
	
	@Autowired
	TableToClassMapping tableToClassMapping;
	
	@Autowired
	DependentFormRepo dependentFormRepo;
	
	@Autowired
	GeneralasRepository generalasRepository;

	@GetMapping("/home")
	public String home() {

		return "/indexnew";
	}
	
	@GetMapping("/pedimento")
	public String pedimentoHome() {

		return "/pedimento";
	}
	

	@GetMapping("/addPedimento")
	public String addPedimento() {

		return "/addPedimento";
	}
	
	@GetMapping("/partidas")
	public String partidas() {

		return "/partidas";
	}
	
	@GetMapping("/addPartidas/{code}")
	public String addPartidas(@PathVariable("code") String code) {

		return "/addPartidas";
	}
	@GetMapping("/mfile")
	public String mfile() {

		return "/mfile";
	}

	@GetMapping("/getMenu")
	public @ResponseBody List<FormManager> getMenu() {
			List<FormManager> returnList = new ArrayList<FormManager>();
			List<FormManager> fm = formRepo.findAll();	
			for (FormManager formManager : fm) {
				int temp = 1;
				for (FormData formData : formManager.getArrForms()) {
					if(formData.isDisplayed())
					{
						System.out.println("in getMenu "+formManager.getName());	
						temp = 0;
						
					}
				}
				if(temp==0)
				{
						returnList.add(formManager)	;
				}
				
				
			}
			
		return formRepo.findAll();
	}

	@GetMapping("/getpedimentData")
	public @ResponseBody List<? extends AuditBase> getpedimentData() {
		
	
		String className = tableToClassMapping.getClass("500");
		List<? extends AuditBase> ls = null;
		try {
			ls = genericdao.getPedimentoData("500",Class.forName(className));
			
			System.out.println("Ls :"+ls);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return ls;
	}
		

	@GetMapping("/getPartidasData")
	public @ResponseBody List<Partidas> getPartidasData() {
		
	
		List<Partidas> arrPart = partidasRepo.findAll();
		
			
		return arrPart;
	}
		
	
	@GetMapping("/getGeneralsData")
	public @ResponseBody List<Generales> getGeneralsData() {
		
	
		List<Generales> arrGeneral = generalasRepository.findAll();
		
			
		return arrGeneral;
	}

	@DeleteMapping("/deleteData")
	public @ResponseBody String deleteData(@RequestBody String jsonString,@RequestParam("managerid") String managerid) {

		JSONObject jsonObject = getjsonObject(jsonString ,managerid);
		FormData data = dataService.findByCode(jsonObject.get("clave_del_Tipo_de_Registro").toString());

		 dataService.deleteData(jsonObject,data.getName());
		
			
		return "true";
	}
	@GetMapping("/getTransporteData")
	public @ResponseBody List<Transporte> getTransporteData() {
		
	
		List<Transporte> arrTransporte = transporteRepository.findAll();
		
			
		return arrTransporte;
	}
	@DeleteMapping("/delete/generals")
	public @ResponseBody String deletegenerals(@RequestBody Generales generals) {
		
	
		generalasRepository.delete(generals);
		
			
		return "true";
	}
	@GetMapping("/getForms/{id}")
	public @ResponseBody Response getForms(@PathVariable("id") String id) {
		FormManager arrForms = formRepo.findByFormid(id);
		System.out.println("**********************getForms");
		// ArrayList<String> arrCode = (ArrayList<String>)
		// arrForms.stream().map(FormManager::getCode)
		// .collect(Collectors.toList());
		System.out.println("DivData "+  arrForms);
		String div = dataService.createHTML(arrForms);
		Response response = new Response();
		response.setDivData(div);
		System.out.println("DivData "+  response.getDivData());
		return response;
		
	}

	@GetMapping("/getPedimentoTable/{id}")
	public @ResponseBody Response getPedimentoTable(@PathVariable("id") String id) {
		FormManager arrForms = formRepo.findByFormid(id);
		String div = dataService.createHTMLForTable(arrForms);
		Response response = new Response();
		response.setDivData(div);
		return response;
		
	}

	@GetMapping("/getAppendice/{id}")
	public @ResponseBody List<Appendice> getAppendice(@PathVariable("id") Long id) {
		return appendice1.findAll();
	}

/*	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody String save(@RequestBody String jsonString) {
		System.out.println("jsonString "+jsonString);
		
		StringBuilder finalString = new StringBuilder();
		JSONArray jsonObj = new JSONArray(jsonString);
		String patent = "";
	
		
		
		try {
			for (Object obj : jsonObj) {
				JSONObject arObj = (JSONObject) obj;
				FormData data = dataService.findByCode(arObj.get("clave_del_Tipo_de_Registro").toString());

				
				for (FormFields fieldsobj : data.getFields()) {

					if (arObj.has(fieldsobj.getName().replaceAll(" ", ""))) {
								
						if (fieldsobj.getName().replaceAll(" ", "").contains("patente_o_autorización") || fieldsobj.getName().replaceAll(" ", "").contains("patente_autorización")) {
							patent = (String) String.valueOf(arObj.get(fieldsobj.getName().replaceAll(" ", "")));
							int contentLength = 4-patent.length();
							String appendZero = getPatenteAuth(contentLength);
							patent= patent+appendZero;
							arObj.put(fieldsobj.getName(), patent);
						
							
						}
						finalString.append(arObj.get(fieldsobj.getName().replaceAll(" ", ""))).append("|");

					}
				}
				dataService.saveData(arObj, data.getName());
				System.out.println("final string "+finalString.toString());
				finalString.deleteCharAt(finalString.length() - 1);
				finalString.append(System.getProperty("line.separator"));
			}

			
			dataService.saveOutput(finalString, patent);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return "true";
	}
*/
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody Object save(@RequestBody String jsonString,@RequestParam("managerid") String managerid) {
		System.out.println("jsonString "+jsonString);
		
		StringBuilder finalString = new StringBuilder();
		JSONObject jsonObject = getjsonObject(jsonString ,managerid);
		//JSONObject jsonObject = new JSONObject(jsonString);
		System.out.println("jsonObject "+jsonObject);	
		Object obj =null;
		String patent = "";
		try {
		FormData data = dataService.findByCode(jsonObject.get("clave_del_Tipo_de_Registro").toString());
		
		
			/*for (Object obj : jsonObj) {*/
				//JSONObject arObj = (JSONObject) obj;
				//FormData data = dataService.findByCode(arObj.get("clave_del_Tipo_de_Registro").toString());
			
				
				for (FormFields fieldsobj : data.getFields()) {

					if (jsonObject.has(fieldsobj.getName().replaceAll(" ", ""))) {
								
						if (fieldsobj.getName().replaceAll(" ", "").contains("patente_o_autorización") || fieldsobj.getName().replaceAll(" ", "").contains("patente_autorización")) {
							patent = (String) String.valueOf(jsonObject.get(fieldsobj.getName().replaceAll(" ", "")));
							int contentLength = 4-patent.length();
							String appendZero = getPatenteAuth(contentLength);
							patent= patent+appendZero;
							jsonObject.put(fieldsobj.getName(), patent);
						
							
						}
						finalString.append(jsonObject.get(fieldsobj.getName().replaceAll(" ", ""))).append("|");

					}
				}
				if(jsonObject.get("clave_del_Tipo_de_Registro").toString().equals("501"))
				{
				String ndp = jsonObject.has("número_de_pedimento")==true ? "número_de_pedimento" : "número_Pedimento";
				long numero_de_pedimento=Long.parseLong(jsonObject.get(ndp).toString());

				List<AuditBase> pediment = genericdao.getPedimentoByUniqueId("500",numero_de_pedimento );
				System.out.println(pediment.size()+ " PEDIMENT DATA LIST "+pediment);
				if(pediment.isEmpty()) {
					
				System.out.println( " PEDIMENT DATA LIST If");

				Pedimento pedimento = new Pedimento();
				pedimento.setNúmero_de_Pedimento(numero_de_pedimento);
				pedimento.setPatente_o_autorización(Integer.parseInt(patent));
				pedimento.setClave_del_Tipo_de_Registro(500);
				pedimento.setTipo_de_Movimiento(0);	
				pedimento.setTipo_de_Pedimento(Integer.parseInt(managerid));
				pedimentoRepository.save(pedimento);
				}
				}
				obj = dataService.saveData(jsonObject, data.getName());
				System.out.println("final string "+finalString.toString());
				finalString.deleteCharAt(finalString.length() - 1);
				finalString.append(System.getProperty("line.separator"));
		/*	}*/

			
			//dataService.saveOutput(finalString, patent);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return obj;
	}
	
	
	private String getPatenteAuth(int contentLength) {
		if(contentLength==1)
		{
			return "0";
		}
		else if(contentLength==2)
		{
			return "00";
		}
		else if(contentLength==3)
		{
			return "000";
		}
		else {
			return "";
					
		}
	}

	/*public static void main(String[] args) {

		try {
			ClassLoader classLoader = UserController.class.getClassLoader();

			String fileName = "/Users/neosoft/Documents/model.txt";
			File file = new File(fileName);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line;
			int count = 2;
			ArrayList<String> arrclass = new ArrayList<>(Arrays.asList(
					
					"com.formapp.model.mysql.GarantíaNivelPartida", "com.formapp.model.mysql.PartidasInformeIA"
		
			));

			for (String str : arrclass) {
				// System.out.println(str);

				Class<?> cls = Class.forName(str);
				String ar = str.substring(0, 1);
				Character.toUpperCase(str.charAt(0));
				System.out.println(ar.toUpperCase() + str.substring(1));

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/

	@GetMapping("/fill")
	public void getAppendice() {
		try {
			ArrayList<String> arrclass = new ArrayList<>(Arrays.asList(
			
					"com.formapp.model.mysql.Pedimento", "com.formapp.model.mysql.Generales"
			
			));

			// process the line
			int count = 37;

			
			for (String str : arrclass) {
				Class<?> cls = Class.forName(str);
				Table table = cls.getAnnotation(Table.class);
				String tableName = table.name();
				ReflectionUtils.doWithFields(cls, field -> {
					if (!field.getName().equals("id")) {
						FormFields ffields = null;
						if (field.getType().getName().contains("String"))
							ffields = new FormFields("0", tableName.replaceAll("`", ""), "true", "false", "true",
									"false", "true", "",
									field.getName().substring(0, 1).toLowerCase() + field.getName().substring(1),
									"text", "false", "100", "");
						else if (field.getType().getName().contains("int"))
							ffields = new FormFields("0", tableName.replaceAll("`", ""), "true", "false", "true",
									"false", "true", "",
									field.getName().substring(0, 1).toLowerCase() + field.getName().substring(1),
									"number", "false", "100", "");
						else
							ffields = new FormFields("0", tableName.replaceAll("`", ""), "true", "false", "true",
									"false", "true", "",
									field.getName().substring(0, 1).toLowerCase() + field.getName().substring(1),
									"text", "false", "100", "");

						fieldsRepository.save(ffields);
					}

				});
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@GetMapping("/rel")
	public void updateRelation() {

		ArrayList<FormFields> arfield= (ArrayList<FormFields>) fieldsRepository.findAll();
		
		for(FormFields f:arfield) {
			if(f.getName().equalsIgnoreCase("clave_del_Tipo_de_Registro")) {
				f.setIsDisabled("true");
				f.setDefaultValue(f.getCode());
				fieldsRepository.save(f);
			}
			
		}
	}
	
		@RequestMapping( value="/generateMfile",method	=RequestMethod.POST ,produces=MediaType.APPLICATION_JSON_VALUE)
		public @ResponseBody Response getMfile1(@RequestBody String mfileData)
		{
			 Response result=new Response();
		JSONArray array = new JSONArray(mfileData);
        List<JSONObject> list = new ArrayList<JSONObject>();
        List<JSONObject> list2 = new ArrayList<JSONObject>();
        for (int i =0 ; i < array.length(); i++) {
        	int temp = 0;
        	for (int j = i + 1 ; j < array.length(); j++) {
        		
        		if(!array.getJSONObject(i).get("patente_o_autorización").toString().equals("0"))
        		{
        			if((array.getJSONObject(i).get("patente_o_autorización").toString()).equals(array.getJSONObject(j).get("patente_o_autorización").toString())) 
        			{
        			list.add(array.getJSONObject(i));
        			list.add(array.getJSONObject(j));
        			System.out.println("data of list"+j+"  "+list);
        			array.getJSONObject(j).put("patente_o_autorización","0");
        			temp= 1;
        			}
        			
        		}
        		
        	}
        	
        	if (temp==0 && !array.getJSONObject(i).get("patente_o_autorización").toString().equals("0") ) {
        			list2.add(array.getJSONObject(i));
        		 JSONArray resultArray1 = new JSONArray(list2);
        		 result= getMfile(resultArray1); 
        		 list2.clear();
			}
        	if(temp==1)
        	{	
        			System.out.println("número_de_Pedimento  "+list);
        		 JSONArray resultArray = new JSONArray(list);
        		  result=getMfile(resultArray);
        		 list.clear();
        	}
        	
        	
        }
      
		return result;
         
}
	
	

	public Response getMfile(JSONArray jsonObj)
	{
		List<DependentForm> dependentForm = null;
		List<Object[]> ls = new ArrayList<Object[]>();
		List<Object[]> lss = new ArrayList<Object[]>();
		StringBuilder finalString = new StringBuilder();
		
		String patente_o_autorización ="";
		String filename ="";
		try {
			for (Object obj : jsonObj) 
			{
				JSONObject arObj = (JSONObject) obj;
				
				 List <FormData> lsFormData =  new ArrayList<FormData>();
				int tipo_pedimento =  (int) arObj.get("tipo_de_Pedimento");
				long número_de_Pedimento = Long.parseLong(arObj.get("número_de_Pedimento").toString());
				patente_o_autorización = arObj.get("patente_o_autorización").toString();
			
				FormManager arrForms = formRepo.findById(tipo_pedimento);
				for (FormData data :arrForms.getArrForms()) {
					if(data.isMandatory())
					{
						lsFormData.add(data);
					}
					
				}
				
				
				 for (FormData formData : lsFormData) {
					lss  = genericdao.getParentId(formData, número_de_Pedimento);
					System.out.println("size of ls "+ls.size());
					 if(!lss.isEmpty()) {
						 for (Object[] objects : lss) 
			 				{
					
			 					for (int i = 1; i < objects.length; i++) {
							
			 						finalString.append(objects[i].toString().replaceAll(" ", "")).append("|");
			 				}
						 
	                      
				}
			
			finalString.deleteCharAt(finalString.length() - 1);
			finalString.append(System.getProperty("line.separator"));
						 
					  long parentid = getParentID(lss);
					  dependentForm= dependentFormRepo.findByFormidAndFormmanagerid(formData.getFormid(), tipo_pedimento);
					  System.out.println("*****dependentForm****** " +dependentForm);
					 	for (DependentForm dependentformData : dependentForm) 
					 	{
					 		FormData data = dataService.findByCode(dependentformData.getCode());
					
					 		ls= genericdao.getAllDataForMfilw(data , parentid);
					 			if(!ls.isEmpty())
					 				{
					 				for (Object[] objects : ls) 
					 				{
							
					 					for (int i = 1; i < objects.length; i++) {
									
					 						finalString.append(objects[i].toString().replaceAll(" ", "")).append("|");
					 				}
			                      
						}
					
					finalString.deleteCharAt(finalString.length() - 1);
					finalString.append(System.getProperty("line.separator"));
				}
				}

				}		
			}
		
			 filename =dataService.saveOutput(finalString, patente_o_autorización);

		} 
		}catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		
		Response response = new Response();
		response.setDivData(finalString.toString());
		response.setFilename(filename);
		
		return response;
	}
	private long getParentID(List<Object[]> ls) {
		long parentID =0;
		for (Object[] objects : ls) {
			 for (int i = 0; i < objects.length; i++) {
				parentID = Long.parseLong(objects[0].toString());
				System.out.println("***********" +parentID);
			}
		}
		return parentID;
	}
	@GetMapping("/getParentFormid/")
	public @ResponseBody String getParentFormid(@RequestParam("formid")String formid, @RequestParam("managerid") String managerid	){
		DependentForm dependentForm= dependentFormRepo.findByDependentFormIdAndFormmanagerid(formid,Long.parseLong(managerid));
		
		if(dependentForm!=null) {
			FormData data = formDataRepo.findByFormid(dependentForm.getFormid());
			if(data!=null)
		return  data.getCode();
			else {
				return null;
			}
		}
		else
			return null;

	}
	
	private JSONObject getjsonObject(String jsonString , String mangerid) {
		JSONObject jsonObject = new JSONObject(jsonString);
		String tipo_de_registro = jsonObject.get("clave_del_Tipo_de_Registro").toString();
			if(tipo_de_registro.equals("510"))
			{	
				Tasas tasas = new Tasas();
						/*509, 
						Long.parseLong(jsonObject.get("número_de_pedimento").toString()),
						Integer.parseInt(jsonObject.get("clave_Contribución").toString()),
						Double.parseDouble(jsonObject.get("tasa_Contribución").toString()),
						Integer.parseInt(jsonObject.get("clave_Tipo_Tasa").toString()));*/
				tasas.setClave_del_Tipo_de_Registro(509);
				tasas.setNúmero_Pedimento(Long.parseLong(jsonObject.get("número_de_pedimento").toString()));
				tasas.setClave_Tipo_Tasa(Integer.parseInt(jsonObject.get("clave_Tipo_Tasa").toString()));
				tasas.setClave_Contribución(Integer.parseInt(jsonObject.get("clave_Contribución").toString()));
				tasas.setTasa_Contribución(Double.parseDouble(jsonObject.get("tasa_Contribución").toString()));
				Gson gson = new Gson();
				String json = gson.toJson(tasas);
				JSONObject jsonObj = new JSONObject(json);
				jsonObj.remove("id");
				jsonObj.remove("clave_formulario_principal");
				String jsonStr =jsonObj.toString();
				
				System.out.println("tasa String "+json);
				save(jsonStr,mangerid);
				
				jsonObject.remove("clave_Tipo_Tasa");
				jsonObject.remove("tasa_Contribución");
			}
	
			if(tipo_de_registro.equals("557"))
			{	
				TasasNivelPartida tasas = new TasasNivelPartida();
						
				tasas.setClave_del_Tipo_de_Registro(556);
				tasas.setNúmero_pedimento(Long.parseLong(jsonObject.get("número_pedimento").toString()));
				tasas.setFracción_Arancelaria(jsonObject.get("fracción_Arancelaria").toString());
				tasas.setNúmero_Partida(Integer.parseInt(jsonObject.get("número_Partida").toString()));
				tasas.setClave_Contribución_pagar(Integer.parseInt(jsonObject.get("clave_Contribución_pagar").toString()));
				
				tasas.setTasa_Contribución(Double.parseDouble(jsonObject.get("tasa_Contribución").toString()));
				
				tasas.setTipo_tasa_aplicable(Integer.parseInt(jsonObject.get("tipo_tasa_aplicable").toString()));

				Gson gson = new Gson();
				String json = gson.toJson(tasas);
				JSONObject jsonObj = new JSONObject(json);
				jsonObj.remove("id");
				jsonObj.remove("clave_formulario_principal");
				String jsonStr =jsonObj.toString();
				
				System.out.println("tasa String "+json);
				save(jsonStr, mangerid);
				
				jsonObject.remove("tipo_tasa_aplicable");	
				jsonObject.remove("tasa_Contribución");
			}
	
			
			/*FormData data = dataService.findByCode(jsonObject.get("clave_del_Tipo_de_Registro").toString());
			
				if(data.getCode().equals("510"))
				{
					
					
				}
					for (FormFields fieldsobj : data.getFields()) {

						if (jsonObject.has(fieldsobj.getName().replaceAll(" ", ""))) {
									
							if (fieldsobj.getName().replaceAll(" ", "").contains("patente_o_autorización") || fieldsobj.getName().replaceAll(" ", "").contains("patente_autorización")) {
								patent = (String) String.valueOf(jsonObject.get(fieldsobj.getName().replaceAll(" ", "")));
								int contentLength = 4-patent.length();
								String appendZero = getPatenteAuth(contentLength);
								patent= patent+appendZero;
								jsonObject.put(fieldsobj.getName(), patent);
							
								
							}
							finalString.append(jsonObject.get(fieldsobj.getName().replaceAll(" ", ""))).append("|");

						}
					}
			*/
		
		return jsonObject;
}
/*	@GetMapping("/getParentFormid/")
	public String getParentFormid(@RequestParam("code")String code, @RequestParam("id") String id	){
		long formManagerID =	Long.parseLong(id);
		DependentForm dependentForm= dependentFormRepo.findByDependentFormIdAndFormmanagerid(code,formManagerID);
		FormData data = formDataRepo.findByFormid(dependentForm.getFormid());
		return  data.getCode();
	}
	*/
	
	@GetMapping("/getRow/")
	public @ResponseBody List<? extends AuditBase> getRowData(@RequestParam("code")String code, @RequestParam("id") String id	){
		System.out.println(code +" ************ "+id);
		List<String> returnList = new ArrayList<String>();
		System.out.println("Mapping : "+tableToClassMapping.getClass(code));
		String className = tableToClassMapping.getClass(code);
		List<? extends AuditBase> ls;
		try {
			ls = genericdao.getRowData(code, id,Class.forName(className));
			
			System.out.println("Ls :"+ls);
			return ls;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return null;
	}
	@GetMapping("/deleteRow/")
	public @ResponseBody String deleteRowData(@RequestParam("code")String code, @RequestParam("id") String id	){
		
		int status = genericdao.deleteRowData(code,id);
	System.out.println("status "+status);
		
		return null;
	}
}
