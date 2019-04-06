package com.formapp.config;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Component;

import com.formapp.model.mysql.User;
import com.formapp.repository.UserRepository;


@Component
public class JPAUserDetailsService implements AuthenticationProvider {
	
	@Value("${client.id}")
	private   String client_id;
	
	@Value("${client.secret}")
	private  String client_secret;
	
	@Value("${accessUrl}")
	private  String url;
	
	
	@Autowired
	private UserRepository repository;
	
	
	public static boolean auth(String username,String clientId, String clientSecret,String password,String url) {
		try {
			
		
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			
			// add reuqest header
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

			String urlParameters = "grant_type=password&client_id="+clientId+"&client_secret="+clientSecret
					+ "&username="+username+"&password="+password;
			

			// Send post request
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();

			System.out.println("\nSending 'POST' request to URL : " + url);
			int responseCode = con.getResponseCode();
			System.out.println("Post parameters : " + urlParameters);
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			
			System.out.println(response.toString());
			if(response.toString().contains("access_token")) {
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
//			e.printStackTrace();
		} 
		return false;

	}


	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
	
		User user;
		String username = authentication.getName();
		String password = (String) authentication.getCredentials();
		
		user= repository.findByUsername(username);
		//if(auth(username,client_id,client_secret,password,url)) {
		if(user!=null) {
			 user = new User(username,password,"ROLE_USER");
		}
		else {
			throw new UsernameNotFoundException("User not found");
		}
	
		
	        return new UsernamePasswordAuthenticationToken(user, password,getAuthorities());
	    
	
	}


	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}
	
	public Collection<GrantedAuthority> getAuthorities() {
		// Create a list of grants for this user
		List<GrantedAuthority> authList = new ArrayList<>();
		authList.add(new SimpleGrantedAuthority("ROLE_USER"));
		return authList;
	}

}
