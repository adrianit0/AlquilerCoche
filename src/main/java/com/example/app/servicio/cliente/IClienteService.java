package com.example.app.servicio.cliente;

import com.example.app.model.Cliente;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface IClienteService {

    Optional<Cliente> findById(Integer id);

    Boolean existsById(Integer id);

    Page<Cliente> findAll(Integer page, Integer size);

    Cliente create(Cliente cliente);

    void update(Cliente cliente);

    void delete(Integer idCliente);
}
