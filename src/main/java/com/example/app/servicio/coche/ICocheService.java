package com.example.app.servicio.coche;

import com.example.app.DTO.Car;
import com.example.app.model.Coche;

import java.util.List;

public interface ICocheService {
    Car findById(Integer id);

    List<Car> findAll(Integer page, Integer size);

    Car create(Car cocheDTO);

    void update(Car cocheDTO);

    void delete(Integer idCoche);

    public Car map(Car cocheDTO);

    public Car map(Coche cocheEntity);
}
