package com.example.app.servicio.tarifa;

import com.example.app.DTO.Rental;
import com.example.app.model.Tarifa;

import java.util.List;

public interface ITarifaService {
    Rental findById(Integer id);

    List<Rental> findAll(Integer page, Integer size);

    Rental create(Rental cocheDTO);

    void update(Rental cocheDTO);

    void delete(Integer idCoche);

    public Rental map(Rental cocheDTO);

    public Rental map(Tarifa cocheEntity);
}
