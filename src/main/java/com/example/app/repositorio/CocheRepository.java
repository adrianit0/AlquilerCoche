package com.example.app.repositorio;

import com.example.app.model.Coche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Repository
public interface CocheRepository extends JpaRepository<Coche, Integer> {

    // Coge 1 solo por nombre. Peta si hay más de 1
    Optional<Coche> findOneByMatricula(String n);

    Optional<Coche> findOneById(Integer id);

    List<Coche> findByMatriculaContaining (String n);

    //List<Coche> findByMatriculaContaining(String n, Pageable pageable);

}
