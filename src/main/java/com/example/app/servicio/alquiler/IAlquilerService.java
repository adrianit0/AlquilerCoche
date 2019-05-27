package com.example.app.servicio.alquiler;

import com.example.app.DTO.Rental;
import com.example.app.model.Alquiler;

import java.util.List;

public interface IAlquilerService {
    Rental findById(Integer id);

    List<Rental> findAll(Integer page, Integer size);

    Rental create(Rental alquilerDTO);

    void update(Rental alquilerDTO);

    void delete(Integer idAlquiler);

    public Rental map(Rental alquilerDTO);

    public Rental map(Alquiler alquilerEntity);
}
