package com.example.app.controller;

import com.example.app.DTO.Rate;
import com.example.app.mapper.TarifaMapperService;
import com.example.app.servicio.tarifa.TarifaService;
import com.example.app.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(Constantes.URL_TARIFA)
public class TarifaController {

    private @Autowired TarifaService tarifaService;
    private @Autowired TarifaMapperService tarifaMapperService;

    @PostMapping
    @SuppressWarnings("Duplicates") // Para que no ponga tonto con la duplicidad de código, aunque debería unificar el código duplicado (Aunque en el insert de tarifa y el deberia ser distintos porque sus dto lo son).
    public ResponseEntity<Rate> insertTarifa (@Valid @RequestBody Rate dto) {
        Optional<Integer> idTarifa = Optional.of(dto)
                .map(v -> tarifaMapperService.mapDtoToEntity(dto))
                .map(v -> v.getId());

        Boolean existe = idTarifa
                .map(tarifaService::existsById)
                .orElse(false);

        if (idTarifa.isPresent() && existe)
            return ResponseEntity.badRequest().build();

        return Optional.of(dto)
                .map(tarifaMapperService::mapDtoToEntity)
                .map(tarifaService::create)
                .map(tarifaMapperService::mapEntityToDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }
}