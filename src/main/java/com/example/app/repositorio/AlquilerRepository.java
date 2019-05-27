package com.example.app.repositorio;

import com.example.app.model.Alquiler;
import com.example.app.model.Coche;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface AlquilerRepository extends JpaRepository<Alquiler, Integer> {

    Optional<Alquiler> findOneById(Integer id);

}
