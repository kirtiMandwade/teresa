package com.formapp.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.formapp.error.InvalidFileException;
import com.formapp.model.FormData;
import com.formapp.model.mysql.User;
import com.formapp.userservice.FormDataService;
import com.formapp.userservice.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Value("${upload.file.directory}")
	private String uploadDirectory;
	
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private FormDataService formDataService;
	
	@GetMapping("/home")
    public String home() {
    	System.out.println("Admin Home Page ");
    	return "/index";
    }
	

	@GetMapping("/form")
    public String form() {
    	System.out.println("Admin Home Page ");
    	return "/formDetails";
    }
	
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody User addUser(@RequestBody User user) {
  
        System.out.println("(Service Side) Creating employee with : " + user.getFullname());
  
        return userService.save(user);
    }
	
	
	  @RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
	    public @ResponseBody List<User> getUser() {
//	        List<User> list = userService.findAll();
	        return null;
	    }
	
	  /*@RequestMapping(value = "/deleteUser/{id}",  method = RequestMethod.DELETE ,consumes = "application/json")*/
	  @RequestMapping(value = "/deleteUser/{id}", //
      method = RequestMethod.DELETE, //
      produces = { MediaType.APPLICATION_JSON_VALUE})
	
	    public  @ResponseBody void deleteUser(@PathVariable("id") String id) {
	  
	        System.out.println("(Service Side) Deleting User with Id: " + id);
	  
	       userService.deleteUser(id);
	    }
	  
	 @RequestMapping(value = "/addUser", //
	            method = RequestMethod.PUT, //
	            produces = { MediaType.APPLICATION_JSON_VALUE, //
	                    MediaType.APPLICATION_XML_VALUE })
	    
	    public @ResponseBody User updateUser(@RequestBody User user) {
	  
	        return userService.updateUser(user);
	    }
	  
	 
	 @RequestMapping(value = "/saveForm", method = RequestMethod.POST, consumes = "application/json")
	    public @ResponseBody User addForm(@RequestBody FormData formData) {
		 formDataService.save(formData);
	  
	        return null;
	    }
	 @RequestMapping(value = "/upload", method = RequestMethod.POST)
     public String fileUploads(@RequestParam("file") MultipartFile file) {
		 System.out.println("in Admin controller upload");
             try {
                    
                     File uploadedFile = userService.uploadFile(file, uploadDirectory);
                    
                     // System.out.println(user.getNational_id());
                    
             } catch (InvalidFileException e) {
                    System.out.println("Invalid Extension ");
                     e.printStackTrace();
             } catch (IOException e) {
                     // TODO Auto-generated catch block
                     e.printStackTrace();
             }
             // userService.save(uploadedFile);

             return "adminlayout";
     }
}
