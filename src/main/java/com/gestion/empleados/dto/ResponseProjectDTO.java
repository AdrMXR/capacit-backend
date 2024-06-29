package com.gestion.empleados.dto;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
public class ResponseProjectDTO {
	private Long id;
	private String nombreProyecto;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate fechaInicio;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate fechaFin;
	private String estatus;
	private String nombreEmpleado;
	
	public ResponseProjectDTO() {
		
	}
	
	
	public ResponseProjectDTO(Long id, String nombreProyecto, LocalDate fechaInicio, LocalDate fechaFin, String estatus,
			String nombreEmpleado) {
		super();
		this.id = id;
		this.nombreProyecto = nombreProyecto;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.estatus = estatus;
		this.nombreEmpleado = nombreEmpleado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
}
