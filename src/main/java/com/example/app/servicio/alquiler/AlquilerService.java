package com.example.app.servicio.alquiler;

import com.example.app.DTO.Rental;
import com.example.app.model.Alquiler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlquilerService implements IAlquilerService {
    //FIXME: TERMINAR SERVICE


    @Override
    public Rental findById(Integer id) {
        return null;
    }

    @Override
    public List<Rental> findAll(Integer page, Integer size) {
        return null;
    }

    @Override
    public Rental create(Rental alquilerDTO) {
        return null;
    }

    @Override
    public void update(Rental alquilerDTO) {

    }

    @Override
    public void delete(Integer idAlquiler) {

    }

    @Override
    public Rental map(Rental alquilerDTO) {
        return null;
    }

    @Override
    public Rental map(Alquiler alquilerEntity) {
        return null;
    }
}
