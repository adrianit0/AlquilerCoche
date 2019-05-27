package com.example.app.servicio;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface MapperService<T, S> {

	T map (S parametro);
	
	List<T> map (List<S> parametros);
	
}
