package com.credibanco.bankinc.model;

public enum CodigoProducto {
	
	TARJETA_DEBITO(100001),
	TARJETA_CREDITO(200001);
	
	private final int valor;
	
	private CodigoProducto(int valor) {
		this.valor = valor;
		
	} 
	
	public int getValor() {
		return valor;
	}
	

}
