package com.credibanco.bankinc.dao;

import org.springframework.data.repository.CrudRepository;

import com.credibanco.bankinc.model.Transaccion;

public interface TransaccionDAO extends CrudRepository<Transaccion,Long> {

}
