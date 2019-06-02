package com.example.app.mapper;

import com.example.app.DTO.Rate;
import com.example.app.model.Tarifa;
import com.example.app.util.DateUtil;
import org.springframework.stereotype.Component;

@Component
public class TarifaMapperService implements MapperService<Rate, Tarifa> {

    @Override
    public Tarifa mapDtoToEntity(Rate dto) {
        Tarifa entity = new Tarifa();
        entity.setId(dto.getId());
        entity.setFechaInicio(DateUtil.stringToDate(dto.getStartDate()));
        entity.setFechaFin(DateUtil.stringToDate(dto.getEndDate()));
        return entity;
    }

    @Override
    public Rate mapEntityToDto(Tarifa entity) {
        Rate dto = new Rate();
        dto.setId(entity.getId());
        dto.setPrice(entity.getPrecio());
        dto.setStartDate(DateUtil.dateToString(entity.getFechaInicio()));
        dto.setEndDate(DateUtil.dateToString(entity.getFechaFin()));
        return dto;
    }
}
