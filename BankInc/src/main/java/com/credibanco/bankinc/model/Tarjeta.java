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
import jakarta.persistence.Query;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Size;

@Entity
@Table(uniqueConstraints = {
		   @UniqueConstraint(name = "UniqueNumber", columnNames = {"numeroTarjeta"})})
public class Tarjeta {
	
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idTarjeta;
    
    @Size(min=16,max = 16, message="Campo requerido, longitud 16")
    private String numeroTarjeta;
    

    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="idCliente")
    private Cliente cliente;
    
    @Column(name = "fechaExpedicion", columnDefinition = "TIMESTAMP")
    private LocalDateTime fechaExpedicion;
    
    @Column(name = "fechaVencimiento", columnDefinition = "TIMESTAMP")
    private LocalDateTime fechaVencimiento;
    
    private String estadoTarjeta;
    
    @Column(columnDefinition = "varchar(255) default 'USD'")
    private String tipoMoneda;
    
    private Double saldoTarjeta;

    
	public Tarjeta() {
	}

    public Tarjeta(String numeroTarjeta) {
    	this.numeroTarjeta =  numeroTarjeta;
    }
	
	public Tarjeta(Cliente cliente, LocalDateTime fechaExpedicion, LocalDateTime fechaVencimiento, String estadoTarjeta,
			Double saldoTarjeta) {
		super();
		this.cliente = cliente;
		this.fechaExpedicion = fechaExpedicion;
		this.fechaVencimiento = fechaVencimiento;
		this.estadoTarjeta = estadoTarjeta;
		this.saldoTarjeta = saldoTarjeta;
	}
	



	public Long getIdTarjeta() {
		return idTarjeta;
	}

	public void setIdTarjeta(Long idTarjeta) {
		this.idTarjeta = idTarjeta;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}


	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public LocalDateTime getFechaExpedicion() {
		return fechaExpedicion;
	}


	public void setFechaExpedicion(LocalDateTime fechaExpedicion) {
		this.fechaExpedicion = fechaExpedicion;
	}


	public LocalDateTime getFechaVencimiento() {
		return fechaVencimiento;
	}


	public void setFechaVencimiento(LocalDateTime fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}


	public String getEstadoTarjeta() {
		return estadoTarjeta;
	}



	public void setEstadoTarjeta(String estadoTarjeta) {
		this.estadoTarjeta = estadoTarjeta;
	}



	public Double getSaldoTarjeta() {
		return saldoTarjeta;
	}



	public void setSaldoTarjeta(Double saldoTarjeta) {
		this.saldoTarjeta = saldoTarjeta;
	}

	
	public String getTipoMoneda() {
		return tipoMoneda;
	}

	public void setTipoMoneda(String tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
	}

	@Override
	public String toString() {
		return "Tarjeta [idTarjeta=" + idTarjeta + ", numeroTarjeta=" + numeroTarjeta + ", cliente=" + cliente
				+ ", fechaExpedicion=" + fechaExpedicion + ", fechaVencimiento=" + fechaVencimiento + ", estadoTarjeta="
				+ estadoTarjeta + ", tipoMoneda=" + tipoMoneda + ", saldoTarjeta=" + saldoTarjeta + "]";
	}
	
	

    
	 
}
