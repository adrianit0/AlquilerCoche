package com.example.app.controller;

import com.example.app.mapper.AlquilerMapperService;
import com.example.app.repositorio.AlquilerRepository;
import com.example.app.servicio.alquiler.AlquilerService;
import com.example.app.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constantes.URL_ALQUILER)
public class AlquilerController {

    private @Autowired AlquilerService alquilerService;
    private @Autowired AlquilerMapperService alquilerMapperService;

}

