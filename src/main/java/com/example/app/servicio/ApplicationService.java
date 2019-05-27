package com.example.app.servicio;

import com.example.app.DTO.Car;
import com.example.app.mapper.CocheMapperService;
import com.example.app.model.Coche;
import com.example.app.repositorio.CocheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApplicationService implements IApplicationService {
	
	String type = "AUTO";

	@Autowired
	private CocheMapperService cocheMapperService;
	@Autowired
	private CocheRepository cocheRepository;
	
	public String greetings () {
		return "Hola mundo";
	}

	@Override
	public Car getCar() {
		Coche entity = cocheRepository.getOne(1);

		if (entity!=null) {
			return cocheMapperService.mapEntityToDto(entity);
		} else
			return null;
	}

	@Override
	public Integer sum(Integer... valores) {
		Integer total = 0;
		for (Integer i :  valores) 
			total += i;

		return total;
	}


}
