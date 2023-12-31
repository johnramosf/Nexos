package com.credibanco.bankinc.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.credibanco.bankinc.model.Cliente;
import com.credibanco.bankinc.model.CodigoProducto;
import com.credibanco.bankinc.model.Tarjeta;
import com.credibanco.bankinc.model.exceptions.GestionTarjetaException;
import com.credibanco.bankinc.model.exceptions.GestionTarjetaException2;
import com.credibanco.bankinc.model.exceptions.CardGestionError;
import com.credibanco.bankinc.service.TarjetaService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.JsonNode;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@RestController
@RequestMapping("/card")
public class BankincCardController {
	
	@Autowired
	private TarjetaService tarjetaService;
		
	@GetMapping("/{productId}/number")
	public Tarjeta generarNumeroTarjeta(@PathVariable String productId){
		int intProductId=0; 		
		try {
			intProductId = Integer.parseInt(productId);
		}catch(NumberFormatException e) {
			throw new GestionTarjetaException("El párametro productId no tiene el formato adecuado: entero", e);
		}
		
		if(!(intProductId>=0 && intProductId<2)) {
			throw new GestionTarjetaException("El párametro productId debe corresponder al tipo de Tarjeta: '1' - Debito, '2' - crédito");
		}
		Tarjeta generada = null;
		String numeroTarjeta;
		int codProducto = 0;
		
		if(intProductId==1) {
			codProducto = CodigoProducto.TARJETA_DEBITO.getValor();
		}
		else if (intProductId==2) {
			codProducto = CodigoProducto.TARJETA_CREDITO.getValor();
		}
		
		numeroTarjeta = tarjetaService.generarNumeroTarjeta(codProducto);
		generada = tarjetaService.encontrarPorNumeroTarjeta(numeroTarjeta);
		
		return generada;
	}
	
	
	
	@PostMapping("/enroll")
	public Tarjeta activarTarjeta(@RequestBody Tarjeta tarjeta){		
		Tarjeta generada = null; 
		String numeroTarjeta; 
		Long noTarjeta;
		Long noCliente;
		try {
			
			numeroTarjeta = tarjeta.getNumeroTarjeta();
			noCliente = tarjeta.getCliente().getIdCliente();
			generada = tarjetaService.encontrarPorNumeroTarjeta(numeroTarjeta);
			if(generada==null) {
				throw new GestionTarjetaException2("El número de tarjeta ingresada no existe");	
			}
			noTarjeta = generada.getIdTarjeta();
			
		}catch(NumberFormatException e) {
			throw new GestionTarjetaException("Los párametros cardId(entero 16), o clienteId(entero) no tienen el formato adecuado: ", e);
		}
		
		Tarjeta aGenerar = tarjetaService.activarTarjeta(generada.getNumeroTarjeta(), noCliente);
		return aGenerar;	
	}
	
	
	
	
	@DeleteMapping (path ="/{cardId}")
	public Tarjeta bloquearTarjeta(@PathVariable String cardId)
	{
		Tarjeta aBloquear = null;
		String numeroTarjeta;
		Long longTarjeta = null;    
		try {
		longTarjeta= Long.getLong(cardId);	
		aBloquear = tarjetaService.encontrarPorNumeroTarjeta(cardId);
		if(aBloquear==null) {
			throw new GestionTarjetaException2("El número de tarjeta ingresada no existe");
		}
		
		} catch(NumberFormatException e) {
			throw new GestionTarjetaException("El párametro cardId(entero 16) no tiene el formato adecuado: ", e);
		} 
		
		aBloquear = tarjetaService.eliminar(cardId);
		
		return aBloquear;
	}
	
	@PostMapping("/card/balance")
	public Response recargaSaldo() {
		return null;
	}
	
	
	
	@GetMapping("/card/balance/{cardId}")
	public Response getSaldo(@RequestParam("cardId") String id){
		return null;
	}
	
	
	@ExceptionHandler
	ResponseEntity<CardGestionError> manejoExcepcion(GestionTarjetaException ex){
		
		CardGestionError errorTarjeta = new CardGestionError();
		
		errorTarjeta.setEstado(HttpStatus.BAD_REQUEST.value());
		
		errorTarjeta.setMensaje(ex.getMessage());
		
		errorTarjeta.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(errorTarjeta,HttpStatus.BAD_REQUEST);
		
	}  
	
	@ExceptionHandler
	ResponseEntity<CardGestionError> manejoExcepcion(GestionTarjetaException2 ex){
		
		CardGestionError errorTarjeta = new CardGestionError();
		
		errorTarjeta.setEstado(HttpStatus.NOT_FOUND.value());
		
		errorTarjeta.setMensaje(ex.getMessage());
		
		errorTarjeta.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(errorTarjeta,HttpStatus.NOT_FOUND);
		
	} 
	
	

}
