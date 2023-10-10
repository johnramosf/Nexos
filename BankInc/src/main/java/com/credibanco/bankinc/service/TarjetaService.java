package com.credibanco.bankinc.service;

import java.util.List;

import com.credibanco.bankinc.model.Tarjeta;

public interface TarjetaService {
	
	    public List<Tarjeta> listarTarjetas();
	    
	    public void guardar(Tarjeta tarjeta);
	    
	    public void eliminar(Tarjeta tarjeta);
	    
	    public Tarjeta encontrarTarjeta(Tarjeta tarjeta);
	    

}
