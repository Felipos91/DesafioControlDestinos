package com.desafiolatam.models;

import java.util.Date;
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

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="destinos")

public class Destino {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="pasajeros_destinos",
			joinColumns=@JoinColumn(name="destino_id"),
			inverseJoinColumns=@JoinColumn(name="pasajero_id"))
	public List<Pasajero> pasajeros;
	

	private String ciudad;
	private String pais;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fecha;
	
	public Destino() {
		super();
	}
	
	
	public Destino(String ciudad, String pais, Date fecha,List<Pasajero> pasajeros) {
		super();
		this.pasajeros = pasajeros;
		this.ciudad = ciudad;
		this.pais = pais;
		this.fecha = fecha;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public List<Pasajero> getPasajeros() {
		return pasajeros;
	}


	public void setPasajeros(List<Pasajero> pasajeros) {
		this.pasajeros = pasajeros;
	}


	public String getCiudad() {
		return ciudad;
	}


	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}


	public String getPais() {
		return pais;
	}


	public void setPais(String pais) {
		this.pais = pais;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
