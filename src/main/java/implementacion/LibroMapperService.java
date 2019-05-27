package implementacion;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.app.model.Libro;
import com.example.app.servicio.MapperService;

import DTO.LibroDTO;

@Component
public class LibroMapperService implements MapperService<LibroDTO, Libro> {

	@Override
	public LibroDTO map(Libro parametro) {
		LibroDTO l = new LibroDTO();
		l.setNombre(parametro.getNombre());
		l.setIsbn(parametro.getIsbn());
		l.setPaginas(parametro.getPaginas());
		return l;
	}

	@Override
	public List<LibroDTO> map(List<Libro> parametros) {
		List<LibroDTO> libros = new ArrayList(parametros.size());
		for(Libro l : parametros) {
			libros.add(map(l));
		}
		return libros;
	}

}
