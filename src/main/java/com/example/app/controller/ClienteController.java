package com.example.app.controller;

import com.example.app.DTO.Client;
import com.example.app.mapper.ClienteMapperService;
import com.example.app.model.Cliente;
import com.example.app.servicio.cliente.ClienteService;
import com.example.app.util.Constantes;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(Constantes.URL_CLIENTE)
public class ClienteController {

    private @Autowired ClienteService clienteService;
    private @Autowired ClienteMapperService clienteMapperService;

    @GetMapping(value = Constantes.URL_BY_ID)
    public ResponseEntity<Client> getClienteById (@PathVariable(Constantes.PATH_PARAM_ID) Integer id) {
        return Optional.of(id)
                .flatMap(clienteService::findById)
                .map(clienteMapperService::mapEntityToDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    @ResponseBody
    public Page<Client> getClientes (
            @RequestParam(name = Constantes.REQUEST_PARAM_PAGE, required = false, defaultValue = "0") Integer page,
            @RequestParam(name = Constantes.REQUEST_PARAM_SIZE, required = false, defaultValue = "10") Integer size) {

        Page<Cliente> clientes = clienteService.findAll(page, size);
        return clientes.map(x -> clienteMapperService.mapEntityToDto(x));
    }
    @PostMapping
    public ResponseEntity<Client> insertCliente (@Valid @RequestBody Client dto) {
        // ID del coche, por si existe
        Optional<Integer> idCliente = Optional.of(dto)
                .map(clienteMapperService::mapDtoToEntity)
                .map(v -> v.getId());

        // Si existe el coche
        Boolean existe = idCliente
                .map(clienteService::existsById)
                .orElse(false);

        if (idCliente.isPresent() && existe)
            return ResponseEntity.badRequest().build();

        return Optional.of(dto)
                .map(clienteMapperService::mapDtoToEntity)
                .map(clienteService::create)
                .map(clienteMapperService::mapEntityToDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    @PutMapping (value = Constantes.URL_BY_ID)
    @SuppressWarnings("Duplicates")
    public ResponseEntity<? extends Client> updateCliente (@PathVariable("id") Integer id, @Valid @RequestBody Client dto) {
        boolean existe = Optional.of(id)
                .map(clienteService::existsById)
                .orElse(false);

        if (!existe)
            return ResponseEntity.notFound().build();

        dto.setId(id);
        clienteService.update(clienteMapperService.mapDtoToEntity(dto));

        return ResponseEntity.ok().build();
    }

    @DeleteMapping (value = Constantes.URL_BY_ID)
    public ResponseEntity<? extends Client> deleteCliente (@PathVariable Integer id) {
        Boolean existe = Optional.of(id)
                .map(clienteService::existsById)
                .orElse(false);

        if (!existe)
            return ResponseEntity.badRequest().build();

        clienteService.delete(id);

        return ResponseEntity.ok().build();
    }
}