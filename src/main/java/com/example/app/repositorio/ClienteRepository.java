package com.example.app.repositorio;

import com.example.app.model.Cliente;
import com.example.app.model.Coche;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    Optional<Cliente> findOneByNombre(String n);

    /**
     * Devuelve un valor por su id
     *
     * @param id La id que se le pasa
     * @return  El client
     * */
    Optional<Cliente> findOneById(Integer id);

    List<Cliente> findByNombreContaining (String nombre);

    Page<Cliente> findByNombreContaining (String nombre, Pageable pageable);

}
