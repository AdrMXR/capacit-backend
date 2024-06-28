package com.gestion.empleados.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RequestProjectDTO { 
	private String nombreProyecto;
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate fechaInicio;
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate fechaFin;
    private String estatus;
    private String nombreEmpleado;
    private String posicionEmpleado;
	
	public RequestProjectDTO(String nombreProyecto, LocalDate fechaInicio, LocalDate fechaFin, String estatus,
			String nombreEmpleado, String posicionEmpleado) {
		this.nombreProyecto = nombreProyecto;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.estatus = estatus;
		this.nombreEmpleado = nombreEmpleado;
		this.posicionEmpleado =posicionEmpleado;
	}
	
	public RequestProjectDTO() {
		
	}

	public String getNombreProyecto() {
		return nombreProyecto;
	}

	public void setNombreProyecto(String nombreProyecto) {
		this.nombreProyecto = nombreProyecto;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getNombreEmpleado() {
		return nombreEmpleado;
	}

	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}

	public String getPosicionEmpleado() {
		return posicionEmpleado;
	}

	public void setPosicionEmpleado(String posicionEmpleado) {
		this.posicionEmpleado = posicionEmpleado;
	}
	
}
