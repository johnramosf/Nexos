package com.credibanco.bankinc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.credibanco.bankinc.model.CodigoProducto;
import com.credibanco.bankinc.service.TarjetaService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@RestController
@RequestMapping("/")
public class Prueba {
	
	@Autowired
	TarjetaService tjs;

    @GetMapping("/prueba")
	public String pruebaMess() {
    	System.out.println("CodigoProducto: "+CodigoProducto.TARJETA_CREDITO.getValor());
    	String mensaje= tjs.generarNumeroTarjeta(CodigoProducto.TARJETA_CREDITO.getValor());
    	
    	return mensaje; 	
    } 
	

}
