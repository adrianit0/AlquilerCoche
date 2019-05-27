package com.example.app.DTO;

import lombok.Data;

import java.sql.Date;

@Data
public class TarifaDTO {
    private Date fechaInicio;
    private Date fechaFin;
    private Double precio;
}
