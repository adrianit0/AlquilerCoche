package com.example.app.servicio.coche;

import com.example.app.model.Coche;
import com.example.app.repositorio.CocheRepository;
import javassist.NotFoundException;
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
    public Page<Coche> findAll(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return cocheRepository.findAll(pageable);
    }

    @Override
    public Coche create(Coche entidad) {
        return null;
    }

    @Override
    public Coche update(Coche entidad) {
        return null;
    }

    @Override
    public void delete(Integer idCoche) {
        cocheRepository.deleteById(idCoche);
    }
}
