package com.example.app.mapper;

import com.example.app.DTO.Rate;
import com.example.app.model.Tarifa;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class TarifaMapperService implements MapperService<Rate, Tarifa> {

    @Override
    public Tarifa mapDtoToEntity(Rate dto) {
        return null;
    }

    @Override
    public Rate mapEntityToDto(Tarifa entity) {
        return null;
    }
}
