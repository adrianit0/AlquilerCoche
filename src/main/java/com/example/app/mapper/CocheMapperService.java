package com.example.app.mapper;

import com.example.app.DTO.Car;
import com.example.app.model.Coche;
import org.springframework.stereotype.Service;

@Service
public class CocheMapperService implements MapperService<Car, Coche> {
    @Override
    public Coche mapDtoToEntity(Car dto) {
        Coche entity = new Coche();
        entity.setId(dto.getId());
        entity.setMatricula(dto.getCarPlate());

        return entity;
    }

    @Override
    public Car mapEntityToDto(Coche entity) {
        Car dto = new Car();
        dto.setId(entity.getId());
        //dto.setCarPlate(entity.getMatricula());

        return dto;
    }
}
