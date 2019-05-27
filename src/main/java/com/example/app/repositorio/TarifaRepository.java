package com.example.app.repositorio;

import com.example.app.model.Coche;
import com.example.app.model.Tarifa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Repository
public interface TarifaRepository extends JpaRepository<Tarifa, Integer> {

    Optional<Coche> findOneById(Integer id);

}
