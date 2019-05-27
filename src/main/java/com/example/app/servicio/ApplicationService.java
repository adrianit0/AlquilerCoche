package com.example.app.servicio;

import org.springframework.stereotype.Component;

@Component
public class ApplicationService implements IApplicationService {
	
	String type = "AUTO";
	
	public String greetings () {
		return "Hola mundo";
	}

	@Override
	public Integer sum(Integer... valores) {
		Integer total = 0;
		for (Integer i :  valores) 
			total += i;
		return total;
	}
}
