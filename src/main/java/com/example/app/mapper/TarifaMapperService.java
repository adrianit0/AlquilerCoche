package com.example.app.mapper;

import com.example.app.DTO.Rate;
import com.example.app.model.Tarifa;
import com.example.app.util.Util;
import org.springframework.stereotype.Component;

@Component
public class TarifaMapperService implements MapperService<Rate, Tarifa> {

    @Override
    public Tarifa mapDtoToEntity(Rate dto) {
        Tarifa entity = new Tarifa();
        entity.setId(dto.getId());
        entity.setFechaInicio(Util.stringToDate(dto.getStartDate()));
        entity.setFechaFin(Util.stringToDate(dto.getEndDate()));
        return entity;
    }

    @Override
    public Rate mapEntityToDto(Tarifa entity) {
        Rate dto = new Rate();
        dto.setId(entity.getId());
        dto.setPrice(entity.getPrecio());
        dto.setStartDate(Util.dateToString(entity.getFechaInicio()));
        dto.setEndDate(Util.dateToString(entity.getFechaFin()));
        return dto;
    }
}
