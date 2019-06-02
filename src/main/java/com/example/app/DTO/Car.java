package com.example.app.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    private Integer id;
    @NotNull
    private String carPlate;
    @NotNull
    private String registrationYear;
}
