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
public interface CocheRepository extends JpaRepository<Coche, Integer> {

    // Coge 1 solo por matricula. Peta si hay más de 1
    Optional<Coche> findOneByMatricula(String n);

    Optional<Coche> findOneById(Integer id);

    List<Coche> findByMatriculaContaining (String n);

    boolean existsById(Integer id);

    Page<Coche> findByMatriculaContaining(String matricula, Pageable pageable);

    Page<Coche> findAll (Pageable pageable);

    /**
     * Dada un rango de fecha cual es el coche más rentable en ese rango por día
     *
     * */

    @Query(value = "SELECT * FROM Coche c INNER JOIN Alquiler a ON c.id = a. WHERE ?1 BETWEEN t.fechaInicio AND t.fechaFin",
            countQuery = "SELECT count(*) FROM TARIFA WHERE LASTNAME = ?1",
            nativeQuery = true)
    Page<Tarifa> findByFecha(Date fecha, Pageable pageable);

}
