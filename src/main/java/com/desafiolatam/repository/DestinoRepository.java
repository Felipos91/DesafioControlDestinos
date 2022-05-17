package com.desafiolatam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.desafiolatam.models.Destino;

@Repository
public interface DestinoRepository extends JpaRepository<Destino, Long>{

	
	@Query(value="SELECT * FROM destinos WHERE ciudad=?1",nativeQuery=true)
	Destino findByName(String ciudad);
	
}
