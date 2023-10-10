package com.credibanco.bankinc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.credibanco.bankinc.model.Transaccion;

import com.credibanco.bankinc.dao.TransaccionDAO;

public class TransaccionServiceImpl implements TransaccionService {

    
	@Autowired
    private TransaccionDAO transaccionDao;
	
	
	@Override
	public List<Transaccion> listarTransacciones() {
		return (List<Transaccion>)transaccionDao.findAll() ;
	}
	
	
	@Override
	public void guardar(Transaccion transaccion) {
              
		transaccionDao.save(transaccion);

	}

	@Override
	public void eliminar(Transaccion transaccion) {
		
		transaccionDao.delete(transaccion);

	}

	@Override
	public Transaccion encontrarTransaccion(Transaccion transaccion) {
		
		return transaccionDao.findById(transaccion.getId()).orElse(null);
	}
	


}


