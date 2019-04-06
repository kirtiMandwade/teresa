
package com.formapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DefaultController {
	

	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
    @GetMapping( value = {"/" , "/login"})
    public String login(HttpServletRequest request, HttpServletResponse response) {
    	System.out.println("in default con");
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();

    	if (!(auth instanceof AnonymousAuthenticationToken)) {
  
    		List<GrantedAuthority> authorities = (List<GrantedAuthority>) auth.getAuthorities();
    		authorities.forEach(authority -> {
    			if (authority.getAuthority().equals("ROLE_USER")) {
    				try {
    					redirectStrategy.sendRedirect(request, response, "/user/home");
    				} catch (Exception e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
    			} else if (authority.getAuthority().equals("ROLE_ADMIN")) {
    				try {
    					redirectStrategy.sendRedirect(request, response, "/admin/home");
    				} catch (Exception e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
    			} else {
    				throw new IllegalStateException();
    			}
    		});
    		
        }
    	
        return "/login";
    }
    
    

    
   
   
    
   

    @GetMapping("/403")
    public String error403() {
        return "/error/access-denied.html";
    }

}
