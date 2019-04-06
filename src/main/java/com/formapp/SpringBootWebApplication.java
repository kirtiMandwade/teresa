package com.formapp;

import java.io.IOException;
import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

//http://www.thymeleaf.org/doc/articles/layouts.html
@SpringBootApplication
@EnableAutoConfiguration
public class SpringBootWebApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootWebApplication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringBootWebApplication.class, args);
	}

	@Bean
	public TableToClassMapping mapTableToClass() {
		System.out.println("Start mapping");
		Resource resource = new ClassPathResource("/table-to-class.properties");
		TableToClassMapping tableToClassMapping = new TableToClassMapping();
		try {
			Properties props = PropertiesLoaderUtils.loadProperties(resource);
			for (Object keys : props.keySet()) {
				tableToClassMapping.addToMysqlTable(keys.toString(), props.getProperty(keys.toString()));
			}
			return tableToClassMapping;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Returns null");
		return null;
	}

}