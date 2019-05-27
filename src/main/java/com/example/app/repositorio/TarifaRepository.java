package com.example.app.repositorio;

import com.example.app.model.Coche;
import com.example.app.model.Tarifa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface TarifaRepository extends JpaRepository<Tarifa, Integer> {

    Optional<Coche> findOneById(Integer id);

}
