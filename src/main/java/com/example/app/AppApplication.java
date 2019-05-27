package com.example.app;

import com.example.app.DTO.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.app.servicio.IApplicationService;
import com.example.app.servicio.OtherService;


@SpringBootApplication
public class AppApplication implements CommandLineRunner {
	
	@Autowired private IApplicationService servicio;
	@Autowired private OtherService otroServicio;
	
	//@Autowired private MapperService<LibroDTO, Libro> libroMapper;
	

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	public void run (String... args) {
		System.out.println(servicio.greetings());
		Car coche = servicio.getCar();
		if (coche!=null)
			System.out.println(coche.getId());
		else
			System.out.println("Coche no encontrado");
	}


}
