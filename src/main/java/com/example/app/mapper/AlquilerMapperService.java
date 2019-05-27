package com.example.app.mapper;

import com.example.app.DTO.Rental;
import com.example.app.model.Alquiler;

public class AlquilerMapperService implements MapperService<Rental, Alquiler> {
    @Override
    public Alquiler mapDtoToEntity(Rental dto) {
        Alquiler entidad = new Alquiler();
        //entidad.setCliente();
        //entidad.setCliente();
        entidad.setId(dto.getId());
        entidad.setPrecio(dto.getPrice());
        return entidad;
    }

    @Override
    public Rental mapEntityToDto(Alquiler entity) {
        Rental dto = new Rental();
        dto.setId(entity.getId());
        dto.setPrice(entity.getPrecio());
        return dto;
    }
}
