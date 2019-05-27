package com.example.app.servicio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration{
	
	//@Bean(name = "applicationServiceAux")
	public ApplicationService serviceAux(){
		final ApplicationService service = new ApplicationService();
		service.type = "MANUAL";
		return service;
	}
	
	
}
