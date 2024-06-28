package com.gestion.empleados.repositories;
import com.gestion.empleados.dto.*;
import com.gestion.empleados.models.*;
import org.apache.coyote.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;


@Repository
public interface ProjectRepositorio extends JpaRepository<Employee_Projects, Long>{
	
	//Query que devuelve todos los valores de la tabla Employee_projects
	@Query(value="SELECT * FROM employee_projects", nativeQuery=true)
	List<Employee_Projects> findAllProjects();
	
	//Query que busca a los proyectos por ID
	@Query("SELECT new com.gestion.empleados.dto.ResponseProjectDTO(p.id, p.nombreProyecto, p.fechaInicio, p.fechaFin, " +
	           "p.estatus, e.nombre) " +
	           "FROM Employee_Projects p JOIN p.employee e WHERE p.id = :id_project")
	    ResponseProjectDTO getProjectById(@Param("id_project") Long id_project);
	
	
	//Query que busca a todos los campos por campo
	@Query("SELECT new com.gestion.empleados.dto.ResponseProjectDTO(p.id, p.nombreProyecto, p.fechaInicio, p.fechaFin, " +
	           "p.estatus, e.nombre) " +
	           "FROM Employee_Projects p JOIN p.employee e " +
	           "WHERE (:nombreProyecto IS NULL OR p.nombreProyecto = :nombreProyecto) " +
	           "AND (:fechaInicio IS NULL OR p.fechaInicio = :fechaInicio) " +
	           "AND (:fechaFin IS NULL OR p.fechaFin = :fechaFin) " +
	           "AND (:estatus IS NULL OR p.estatus = :estatus) " +
	           "AND (:nombreEmpleado IS NULL OR e.nombre = :nombreEmpleado)")
	    List<ResponseProjectDTO> getEmployee_ProjectsByParams(@Param("nombreProyecto") String nombreProyecto,
	                                                          @Param("fechaInicio") LocalDate fechaInicio,
	                                                          @Param("fechaFin") LocalDate fechaFin,
	                                                          @Param("estatus") String estatus,
	                                                          @Param("nombreEmpleado") String nombreEmpleado);
}
