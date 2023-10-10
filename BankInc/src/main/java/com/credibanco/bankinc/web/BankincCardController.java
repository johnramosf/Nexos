package com.credibanco.bankinc.web;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@RestController
@RequestMapping("/card")
public class BankincCardController {
	
	
	
	@GetMapping("/{productId}/number")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response generarNumeroTarjeta(){
		
    return null;		
	}
	
	
	
	@PostMapping("/enroll")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response activarTarjeta(){		
	
		return null;
	}
	
	
	
	@DeleteMapping (path ="/{cardId}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response bloquearTarjeta(@RequestParam("id") String id)
	{
		return null;
	}
	
	
	
	@PostMapping("/card/balance")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response recargaSaldo() {
		return null;
	}
	
	
	
	@GetMapping("/card/balance/{cardId}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response getSaldo(@RequestParam("cardId") String id){
		return null;
	}
	
	

}
