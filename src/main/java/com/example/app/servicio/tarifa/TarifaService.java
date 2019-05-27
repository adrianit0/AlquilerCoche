package com.example.app.servicio.tarifa;

import com.example.app.DTO.Rental;
import com.example.app.model.Tarifa;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarifaService implements ITarifaService {
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
    public Rental create(Rental cocheDTO) {
        return null;
    }

    @Override
    public void update(Rental cocheDTO) {

    }

    @Override
    public void delete(Integer idCoche) {

    }

    @Override
    public Rental map(Rental cocheDTO) {
        return null;
    }

    @Override
    public Rental map(Tarifa cocheEntity) {
        return null;
    }
}
