package com.example.app.mapper;

import com.example.app.DTO.Car;
import com.example.app.model.Coche;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Optional;

@Component
public class CocheMapperService implements MapperService<Car, Coche> {
    @Override
    public Coche mapDtoToEntity(Car dto) {
        Coche entity = new Coche();
        entity.setId(dto.getId());
        entity.setMatricula(dto.getCarPlate());
        String year = Optional.ofNullable(dto.getRegistrationYear())
                .map(v -> v.toString())
                .orElse("0");
        entity.setFechaRegistrado(Date.valueOf(year + "-1-1"));

        return entity;
    }

    @Override
    public Car mapEntityToDto(Coche entity) {
        Car dto = new Car();
        dto.setId(entity.getId());
        dto.setCarPlate(entity.getMatricula());
        Integer year = Optional.of(entity)
                .map(v -> v.getFechaRegistrado())
                .map(v -> v.toLocalDate())
                .map(v -> v.getYear())
                .orElse(0);
        dto.setRegistrationYear(Integer.toString(year));

        return dto;
    }
}
