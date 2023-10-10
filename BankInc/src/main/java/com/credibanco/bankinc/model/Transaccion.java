package com.credibanco.bankinc.model;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Transaccion {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="idTarjeta")
	private Tarjeta tarjeta;
	
	@Column(name = "fechaTransaccion", columnDefinition = "TIMESTAMP")
	private LocalDateTime fechaTransaccion;
	
	@Column(name = "fechaActualizacion", columnDefinition = "TIMESTAMP")
	private LocalDateTime fechaActualizacion;
	
	private Double montoTransaccion;
	
	private String estadoTransaccion;
	
	
	public Transaccion() {
	}

	
	public Transaccion(Tarjeta tarjeta, LocalDateTime fechaTransaccion, LocalDateTime fechaActualizacion,
			Double montoTransaccion, String estadoTransaccion) {
		super();
		this.tarjeta = tarjeta;
		this.fechaTransaccion = fechaTransaccion;
		this.fechaActualizacion = fechaActualizacion;
		this.montoTransaccion = montoTransaccion;
		this.estadoTransaccion = estadoTransaccion;
	}






	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Tarjeta getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}

	public LocalDateTime getFechaTransaccion() {
		return fechaTransaccion;
	}

	public void setFechaTransaccion(LocalDateTime fechaTransaccion) {
		this.fechaTransaccion = fechaTransaccion;
	}

	public LocalDateTime getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public Double getMontoTransaccion() {
		return montoTransaccion;
	}

	public void setMontoTransaccion(Double montoTransaccion) {
		this.montoTransaccion = montoTransaccion;
	}

	public String getEstadoTransaccion() {
		return estadoTransaccion;
	}

	public void setEstadoTransaccion(String estadoTransaccion) {
		this.estadoTransaccion = estadoTransaccion;
	}


	
	@Override
	public String toString() {
		return "Transaccion [id=" + id + ", tarjeta=" + tarjeta + ", fechaTransaccion=" + fechaTransaccion
				+ ", fechaActualizacion=" + fechaActualizacion + ", montoTransaccion=" + montoTransaccion
				+ ", estadoTransaccion=" + estadoTransaccion + "]";
	}
		
}
