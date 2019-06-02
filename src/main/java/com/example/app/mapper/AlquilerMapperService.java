package com.example.app.mapper;

import com.example.app.DTO.Rental;
import com.example.app.model.Alquiler;
import com.example.app.util.DateUtil;
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
        entidad.setFechaInicio(DateUtil.stringToDate(dto.getStartDate()));
        entidad.setFechaFin(DateUtil.stringToDate(dto.getEndDate()));
        return entidad;
    }

    @Override
    public Rental mapEntityToDto(Alquiler entity) {
        Rental dto = new Rental();
        dto.setId(entity.getId());
        dto.setClient(clienteMapperService.mapEntityToDto(entity.getCliente()));
        dto.setCar(cocheMapperService.mapEntityToDto(entity.getCoche()));
        dto.setPrice(entity.getPrecio());
        dto.setStartDate(DateUtil.dateToString(entity.getFechaInicio()));
        dto.setEndDate(DateUtil.dateToString(entity.getFechaFin()));
        return dto;
    }
}
