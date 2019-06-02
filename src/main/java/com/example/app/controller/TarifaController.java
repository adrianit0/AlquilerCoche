package com.example.app.controller;

import com.example.app.mapper.TarifaMapperService;
import com.example.app.repositorio.TarifaRepository;
import com.example.app.servicio.tarifa.TarifaService;
import com.example.app.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constantes.URL_TARIFA)
public class TarifaController {

    private @Autowired TarifaService tarifaService;
    private @Autowired TarifaMapperService tarifaMapperService;
}
