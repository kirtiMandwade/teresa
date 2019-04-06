package com.formapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
@EnableConfigurationProperties
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    @Autowired
    JPAUserDetailsService userDetailsService;
    
    @Autowired
	private AppAuthenticationSuccessHandler successHandler;
    
    // roles admin allow to access /admin/**
    // roles user allow to access /user/**
    // custom 403 access denied handler
    @Override
    protected void configure(HttpSecurity http) throws Exception {

    	 http.csrf().disable()
         .authorizeRequests()
         .antMatchers(
                 "/",
                 "/js/**",
                 "/lib/**",
                 "/css/**",
                 "/img/**",
                 "/webjars/**").permitAll()
         .antMatchers("/", "/home", "/about").permitAll()
         .antMatchers("/admin/**").hasAnyRole("ADMIN")
         .antMatchers("/user/**").hasAnyRole("ADMIN")
         .antMatchers("/user/**").hasAnyRole("USER")
         .antMatchers("/user/**/**").hasAnyRole("USER")
         .anyRequest().authenticated()
         .and()
         .formLogin().successHandler(successHandler)
         .loginPage("/login").permitAll().and().logout()
         .permitAll()
         .and()
         .exceptionHandling().accessDeniedHandler(accessDeniedHandler);
    }
   
    
    @Override
    public void configure(AuthenticationManagerBuilder builder) throws Exception {
      builder.authenticationProvider(userDetailsService);      
    }
}
