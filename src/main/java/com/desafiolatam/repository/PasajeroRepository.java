package com.desafiolatam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafiolatam.models.Pasajero;

@Repository
public interface PasajeroRepository extends JpaRepository<Pasajero, Long>{

}
