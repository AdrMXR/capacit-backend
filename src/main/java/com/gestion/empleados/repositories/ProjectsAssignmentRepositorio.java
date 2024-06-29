package com.gestion.empleados.repositories;

import com.gestion.empleados.models.ProjectsAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectsAssignmentRepositorio extends JpaRepository<ProjectsAssignment, Long> {

    // Encuentra todas las asignaciones de proyectos para un departamento específico
    @Query(value = "SELECT * FROM projects_assignment WHERE ID_DEPARTMENT = :departmentId", nativeQuery = true)
    List<ProjectsAssignment> findByDepartmentId(@Param("departmentId") Long departmentId);

    // Encuentra todas las asignaciones de proyectos con un estado específico
    @Query(value = "SELECT * FROM projects_assignment WHERE STATUS = :status", nativeQuery = true)
    List<ProjectsAssignment> findByStatus(@Param("status") String status);

    // Encuentra todas las asignaciones de proyectos que contienen una palabra clave en la descripción
    @Query(value = "SELECT * FROM projects_assignment WHERE DESCRIPTION LIKE %:keyword%", nativeQuery = true)
    List<ProjectsAssignment> findByDescriptionContaining(@Param("keyword") String keyword);

    // Encuentra una asignación de proyecto específica por su ID de proyecto
    @Query("SELECT pa FROM ProjectsAssignment pa WHERE pa.employeeProjects.id = :projectId")
    ProjectsAssignment findByProjectId(@Param("projectId") Long projectId);

    // Encuentra asignaciones de proyectos por nombre de proyecto (usando un JOIN con la tabla employee_projects)
    @Query("SELECT pa FROM ProjectsAssignment pa " +
           "INNER JOIN pa.employeeProjects ep " +
           "WHERE ep.nombreProyecto LIKE CONCAT('%', :nombreProyecto, '%')")
    List<ProjectsAssignment> findByProjectName(@Param("nombreProyecto") String nombreProyecto);
}