package com.credibanco.bankinc.service;

import java.util.List;
import java.util.Optional;

import com.credibanco.bankinc.model.Tarjeta;

public interface TarjetaService {
	
	    public List<Tarjeta> listarTarjetas();
	    
	    public void guardar(Tarjeta tarjeta);
	    
	    public void eliminar(Tarjeta tarjeta);
	    
	    public Tarjeta encontrarPorNumeroTarjeta(String noTarjeta);
	    
	    public String generarNumeroTarjeta(int codigoTipoTarjeta);
	    
	    public Tarjeta activarTarjeta(String noTarjeta, Long idCliente);
	    

}
