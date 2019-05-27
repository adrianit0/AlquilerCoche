package com.example.app.DTO;

import lombok.Data;

import java.sql.Date;

@Data
public class AlquilerDTO {
    private Date fechaInicio;
    private Date fechaFin;
    private Double precioTarifa;
    private Double precioFinal;
}
