package com.example.app.DTO;

import lombok.Data;

import java.sql.Date;

@Data
public class Rental {
    private Integer id;
    private Car car;
    private Client client;
    private Double price;
    private String startDate;
    private String endDate;
}