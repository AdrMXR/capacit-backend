package com.gestion.empleados.repositories;

import com.gestion.empleados.dto.ResponsePedidoDTO;
import com.gestion.empleados.models.Pedido;
import org.apache.coyote.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface PedidoRepositorio extends JpaRepository<Pedido, Long> {

    @Query(value = "SELECT new com.gestion.empleados.dto.ResponsePedidoDTO(p.id, p.fecha, p.estado, p.total, c.nombre, e.nombre) " +
            "FROM Pedido p " +
            "JOIN p.cliente c " +
            "JOIN p.empleado e")
    List<ResponsePedidoDTO> getPedidosWithClienteAndEmpleado();

    @Query(value = "SELECT new com.gestion.empleados.dto.ResponsePedidoDTO(p.id, p.fecha, p.estado, p.total, c.nombre, e.nombre) " +
            "FROM Pedido p " +
            "JOIN p.cliente c " +
            "JOIN p.empleado e WHERE p.id = :pedido_id")
    ResponsePedidoDTO getPedidosWithClienteAndEmpleadoById(@Param("pedido_id") Long pedido_id);

    @Query(value = "SELECT new com.gestion.empleados.dto.ResponsePedidoDTO(p.id, p.fecha, p.estado, p.total, c.nombre, e.nombre) " +
            "FROM Pedido p " +
            "JOIN p.cliente c " +
            "JOIN p.empleado e " +
            "WHERE (:clienteNombre IS NULL OR c.nombre = :clienteNombre) " +
            "AND (:empleadoNombre IS NULL OR e.nombre = :empleadoNombre) " +
            "AND (:precioTotalMin IS NULL OR p.total >= :precioTotalMin) " +
            "AND (:precioTotalMax IS NULL OR p.total <= :precioTotalMax) " +
            "AND (:fecha IS NULL OR p.fecha = :fecha) " +
            "AND (:status IS NULL OR p.estado = :status)")
    List<ResponsePedidoDTO> getPedidoByParams(@Param("clienteNombre") String clienteNombre,
                                      @Param("empleadoNombre") String empleadoNombre,
                                      @Param("precioTotalMin") BigDecimal precioTotalMin,
                                      @Param("precioTotalMax") BigDecimal precioTotalMax,
                                      @Param("fecha") LocalDate fecha,
                                      @Param("status") String status);
}
