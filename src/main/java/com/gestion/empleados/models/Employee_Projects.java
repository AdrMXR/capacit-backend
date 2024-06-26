package com.gestion.empleados.models;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table (name = "employee_proyects")
public class Employee_Projects implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proyects")
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "id_employee")
	private Long employee;
	
	@Column(name = "nombre_proyecto",length = 255, nullable = false)
	private String nombre;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "fecha_inicio", nullable = false)
	private LocalDate fecha_inicio;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "fecha_fin", nullable = false)
	private LocalDate fecha_fin;
	
	@Column(name = "estatus",length = 50, nullable = false)
	private String Estatus;

	public Employee_Projects(Long id, Long employee, String nombre, LocalDate fecha_inicio, LocalDate fecha_fin,
			String estatus) {
		super();
		this.id = id;
		this.employee = employee;
		this.nombre = nombre;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		Estatus = estatus;
	}
	
	public Employee_Projects() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEmployee() {
		return employee;
	}

	public void setEmployee(Long employee) {
		this.employee = employee;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(LocalDate fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public LocalDate getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(LocalDate fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public String getEstatus() {
		return Estatus;
	}

	public void setEstatus(String estatus) {
		Estatus = estatus;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
