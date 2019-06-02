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
    public Page<Car> getCochesByMatricula (
                                @RequestParam(name = Constantes.REQUEST_PARAM_CARPLATE, required =  false, defaultValue = "") String matricula,
                                @RequestParam(name = Constantes.REQUEST_PARAM_PAGE, required = false, defaultValue = "0") Integer page,
                                @RequestParam(name = Constantes.REQUEST_PARAM_SIZE, required = false, defaultValue = "10") Integer size) {

        Page<Coche> cochesEntidades = cocheService.findByMatricula(matricula, page, size);
        return cochesEntidades.map(x -> cocheMapperService.mapEntityToDto(x));
    }

    @PostMapping
    /**
     * Inserta el coche a partir de un DTO. Devuelve error si la id del objeto a insertar ya existe
     * @param dto Coche a insertar
     * @return Respuesta con el servidor junto con el coche creado con su nueva id. (Codigos: 201, 400)
     * */
    public ResponseEntity<Car> insertCoche (@RequestBody Car dto) {
        // ID del coche, por si existe
        Optional<Integer> idCoche = Optional.of(dto)
                .map(cocheMapperService::mapDtoToEntity)
                .map(v -> v.getId());

        // Si existe el coche
        Boolean existe = idCoche
                .map(cocheService::existsById)
                .orElse(false);

        if (idCoche.isPresent() && existe)
            return ResponseEntity.badRequest().build();

        return Optional.of(dto)
                .map(cocheMapperService::mapDtoToEntity)
                .map(cocheService::create)
                .map(cocheMapperService::mapEntityToDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping (value = Constantes.URL_BY_ID)
    /**
     * Actualiza el coche a partir de otro DTO. Devuelve error si el objeto a actualizar no existe
     * @param dto Coche a actualizar
     * @return Respuesta con el servidor junto con el coche actualizado. (Codigos: 200, 404)
     * */
    public ResponseEntity<? extends Car> updateCoche (@PathVariable("id") Integer id, @RequestBody Car dto) {
        Boolean existe = Optional.of(id)
                .map(cocheService::existsById)
                .orElse(false);

        if (!existe)
            return ResponseEntity.notFound().build();

        dto.setId(id);
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
    public ResponseEntity<? extends Car> deleteCar (@PathVariable Integer id) throws NotFoundException {
        Boolean existe = Optional.of(id)
                .map(cocheService::existsById)
                .orElse(false);

        if (!existe)
            return ResponseEntity.badRequest().build();

        cocheService.delete(id);

        return ResponseEntity.ok().build();
    }
}