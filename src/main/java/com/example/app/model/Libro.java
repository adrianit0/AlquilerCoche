package com.example.app.model;

import lombok.Data;

@Data
public class Libro {
	
	private Integer id;
	private String nombre;
	private String isbn;
	private String autor;
	private Integer paginas;
	private String colorPortada;
	
}
