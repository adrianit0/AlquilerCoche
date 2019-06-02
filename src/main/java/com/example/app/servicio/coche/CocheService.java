package com.example.app.servicio.coche;

import com.example.app.model.Coche;
import com.example.app.repositorio.CocheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CocheService implements ICocheService {
    @Autowired
    private CocheRepository cocheRepository;

    @Override
    public Optional<Coche> findById(Integer id) {
        return cocheRepository.findOneById(id);
    }

    @Override
    public Boolean existsById(Integer id) {
        return cocheRepository.existsById(id);
    }

    @Override
    public Page<Coche> findByMatricula(String matricula, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);

        // La razón por la que hago esto es porque si alguna matricula tiene valor null no lo devolverá en el matriculaContaining
        // y si se deja la matricula vacía quisiera poder devolver todos los coches.
        return (matricula.isEmpty()) ? cocheRepository.findAll(pageable) : cocheRepository.findByMatriculaContaining(matricula, pageable);
    }

    @Override
    public Coche create(Coche entidad) {
        return cocheRepository.save(entidad);
    }

    @Override
    public Coche update(Coche entidad) {
        return cocheRepository.save(entidad);
    }

    @Override
    public void delete(Integer idCoche) {
        cocheRepository.deleteById(idCoche);
    }
}
