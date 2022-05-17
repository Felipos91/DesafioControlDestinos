package com.desafiolatam.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="pasajeros")

public class Pasajero {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String rut;
	private String nombre;
	private String apellido;
	private Integer edad;
	private String ciudadNatal;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="pasajeros_destinos",
			joinColumns=@JoinColumn(name="pasajero_id"),
			inverseJoinColumns=@JoinColumn(name="destino_id"))
	private List<Destino> destinos;

	public Pasajero() {
		super();
	}

	public Pasajero(String rut, String nombre, String apellido, Integer edad, String ciudadNatal) {
		super();
		this.rut = rut;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.ciudadNatal = ciudadNatal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getCiudadNatal() {
		return ciudadNatal;
	}

	public void setCiudadNatal(String ciudadNatal) {
		this.ciudadNatal = ciudadNatal;
	}

	public List<Destino> getDestinos() {
		return destinos;
	}

	public void setDestinos(List<Destino> destinos) {
		this.destinos = destinos;
	}
	
	
	
}
