package com.example.app.DTO;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.sql.Date;

@Data
public class Rental {
    private Integer id;
    @NotNull
    private Car car;
    @NotNull
    private Client client;
    @NotNull
    private Double price;
    private String startDate;
    private String endDate;
}