package com.example.app.servicio.coche;

import com.example.app.DTO.Car;
import com.example.app.model.Coche;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CocheService implements ICocheService {
    //FIXME: TERMINAR SERVICE


    @Override
    public Car findById(Integer id) {
        return null;
    }

    @Override
    public List<Car> findAll(Integer page, Integer size) {
        return null;
    }

    @Override
    public Car create(Car cocheDTO) {
        return null;
    }

    @Override
    public void update(Car cocheDTO) {

    }

    @Override
    public void delete(Integer idCoche) {

    }

    @Override
    public Car map(Car cocheDTO) {
        return null;
    }

    @Override
    public Car map(Coche cocheEntity) {
        return null;
    }
}
