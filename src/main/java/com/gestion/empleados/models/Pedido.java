package com.gestion.empleados.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "order_date", nullable = false)
    private LocalDate fecha;

    @Column(name = "order_status", length = 60, nullable = false)
    private String estado;

    @Column(name = "order_total", nullable = false)
    private BigDecimal total;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Empleado empleado;

    public Pedido(Long id, LocalDate fecha, String estado, BigDecimal total, Cliente cliente, Empleado empleado) {
        this.id = id;
        this.fecha = fecha;
        this.estado = estado;
        this.total = total;
        this.cliente = cliente;
        this.empleado = empleado;
    }

    public Pedido() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}