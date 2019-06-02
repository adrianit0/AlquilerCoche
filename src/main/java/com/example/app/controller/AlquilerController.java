package com.example.app.controller;

import com.example.app.DTO.Car;
import com.example.app.DTO.Rental;
import com.example.app.mapper.AlquilerMapperService;
import com.example.app.model.Alquiler;
import com.example.app.servicio.alquiler.AlquilerService;
import com.example.app.util.Constantes;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(Constantes.URL_ALQUILER)
public class AlquilerController {

    private @Autowired AlquilerService alquilerService;
    private @Autowired AlquilerMapperService alquilerMapperService;

    @GetMapping(value = Constantes.URL_BY_ID)
    public ResponseEntity<Rental> getAlquilerById (@PathVariable(Constantes.PATH_PARAM_ID) Integer id) {
        return Optional.of(id)
                .flatMap(alquilerService::findById)
                .map(alquilerMapperService::mapEntityToDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    @ResponseBody
    public Page<Rental> getAlquileres (
            @RequestParam(name = Constantes.REQUEST_PARAM_PAGE, required = false, defaultValue = "0") Integer page,
            @RequestParam(name = Constantes.REQUEST_PARAM_SIZE, required = false, defaultValue = "10") Integer size) {

        Page<Alquiler> alquileres = alquilerService.findAll(page, size);
        return alquileres.map(x -> alquilerMapperService.mapEntityToDto(x));
    }

    @PostMapping
    @SuppressWarnings("Duplicates")
    public ResponseEntity<Rental> insertAlquiler (@Valid @RequestBody Rental dto) {
        Optional<Integer> idAlquiler = Optional.of(dto)
                .map(alquilerMapperService::mapDtoToEntity)
                .map(v -> v.getId());

        Boolean existe = idAlquiler
                .map(alquilerService::existsById)
                .orElse(false);

        if (idAlquiler.isPresent() && existe)
            return ResponseEntity.badRequest().build();

        return Optional.of(dto)
                .map(alquilerMapperService::mapDtoToEntity)
                .map(alquilerService::create)
                .map(alquilerMapperService::mapEntityToDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping (value = Constantes.URL_BY_ID)
    @SuppressWarnings("Duplicates")
    public ResponseEntity<? extends Rental> updateAlquiler (@PathVariable("id") Integer id, @Valid @RequestBody Rental dto) {
        boolean existe = Optional.of(id)
                .map(alquilerService::existsById)
                .orElse(false);

        if (!existe)
            return ResponseEntity.notFound().build();

        dto.setId(id);
        alquilerService.update(alquilerMapperService.mapDtoToEntity(dto));

        return ResponseEntity.ok().build();
    }

    @DeleteMapping (value = Constantes.URL_BY_ID)
    public ResponseEntity<? extends Car> deleteCar (@PathVariable Integer id) {
        Boolean exists = Optional.of(id)
                .map(alquilerService::existsById)
                .orElse(false);

        if (!exists)
            return ResponseEntity.badRequest().build();

        alquilerService.delete(id);

        return ResponseEntity.ok().build();
    }

}

