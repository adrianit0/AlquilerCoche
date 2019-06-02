package com.example.app.mapper;

import com.example.app.DTO.Client;
import com.example.app.model.Cliente;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class ClienteMapperService implements MapperService<Client, Cliente> {
    @Override
    public Cliente mapDtoToEntity(Client dto) {
        Cliente cliente = new Cliente();
        cliente.setId(dto.getId());
        cliente.setDni(dto.getDni());
        cliente.setNombre(dto.getName());
        return cliente;
    }

    @Override
    public Client mapEntityToDto(Cliente entity) {
        Client dto = new Client();
        dto.setId(entity.getId());
        dto.setDni(entity.getDni());
        dto.setName(entity.getNombre());
        return dto;
    }
}
