package com.gestion.empleados.models;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table (name = "employee_projects")
public class Employee_Projects implements Serializable{
private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PROJECTS")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "EMPLOYEE_ID")
    private Empleado employee;
    
    @Column(name = "NOMBRE_PROYECTO", length = 255, nullable = false)
    private String nombreProyecto;
    
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "FECHA_INICIO", nullable = false)
    private LocalDate fechaInicio;
    
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "FECHA_FIN", nullable = false)
    private LocalDate fechaFin;
    
    @Column(name = "ESTATUS", length = 50, nullable = false)
    private String estatus;

    // Constructor, getters y setters
    public Employee_Projects() {}

	public Employee_Projects(Long id, Empleado employee, String nombreProyecto, LocalDate fechaInicio,
			LocalDate fechaFin, String estatus) {
		super();
		this.id = id;
		this.employee = employee;
		this.nombreProyecto = nombreProyecto;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.estatus = estatus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Empleado getEmployee() {
		return employee;
	}

	public void setEmployee(Empleado employee) {
		this.employee = employee;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
