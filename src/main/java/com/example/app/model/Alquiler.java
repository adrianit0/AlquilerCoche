package com.example.app.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Alquiler {
	@Id
	@GeneratedValue
	private Integer id;
	
	private Date fechaInicio;
	private Date fechaFin;
	private Double precio;
	private Double precioTarifa;
	
	@ManyToOne (fetch = FetchType.LAZY)
	private Coche coche;
	
	@ManyToOne (fetch = FetchType.LAZY)
	private Cliente cliente;
}
