package com.example.app.mapper;

import com.example.app.DTO.Rental;
import com.example.app.model.Alquiler;
import com.example.app.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AlquilerMapperService implements MapperService<Rental, Alquiler> {

    @Autowired private ClienteMapperService clienteMapperService;
    @Autowired private CocheMapperService cocheMapperService;

    @Override
    public Alquiler mapDtoToEntity(Rental dto) {
        Alquiler entidad = new Alquiler();
        entidad.setId(dto.getId());
        entidad.setCliente(clienteMapperService.mapDtoToEntity(dto.getClient()));
        entidad.setCoche(cocheMapperService.mapDtoToEntity(dto.getCar()));
        entidad.setPrecio(dto.getPrice());
        entidad.setFechaInicio(Util.stringToDate(dto.getStartDate()));
        entidad.setFechaFin(Util.stringToDate(dto.getEndDate()));
        return entidad;
    }

    @Override
    public Rental mapEntityToDto(Alquiler entity) {
        Rental dto = new Rental();
        dto.setId(entity.getId());
        dto.setClient(clienteMapperService.mapEntityToDto(entity.getCliente()));
        dto.setCar(cocheMapperService.mapEntityToDto(entity.getCoche()));
        dto.setPrice(entity.getPrecio());
        dto.setStartDate(Util.dateToString(entity.getFechaInicio()));
        dto.setEndDate(Util.dateToString(entity.getFechaFin()));
        return dto;
    }
}
