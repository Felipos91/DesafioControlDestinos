package com.desafiolatam.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pasajeros_destinos")

public class PasajeroDestino {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="destino_id")
	private Destino destino;
	
	
	@ManyToOne
	@JoinColumn(name="pasajero_id")
	private Pasajero pasajero;
	
	public PasajeroDestino() {
		super();
	}
	
	public PasajeroDestino(Destino destino, Pasajero pasajero) {
		super();
		this.destino = destino;
		this.pasajero = pasajero;
	}

	public PasajeroDestino(Long id, Destino destino, Pasajero pasajero) {
		super();
		Id = id;
		this.destino = destino;
		this.pasajero = pasajero;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Destino getDestino() {
		return destino;
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
	}

	public Pasajero getPasajero() {
		return pasajero;
	}

	public void setPasajero(Pasajero pasajero) {
		this.pasajero = pasajero;
	}
	
	
	
	
}
