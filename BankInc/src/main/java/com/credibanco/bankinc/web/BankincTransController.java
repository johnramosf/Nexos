package com.credibanco.bankinc.web;

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
@RequestMapping("/transaction")
public class BankincTransController {
	
	
  
	@PostMapping("/purchase")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response crearTransaccionCompra(@RequestParam("cardId") String cardId,@RequestParam("price") int precio){
		
		return null;
	}
	
	@GetMapping("/{transactionId}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response consultaTransaccion(@RequestParam("tranId") String tranId) {
		
		return null;
	}
	
	@PostMapping("/anulation")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response anularTransaccion(@RequestParam("tranId") String tranId) {
		return null;
	}
	
	

}
