package com.credibanco.bankinc.service;

import java.util.List;
import java.util.Optional;

import com.credibanco.bankinc.model.Tarjeta;

public interface TarjetaService {
	
	    public List<Tarjeta> listarTarjetas();
	    
	    public Tarjeta guardar(Tarjeta tarjeta);
	    
	    public Tarjeta eliminar(String noTarjeta);
	    
	    public Tarjeta encontrarPorNumeroTarjeta(String noTarjeta);
	    
	    public String generarNumeroTarjeta(int codigoTipoTarjeta);
	    
	    public Tarjeta activarTarjeta(String noTarjeta, Long idCliente);
	    

}
