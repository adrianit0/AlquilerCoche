package com.example.app.servicio.cliente;

import com.example.app.DTO.Client;
import com.example.app.model.Cliente;

import java.util.List;

public interface IClienteService {

    Client findById(Integer id);

    List<Client> findAll(Integer page, Integer size);

    Client create(Client clienteDTO);

    void update(Client clienteDTO);

    void delete(Integer idCliente);

    public Client map(Client clienteDTO);

    public Client map(Cliente clienteEntity);
}
