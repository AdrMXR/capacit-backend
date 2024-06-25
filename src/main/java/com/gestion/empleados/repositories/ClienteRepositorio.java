package com.gestion.empleados.repositories;

import com.gestion.empleados.models.Cliente;
import com.gestion.empleados.models.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {
    @Query(value = "SELECT * FROM clients WHERE client_email LIKE CONCAT('%', :dominio)", nativeQuery = true)
    List<Cliente> getClientesByCorreoDominio(@Param("dominio") String dominio);

    @Query(value = "SELECT c.*\n" +
            "FROM clients c\n" +
            "WHERE c.client_id = (\n" +
            "    SELECT client_id\n" +
            "    FROM orders\n" +
            "    GROUP BY client_id\n" +
            "    ORDER BY COUNT(*) DESC\n" +
            "    FETCH FIRST 1 ROW ONLY\n" +
            ")", nativeQuery = true)
    Cliente getClienteWithMayorPedidos();
}
