package com.gestion.empleados.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ResponsePedidoDTO {
    private Long id;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate fecha;
    private String estado;
    private BigDecimal total;
    private String nombreCliente;
    private String nombreEmpleado;

    public ResponsePedidoDTO() {
    }

    public ResponsePedidoDTO(Long id, LocalDate fecha, String estado, BigDecimal total, String nombreCliente, String nombreEmpleado) {
        this.id = id;
        this.fecha = fecha;
        this.estado = estado;
        this.total = total;
        this.nombreCliente = nombreCliente;
        this.nombreEmpleado = nombreEmpleado;
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

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }
}
