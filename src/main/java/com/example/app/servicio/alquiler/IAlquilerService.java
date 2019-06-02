package com.example.app.servicio.alquiler;

import com.example.app.model.Alquiler;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface IAlquilerService {
    Optional<Alquiler> findById(Integer id);

    Boolean existsById (Integer id);

    Page<Alquiler> findAll(Integer page, Integer size);

    Alquiler create(Alquiler alquiler);

    void update(Alquiler alquiler);

    void delete(Integer idAlquiler);
}
