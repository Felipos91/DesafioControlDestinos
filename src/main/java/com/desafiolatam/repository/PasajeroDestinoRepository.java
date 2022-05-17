package com.desafiolatam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.desafiolatam.models.PasajeroDestino;

@Repository
public interface PasajeroDestinoRepository extends JpaRepository<PasajeroDestino, Long>{

	
	@Query(value="SELECT * FROM pasajeros_destinos WHERE pasajero_id=?1",nativeQuery=true)
	PasajeroDestino findByPasajeroId(Long pasajeroId);

}
