package com.desafiolatam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiolatam.models.Pasajero;
import com.desafiolatam.repository.PasajeroRepository;

@Service
public class PasajeroService {

	@Autowired
	PasajeroRepository pasajeroRepository;

	public void save(Pasajero pasajero) {
		 pasajeroRepository.save(pasajero);
		
	}

	public List<Pasajero> findAll() {
		return pasajeroRepository.findAll();
	}

	public Pasajero findById(Long pasajeroId) {
		
		return pasajeroRepository.getById(pasajeroId);
	}
	
	
	
}
