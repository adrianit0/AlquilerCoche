package com.example.app.repositorio;

import com.example.app.model.Cliente;
import com.example.app.model.Coche;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    Optional<Cliente> findOneByNombre(String n);

    Optional<Cliente> findOneById(Integer id);

    List<Cliente> findByNombreContaining (String n);

    List<Cliente> findByNombreContaining(String n, Pageable pageable);
}
