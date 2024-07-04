package com.gestion.empleados.services;

import com.gestion.empleados.models.ProjectsAssignment;
import com.gestion.empleados.dto.ResponseProjectsAssignmentDTO;


import java.util.List;
import java.util.Optional;

public interface ProjectsAssignmentService {
    // Obtiene todas las asignaciones de proyecto
    public List<ProjectsAssignment> getProjectsAssignments();
    
    // Guarda una nueva asignación de proyecto en el sistema
    public ProjectsAssignment saveProjectsAssignment(ProjectsAssignment projectsAssignment);
    
    // Obtiene una asignación de proyecto por su ID
    public Optional<ProjectsAssignment> getProjectsAssignmentById(Long id);
    
    // Actualiza una asignación de proyecto existente
    public ProjectsAssignment updateProjectsAssignment(ProjectsAssignment oldProjectsAssignment, ProjectsAssignment newProjectsAssignment);
    
    // Elimina una asignación de proyecto por su ID.
    public void deleteProjectsAssignmentById(Long id);
    
    // Obtiene todas las asignaciones de proyectos de un departamento específico
    public List<ProjectsAssignment> findByDepartmentId(Long departmentId);
    
    // Obtiene todas las asignaciones de proyectos con un estado específico
    public List<ProjectsAssignment> findByStatus(String status);
    
    // Obtiene todas las asignaciones de proyectos que contienen la palabra clave en la descripción
    public List<ProjectsAssignment> findByDescriptionContaining(String keyword);
    
    // Obtiene una asignación de proyecto específica por el ID del proyecto asociado
    public ProjectsAssignment findByProjectId(Long projectId);
    
    // Obtiene todas las asignaciones de proyectos por nombre de proyecto (usando un JOIN con otra tabla si es necesario)
    public List<ProjectsAssignment> findByProjectName(String projectName);
    
    //Obtiene todas las asignaciones de proyectos junto con la información del departamento asociado.
    List<ResponseProjectsAssignmentDTO> getProjectAssignmentsWithDepartmentsInfo();
}