package com.desafiolatam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiolatam.models.PasajeroDestino;
import com.desafiolatam.repository.PasajeroDestinoRepository;

@Service
public class PasajeroDestinoService {

	@Autowired
	PasajeroDestinoRepository pasajeroDestinoRepository;

	public void save(PasajeroDestino pasajeroDestino) {
		pasajeroDestinoRepository.save(pasajeroDestino);
		
	}
//Al realizar la consulta de una entidad que no está presente en la base de datos mediante findbyId con el método get
	//arrojaba error de que no existía valor. No servía para validar en el controlador ya que no no llegaba como nulo.
	public PasajeroDestino findyId(Long pasajeroId) {	
		return pasajeroDestinoRepository.findByPasajeroId(pasajeroId);
	}
	public List<PasajeroDestino> findAll() {
		
		return pasajeroDestinoRepository.findAll();
	}
	
}
