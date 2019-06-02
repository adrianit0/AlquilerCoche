package com.example.app.repositorio;

import com.example.app.model.Coche;
import com.example.app.model.Tarifa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface TarifaRepository extends JpaRepository<Tarifa, Integer> {

    Optional<Tarifa> findOneById(Integer id);

    Page<Tarifa> findAllByFechaInicioAndFechaFinBeforeOrderByPrecio (Date fecha1, Date fecha2, Pageable pageable);

}
