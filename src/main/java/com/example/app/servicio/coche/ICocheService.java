package com.example.app.servicio.coche;

import com.example.app.DTO.Car;
import com.example.app.model.Coche;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ICocheService {
    Optional<Coche> findById(Integer id);

    Boolean existsById (Integer id);

    Page<Coche> findByMatricula (String matricula, Integer page, Integer size);

    Coche create(Coche entity);

    Coche update(Coche entity);

    void delete(Integer idCoche);
}
