package com.example.app.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Cliente {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String nombre;
	private String apellidos;
	
	private String dni;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
	private Set<Alquiler> alquileres = new HashSet<Alquiler>();
}
