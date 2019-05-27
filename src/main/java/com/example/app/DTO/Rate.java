package com.example.app.DTO;

import lombok.Data;

import java.sql.Date;

@Data
public class Rate {
    private Integer id;
    private Double price;
    private String startDate;
    private String endDate;
}
