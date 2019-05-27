package com.example.app.servicio;

import com.example.app.DTO.Car;

public interface IApplicationService {
	/**
	 * Devuelve la suma de todos los valores dados
	 * 
	 * @Param valores Cada uno de los valores a sumar
	 * @return La suma total
	 * */
	public Integer sum (Integer... valores);
	
	
	/**
	 * Devuelve un HOLA MUNDO!
	 * */
	public String greetings ();

	public Car getCar ();
	
	
	// Métodos por defecto en interface
	// Se puede realizar a partir de JAVA 8
	default Integer random () {
		return (int) Math.random();
	}
}