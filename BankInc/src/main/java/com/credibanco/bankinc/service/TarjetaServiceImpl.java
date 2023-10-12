package com.credibanco.bankinc.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credibanco.bankinc.model.Cliente;
import com.credibanco.bankinc.model.EstadoTarjeta;
import com.credibanco.bankinc.model.Tarjeta;
import com.credibanco.bankinc.model.TipoMoneda;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import jakarta.transaction.Transactional;

import com.credibanco.bankinc.dao.ClienteDao;
import com.credibanco.bankinc.dao.TarjetaDAO;

@Service
public class TarjetaServiceImpl implements TarjetaService {

	
	@Autowired
	private TarjetaDAO tarjetaDao;
	
	@Autowired
	private ClienteDao clienteDao;
	
	
	
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
	
	
	
	
	public Tarjeta getTarjetaPorId(Long idtarjeta) {
		
		Optional<Tarjeta> optTarjeta = tarjetaDao.findById(idtarjeta);
		Tarjeta tarjeta = optTarjeta.get();
		return tarjeta;
		
	} 
	
	

	@Transactional
	public String generarNumeroTarjeta(int codigoTipoTarjeta) {
		   
		String noTarjeta = null;
		double zero=0.0;
		try {
			noTarjeta = ""+codigoTipoTarjeta;
			noTarjeta += generate10RandomDigits();
			System.out.println("Before: "+noTarjeta);
			Tarjeta nueva = new Tarjeta(noTarjeta);
			nueva.setSaldoTarjeta(zero);
			nueva.setTipoMoneda(TipoMoneda.USD.toString());
			nueva.setEstadoTarjeta(EstadoTarjeta.INACTIVA.toString());
			tarjetaDao.save(nueva);
			Tarjeta creada = encontrarPorNumeroTarjeta(noTarjeta);
			if(creada!=null) {
				return creada.getNumeroTarjeta(); 
			} else {
				noTarjeta = null;
			}					
		    System.out.println(noTarjeta);
		}catch(Exception e){
			e.printStackTrace();
		} 
		
		return noTarjeta;
	}
	
	

	
	
	
	
	 
	
	private String generate10RandomDigits() {
		
		String rndString = ""+ThreadLocalRandom.current().nextInt(1,10);
		rndString += ThreadLocalRandom.current().nextInt(100000000,1000000000);		
		return rndString;
	}

	
	


	@Override
	public Tarjeta encontrarPorNumeroTarjeta(String noTarjeta) {
		
		Long findedIdTarj = tarjetaDao.findTarjetaPorNumero(noTarjeta);
		return getTarjetaPorId(findedIdTarj); 
		
	}



	@Override
	@Transactional
	public Tarjeta activarTarjeta(String noTarjeta, Long idCliente) {
		Long idCard = tarjetaDao.findTarjetaPorNumero(noTarjeta);
		Tarjeta cardToActivate = getTarjetaPorId(idCard);
		Optional<Cliente> actualOpt = clienteDao.findById(idCliente).or(null);
		Cliente actual = actualOpt.get();
		cardToActivate.setCliente(actual);
		Date hoy = new Date();
		LocalDateTime ldt = LocalDateTime.of(hoy.getYear(),hoy.getMonth(),hoy.getHours(),hoy.getMinutes(),hoy.getSeconds());
		LocalDateTime ldtv = ldt.plusYears(3L); 
		cardToActivate.setFechaExpedicion(ldt);
		cardToActivate.setEstadoTarjeta(EstadoTarjeta.ACTIVA.toString());
		cardToActivate.setSaldoTarjeta(1000.0);
		return cardToActivate;
	}
	

}