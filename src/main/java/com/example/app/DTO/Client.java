package com.example.app.DTO;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class Client {
    private Integer id;
    @NotNull
    private String dni;
    @NotNull
    private String name;
}
