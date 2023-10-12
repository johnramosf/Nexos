package com.credibanco.bankinc.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.credibanco.bankinc.model.Tarjeta;

@Repository
public interface TarjetaDAO extends CrudRepository<Tarjeta, Long> {
	
	
	@Query("SELECT t.idTarjeta FROM Tarjeta t WHERE t.numeroTarjeta = :numeroTarjeta")
	Long findTarjetaPorNumero(@Param("numeroTarjeta") String numeroTarjeta);
	

}
