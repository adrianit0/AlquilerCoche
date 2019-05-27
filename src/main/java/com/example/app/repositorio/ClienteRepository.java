package com.example.app.repositorio;

import com.example.app.model.Cliente;
import com.example.app.model.Coche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    Optional<Cliente> findOneByNombre(String n);

    /**
     * Devuelve un valor por su id
     *
     * @Param id La id que se le pasa
     * @Result El client
     * @Author Adrián García
     * @Version 1.0
     *
     * */
    Optional<Cliente> findOneById(Integer id);

    List<Cliente> findByNombreContaining (String n);

    //List<Cliente> findByNombreContaining(String n, Pageable pageable);

}
