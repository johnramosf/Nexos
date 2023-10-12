package com.credibanco.bankinc.web;


public class CardResponseError {
  
	
	private int estado;
	
	private String descripcion;
	
	private long timeStamp;

	
	public CardResponseError() {
		super();
	}

	
	public CardResponseError(int estado, String descripcion, long timeStamp) {
		super();
		this.estado = estado;
		this.descripcion = descripcion;
		this.timeStamp = timeStamp;
	}


	public int getEstado() {
		return estado;
	}


	public void setEstado(int estado) {
		this.estado = estado;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public long getTimeStamp() {
		return timeStamp;
	}


	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	

}
