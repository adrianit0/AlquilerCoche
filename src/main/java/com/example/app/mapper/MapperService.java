package com.example.app.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface MapperService<S, T> {

	T mapDtoToEntity (S dto);

	S mapEntityToDto (T entity);
	
	default List<T> mapDtoToEntity (List<S> parametros) {
		List<T> lista = new ArrayList<>();

		for (S s : parametros) {
			lista.add(mapDtoToEntity(s));
		}

		return lista;
	}

	default List<S> mapEntityToDto (List<T> parametros) {
		List<S> lista = new ArrayList<>();

		for (T t : parametros) {
			lista.add(mapEntityToDto(t));
		}

		return lista;
	}

}
