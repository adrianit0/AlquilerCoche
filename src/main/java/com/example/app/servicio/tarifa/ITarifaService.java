package com.example.app.servicio.tarifa;

import com.example.app.model.Tarifa;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ITarifaService {
    Optional<Tarifa> findById(Integer id);

    Page<Tarifa> findAll(Integer page, Integer size);

    Tarifa create(Tarifa tarifa);

    void update(Tarifa tarifa);

    void delete(Integer idTarifa);
}
