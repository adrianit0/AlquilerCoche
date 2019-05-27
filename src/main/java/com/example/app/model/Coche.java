package com.example.app.model;

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
public class Coche {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String matricula;
	private String modelo;
	private String color;
	private Integer cilindradas;
	
	@ManyToMany (mappedBy = "coches", fetch = FetchType.LAZY)
	private Set<Tarifa> tarifas = new HashSet<Tarifa>();
	
}
