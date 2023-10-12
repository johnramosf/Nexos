package com.credibanco.bankinc.service;

import java.util.List;

import com.credibanco.bankinc.model.Transaccion;

public interface TransaccionService {
	
	    public List<Transaccion> listarTransacciones();
	    
	    public void guardar(Transaccion transaccion);
	    
	    public void eliminar(Transaccion transaccion);
	    
	    public Transaccion encontrarTransaccion(Long idTransaccion);

}
