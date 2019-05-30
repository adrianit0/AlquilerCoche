package com.example.app.controller;

import com.example.app.DTO.Car;
import com.example.app.mapper.CocheMapperService;
import com.example.app.model.Coche;
import com.example.app.servicio.coche.CocheService;
import com.example.app.util.Constantes;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController
@RequestMapping(value = Constantes.URL_COCHE)
public class CocheController {

    private @Autowired CocheService cocheService;
    private @Autowired CocheMapperService cocheMapperService;

    @GetMapping (value = Constantes.URL_BY_ID)
    public ResponseEntity<Car> getCocheById (@PathVariable(Constantes.PATH_PARAM_ID) Integer id) {
        return Optional.of(id)
                .flatMap(cocheService::findById)
                .map(cocheMapperService::mapEntityToDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    @ResponseBody
    public Page<Car> getCoches (@RequestParam(name = Constantes.REQUEST_PARAM_PAGE, required = false, defaultValue = "0") Integer page,
                                @RequestParam(name = Constantes.REQUEST_PARAM_SIZE, required = false, defaultValue = "0") Integer size) {

        Page<Coche> cochesEntidades = cocheService.findAll(page, size);
        return cochesEntidades.map(x -> cocheMapperService.mapEntityToDto(x));
    }

    @PostMapping
    /**
     * Inserta el coche a partir de un DTO. Devuelve error si la id del objeto a insertar ya existe
     * @param dto Coche a insertar
     * @return Respuesta con el servidor junto con el coche creado con su nueva id. (Codigos: 201, 400)
     * */
    public ResponseEntity<Car> insertCoche (@RequestBody Car dto) {
        Optional<Coche> coche = Optional.of(dto)
                .map(cocheMapperService::mapDtoToEntity)
                .map(v -> v.getId())
                .flatMap(cocheService::findById);

        if (coche.isPresent())
            return ResponseEntity.badRequest().build();

        return Optional.of(dto)
                .map(cocheMapperService::mapDtoToEntity)
                .map(cocheService::create)
                .map(cocheMapperService::mapEntityToDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    @PutMapping
    /**
     * Actualiza el coche a partir de otro DTO. Devuelve error si el objeto a actualizar no existe
     * @param dto Coche a actualizar
     * @return Respuesta con el servidor junto con el coche actualizado. (Codigos: 200, 404)
     * */
    public ResponseEntity<? extends Car> updateCoche (@RequestBody Car dto) {
        Optional<Coche> coche = Optional.of(dto)
                .map(cocheMapperService::mapDtoToEntity)
                .map(v -> v.getId())
                .flatMap(cocheService::findById);

        if (!coche.isPresent())
            return ResponseEntity.notFound().build();

        return Optional.of(dto)
                .map(cocheMapperService::mapDtoToEntity)
                .map(cocheService::update)
                .map(cocheMapperService::mapEntityToDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping (value = Constantes.URL_BY_ID)
    /**
     * Elimina el coche a partir de su ID. Devuelve error si el objeto a eliminar no existe
     * @param id ID del coche a eliminar
     * @return Respuesta con el servidor junto con el coche actualizado. (Codigos: 200, 400)
     * */
    public ResponseEntity<? extends Car> deleteBook (@PathVariable Integer id) throws NotFoundException {
        Optional<ResponseEntity> response = Optional.of(id)
                .map(ResponseEntity::ok);

        if (response.isPresent())
            return ResponseEntity.badRequest().build();

        cocheService.delete(id);

        return response.orElse(ResponseEntity.badRequest().build());
    }
}