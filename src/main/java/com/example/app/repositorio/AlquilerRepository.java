package com.example.app.repositorio;

import com.example.app.model.Alquiler;
import com.example.app.model.Coche;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlquilerRepository extends JpaRepository<Alquiler, Integer> {

    Optional<Alquiler> findOneById(Integer id);

    Page<Alquiler> findAll (Pageable pageable);

}
