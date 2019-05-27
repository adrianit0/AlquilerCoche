package com.example.app.implementacion;

import com.example.app.DTO.ClienteDTO;
import com.example.app.model.Cliente;
import com.example.app.servicio.MapperService;

import java.util.List;

public class ClienteMapperService implements MapperService<ClienteDTO, Cliente> {
    @Override
    public ClienteDTO map(Cliente parametro) {
        return null;
    }

    @Override
    public List<ClienteDTO> map(List<Cliente> parametros) {
        return null;
    }
}
