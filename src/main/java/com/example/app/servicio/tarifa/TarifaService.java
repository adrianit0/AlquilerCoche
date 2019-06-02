package com.example.app.servicio.tarifa;

import com.example.app.model.Tarifa;
import com.example.app.repositorio.TarifaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarifaService implements ITarifaService {

    @Autowired
    private TarifaRepository repository;

    @Override
    public Optional<Tarifa> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Boolean existsById( Integer id) {
        return repository.existsById(id);
    }

    @Override
    public Page<Tarifa> findAll(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);

        return repository.findAll(pageable);
    }

    @Override
    public Tarifa create(Tarifa tarifa) {
        return repository.save(tarifa);
    }

    @Override
    public void update(Tarifa tarifa) {
        repository.save(tarifa);
    }

    @Override
    public void delete(Integer idTarifa) {
        repository.deleteById(idTarifa);
    }
}
