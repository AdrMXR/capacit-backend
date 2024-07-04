package com.gestion.empleados.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.gestion.empleados.dto.RequestProjectsAssignmentDTO;
import com.gestion.empleados.dto.ResponseProjectsAssignmentDTO;
import com.gestion.empleados.models.ProjectsAssignment;
import com.gestion.empleados.services.ProjectsAssignmentService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/v1/")
public class ProjectsAssignmentControlador {

    @Autowired
    private ProjectsAssignmentService projectsAssignmentService;

    // Endpoint para obtener todas las asignaciones de proyectos
    @GetMapping("/ProjectsAssignments")
    public List<ResponseProjectsAssignmentDTO> getAllProjectsAssignments() {
        List<ProjectsAssignment> projectsAssignments = projectsAssignmentService.getProjectsAssignments();
        return projectsAssignments.stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    // Endpoint para obtener una asignación de proyecto por su ID
    @GetMapping("/ProjectsAssignments/BuscarPorId/{id}")
    public ResponseEntity<ResponseProjectsAssignmentDTO> getProjectsAssignmentById(@PathVariable("id") Long id) {
        Optional<ProjectsAssignment> projectsAssignment = projectsAssignmentService.getProjectsAssignmentById(id);
        return projectsAssignment.map(entity -> ResponseEntity.ok(convertToResponseDTO(entity)))
                                 .orElse(ResponseEntity.notFound().build());
    }

    // Endpoint para crear una nueva asignación de proyecto
    @PostMapping("/create")
    public ResponseEntity<ResponseProjectsAssignmentDTO> createProjectsAssignment(@RequestBody RequestProjectsAssignmentDTO requestDTO) {
        ProjectsAssignment newAssignment = convertToEntity(requestDTO);
        ProjectsAssignment savedAssignment = projectsAssignmentService.saveProjectsAssignment(newAssignment);
        return ResponseEntity.created(null).body(convertToResponseDTO(savedAssignment));
    }

    // Endpoint para actualizar una asignación de proyecto existente por su ID
    @PutMapping("/{id}")
    public ResponseEntity<ResponseProjectsAssignmentDTO> updateProjectsAssignment(
            @PathVariable("id") Long id,
            @RequestBody RequestProjectsAssignmentDTO requestDTO) {
        Optional<ProjectsAssignment> existingAssignment = projectsAssignmentService.getProjectsAssignmentById(id);
        return existingAssignment.map(entity -> {
            ProjectsAssignment updatedAssignment = convertToEntity(requestDTO);
            updatedAssignment.setId(id);
            ProjectsAssignment updated = projectsAssignmentService.updateProjectsAssignment(entity, updatedAssignment);
            return ResponseEntity.ok(convertToResponseDTO(updated));
        }).orElse(ResponseEntity.notFound().build());
    }

 // Endpoint para eliminar una asignación de proyecto por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProjectsAssignment(@PathVariable("id") Long id) {
        try {
            projectsAssignmentService.deleteProjectsAssignmentById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    // Método privado para convertir ProjectsAssignment a ResponseProjectsAssignmentDTO
    private ResponseProjectsAssignmentDTO convertToResponseDTO(ProjectsAssignment entity) {
        ResponseProjectsAssignmentDTO responseDTO = new ResponseProjectsAssignmentDTO();
        responseDTO.setId(entity.getId());
        responseDTO.setEmployeeProjectsId(entity.getId());
        responseDTO.setIdDepartment(entity.getIdDepartment());
        responseDTO.setDescription(entity.getDescription());
        responseDTO.setStatus(entity.getStatus());

        if (entity.getEmployeeProjects() != null) {
            responseDTO.setProjectName(entity.getEmployeeProjects().getNombreProyecto());
            responseDTO.setProjectStartDate(entity.getEmployeeProjects().getFechaInicio());
            responseDTO.setProjectEndDate(entity.getEmployeeProjects().getFechaFin());
        }

        responseDTO.setDepartmentName(entity.getDepartmentName());

        return responseDTO;
    }

    private ProjectsAssignment convertToEntity(RequestProjectsAssignmentDTO requestDTO) {
        // Implementa la conversión de RequestProjectsAssignmentDTO a ProjectsAssignment aquí
        return null; // Implementación requerida
    }
}
