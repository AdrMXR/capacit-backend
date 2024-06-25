package com.gestion.empleados.repositories;

import com.gestion.empleados.models.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepositorio extends JpaRepository<Empleado, Long> {

    @Query(value = "SELECT * FROM employees WHERE employee_salary > :salario", nativeQuery = true)
    List<Empleado> getEmpleadosWithMayorSalario(@Param("salario") Double salario);

    @Query(value = "SELECT * FROM employees WHERE employee_salary < :salario", nativeQuery = true)
    List<Empleado> getEmpleadosWithMenorSalario(@Param("salario") Double salario);

    @Query(value = "SELECT e.*\n" +
            "FROM employees e\n" +
            "WHERE e.employee_id = (\n" +
            "    SELECT employee_id\n" +
            "    FROM orders\n" +
            "    GROUP BY employee_id\n" +
            "    ORDER BY COUNT(*) DESC\n" +
            "    FETCH FIRST 1 ROW ONLY\n" +
            ")", nativeQuery = true)
    Empleado getEmpleadoWithMayorPedidos();

    @Query(value = "SELECT * FROM employees WHERE LENGTH(employee_rfc) = 13", nativeQuery = true)
    List<Empleado> getEmpleadosFisicos();

    @Query(value = "SELECT * FROM employees WHERE LENGTH(employee_rfc) = 12", nativeQuery = true)
    List<Empleado> getEmpleadosMorales();
}
