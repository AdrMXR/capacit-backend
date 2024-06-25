package com.gestion.empleados.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public class RequestPedidoDTO {
    private String clienteNombre;
    private String empleadoNombre;
    private BigDecimal precioTotalMin;
    private BigDecimal precioTotalMax;
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate fecha;
    private String status;

    public RequestPedidoDTO() {
    }

    public RequestPedidoDTO(String clienteNombre, String empleadoNombre, BigDecimal precioTotalMin,
                            BigDecimal precioTotalMax, LocalDate fecha, String status) {
        this.clienteNombre = clienteNombre;
        this.empleadoNombre = empleadoNombre;
        this.precioTotalMin = precioTotalMin;
        this.precioTotalMax = precioTotalMax;
        this.fecha = fecha;
        this.status = status;
    }

    // Getters and Setters

    public String getClienteNombre() {
        return clienteNombre;
    }

    public void setClienteNombre(String clienteNombre) {
        this.clienteNombre = clienteNombre;
    }

    public String getEmpleadoNombre() {
        return empleadoNombre;
    }

    public void setEmpleadoNombre(String empleadoNombre) {
        this.empleadoNombre = empleadoNombre;
    }

    public BigDecimal getPrecioTotalMin() {
        return precioTotalMin;
    }

    public void setPrecioTotalMin(BigDecimal precioTotalMin) {
        this.precioTotalMin = precioTotalMin;
    }

    public BigDecimal getPrecioTotalMax() {
        return precioTotalMax;
    }

    public void setPrecioTotalMax(BigDecimal precioTotalMax) {
        this.precioTotalMax = precioTotalMax;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
