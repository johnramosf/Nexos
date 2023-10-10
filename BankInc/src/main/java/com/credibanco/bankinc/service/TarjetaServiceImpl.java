package com.credibanco.bankinc.service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;

import com.credibanco.bankinc.model.Tarjeta;
import com.credibanco.bankinc.dao.TarjetaDAO;

public class TarjetaServiceImpl implements TarjetaService {

	
	@Autowired
	private TarjetaDAO tarjetaDao;
	
	
	
	@Override
	public List<Tarjeta> listarTarjetas() {
		return (List<Tarjeta>) tarjetaDao.findAll();
		
	}

	
	
	@Override
	public void guardar(Tarjeta tarjeta) {
	
		   tarjetaDao.save(tarjeta); 
	}

	
	
	@Override
	public void eliminar(Tarjeta tarjeta) {
		tarjetaDao.delete(tarjeta); 

	}

	
	
	@Override
	public Tarjeta encontrarTarjeta(Tarjeta tarjeta) {
		
		return tarjetaDao.findById(tarjeta.getIdTarjeta()).orElse(null);
	}
	
	private int generate6RandomDigits() {
		int i = ThreadLocalRandom.current().nextInt(100000, 1000000);
		return i;
	}

}