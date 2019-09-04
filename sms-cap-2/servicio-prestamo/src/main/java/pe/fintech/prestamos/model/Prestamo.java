package pe.fintech.prestamos.model;

import java.math.BigDecimal;
import java.time.LocalDate;


public class Prestamo {
	
	private Integer codPrestamo;
	
	private LocalDate fechaSolicitud;
	
	private BigDecimal monto;
	
	private Integer codCliente;
	
	private Estado estado;
		
	public enum Estado {
		SOLICITADO, APROBADO, OTORGADO
	}
	
	public Prestamo() {
		
	}
	
	// Getters and Setters
	
	public Integer getCodPrestamo() {
		return codPrestamo;
	}

	public void setCodPrestamo(Integer codPrestamo) {
		this.codPrestamo = codPrestamo;
	}

	public LocalDate getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(LocalDate fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public Integer getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(Integer codCliente) {
		this.codCliente = codCliente;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public Prestamo withCodPrestamo(Integer codPrestamo) {
		this.setCodPrestamo(codPrestamo);
		return this;
	}
	
	public Prestamo withFechaSolicitud(LocalDate fechaSolicitud) {
		this.setFechaSolicitud(fechaSolicitud);
		return this;
	}
	
	public Prestamo withMonto(BigDecimal monto) {
		this.setMonto(monto);
		return this;
	}
	
	public Prestamo withCodCliente(Integer codCliente) {
		this.setCodCliente(codCliente);
		return this;
	}
	
	public Prestamo withEstado(Estado estado) {
		this.setEstado(estado);
		return this;
	}

}
