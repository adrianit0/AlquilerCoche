package com.example.app.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OtherService {
	
	@Autowired private ApplicationService servicio;

	public Integer sum (Integer n1, Integer n2) {
		return n1+n2;
	}
	
}
