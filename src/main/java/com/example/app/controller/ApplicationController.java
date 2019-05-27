package com.example.app.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import DTO.LibroDTO;

@RestController
@RequestMapping("/book")
public class ApplicationController {
	
	private List<LibroDTO> libros = new ArrayList<LibroDTO>();
	
	public ApplicationController () {
		LibroDTO libro = new LibroDTO();
		libro.setIsbn("2");
		libro.setNombre("El señor de los anillos");
		libro.setPaginas(5);
		
		LibroDTO libro2 = new LibroDTO();
		libro2.setIsbn("4");
		libro2.setNombre("Juego de tronos");
		libro2.setPaginas(1800);

		libros.add(libro);
		libros.add(libro2);
	}

	@GetMapping	
	public List<LibroDTO> findAll () {
		return libros;
	}
	
	@GetMapping	("/{id}")
	public LibroDTO findOne(@PathVariable("id") String isbn) {
		LibroDTO libro = libros.stream().filter(l -> l.getIsbn().equals(isbn)).findFirst().orElse(new LibroDTO());
		return libro;
	}
	
	@PostMapping
	public LibroDTO post (@RequestBody LibroDTO libro) {
		libros.add(libro);
		return libro;
	}
	
	@PutMapping ("/{id}")
	public LibroDTO put(@PathVariable("id") Integer id, @RequestBody LibroDTO libro) {
		LibroDTO dto = libros.set(id, libro);
		return libro;
	}
	
	@DeleteMapping("/{id}")
	public LibroDTO delete (@PathVariable("id") Integer id)  {
		LibroDTO libro = libros.remove(id.intValue());
		return libro;
	}
	
}
