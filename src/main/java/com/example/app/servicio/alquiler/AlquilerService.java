package com.example.app.servicio.alquiler;

import com.example.app.DTO.Rental;
import com.example.app.model.Alquiler;
import com.example.app.repositorio.AlquilerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlquilerService implements IAlquilerService {

    @Autowired
    private AlquilerRepository repository;

    @Override
    public Optional<Alquiler> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Boolean existsById (Integer id) {
        return repository.existsById(id);
    }

    @Override
    public Page<Alquiler> findAll(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);

        return repository.findAll(pageable);
    }

    @Override
    public Alquiler create(Alquiler alquiler) {
        return repository.save(alquiler);
    }

    @Override
    public void update(Alquiler alquiler) {
        repository.save(alquiler);
    }

    @Override
    public void delete(Integer idAlquiler) {
        repository.deleteById(idAlquiler);
    }
}
