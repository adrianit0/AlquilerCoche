package com.example.app.mapper;

import com.example.app.DTO.Client;
import com.example.app.model.Cliente;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class ClienteMapperService implements MapperService<Client, Cliente> {
    @Override
    public Cliente mapDtoToEntity(Client dto) {
        return null;
    }

    @Override
    public Client mapEntityToDto(Cliente entity) {
        return null;
    }
}
