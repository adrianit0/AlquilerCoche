package com.example.app.servicio.cliente;

import com.example.app.DTO.Client;
import com.example.app.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService {
    //FIXME: TERMINAR SERVICE


    @Override
    public Client findById(Integer id) {
        return null;
    }

    @Override
    public List<Client> findAll(Integer page, Integer size) {
        return null;
    }

    @Override
    public Client create(Client clienteDTO) {
        return null;
    }

    @Override
    public void update(Client clienteDTO) {

    }

    @Override
    public void delete(Integer idCliente) {

    }

    @Override
    public Client map(Client clienteDTO) {
        return null;
    }

    @Override
    public Client map(Cliente clienteEntity) {
        return null;
    }
}
