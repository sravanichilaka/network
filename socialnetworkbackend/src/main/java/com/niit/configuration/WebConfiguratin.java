package com.niit.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//dispatcher-servlet.xml in project 1
@Configuration
@EnableWebMvc   //<mvc:annotation-driven>
@ComponentScan(basePackages="com.niit")
public class WebConfiguratin extends WebMvcConfigurerAdapter
{

	public WebConfiguratin(){
	System.out.println("WEBCONFIG class is instantiated");
}
	
	@Bean(name="MultipartResolver")
public CommonsMultipartResolver getCommonsMultipartResolver(){
	return new CommonsMultipartResolver();
}

}


