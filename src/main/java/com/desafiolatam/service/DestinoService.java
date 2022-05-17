package com.desafiolatam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiolatam.models.Destino;
import com.desafiolatam.repository.DestinoRepository;

@Service
public class DestinoService {

	@Autowired
	DestinoRepository destinoRepository;
	
	public void save(Destino destino) {
		
		destinoRepository.save(destino);
		
	}

	public List<Destino> findAll() {
		
		return destinoRepository.findAll();
	}

	public Destino findByName(String ciudad) {
		
		return destinoRepository.findByName(ciudad);
	}

}
