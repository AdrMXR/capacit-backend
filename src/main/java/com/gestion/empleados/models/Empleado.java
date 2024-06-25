package com.gestion.empleados.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "employees")
public class Empleado implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long id;

    @Column(name = "employee_name", length = 60, nullable = false)
    private String nombre;

    @Column(name = "employee_position", length = 60, nullable = false)
    private String cargo;

    @Column(name = "employee_salary", nullable = false)
    private Double salario;

    @Column(name = "employee_rfc", unique = true, nullable = false)
    private String rfc;

    public Empleado () {

    }

    public Empleado(Long id, String nombre, String cargo, Double salario, String rfc) {
        this.id = id;
        this.nombre = nombre;
        this.cargo = cargo;
        this.salario = salario;
        this.rfc = rfc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }
}
