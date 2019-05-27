package com.example.app.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity
public class Tarifa {
	@Id
	@GeneratedValue
	private Integer id;
	
	private Date fechaInicio;
	private Date fechaFin;
	private Double precio;
	
	@ManyToMany (fetch = FetchType.LAZY)
	private Set<Coche> coches = new HashSet<Coche>();
}
