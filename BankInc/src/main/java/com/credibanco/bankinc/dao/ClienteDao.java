package com.credibanco.bankinc.dao;

import org.springframework.data.repository.CrudRepository;

import com.credibanco.bankinc.model.Cliente;

public interface ClienteDao extends CrudRepository<Cliente, Long> {
	

}
