package com.example.app.DTO;

import lombok.Data;

import javax.validation.constraints.*;
import java.sql.Date;

@Data
public class Rate {
    private Integer id;
    @Min(0)
    private Double price;
    private String startDate;
    private String endDate;
}
