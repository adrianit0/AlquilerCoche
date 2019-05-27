package com.example.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.app.model.Libro;
import com.example.app.servicio.IApplicationService;
import com.example.app.servicio.MapperService;
import com.example.app.servicio.OtherService;

import DTO.LibroDTO;

@SpringBootApplication
public class AppApplication /*implements CommandLineRunner*/ {
	
	@Autowired private IApplicationService servicio;
	@Autowired private OtherService otroServicio;
	
	//@Autowired private MapperService<LibroDTO, Libro> libroMapper;
	

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	/*public void run (String... args) {
		System.out.println(servicio.greetings());
		
		System.out.println("Suma: " + otroServicio.sum(4, 6));
		
		Libro libro = new Libro();
		libro.setId(1);
		libro.setNombre("Juego de tronos");
		libro.setIsbn("1234-124");
		libro.setPaginas(950);
		libro.setColorPortada("Negro");
		libro.setAutor("George RR Martin");
		
		LibroDTO libroDTO = libroMapper.map(libro);
		
		System.out.println("Libro: "+libroDTO.getNombre());
	}*/
}
