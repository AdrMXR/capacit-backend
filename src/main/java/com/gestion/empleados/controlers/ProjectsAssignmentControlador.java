package com.gestion.empleados.controlers;

import com.gestion.empleados.dto.RequestProjectsAssignmentDTO;
import com.gestion.empleados.dto.ResponseProjectsAssignmentDTO;
import com.gestion.empleados.models.EmployeeProjects;
import com.gestion.empleados.models.ProjectsAssignment;
import com.gestion.empleados.services.ProjectsAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/v1/")
public class ProjectsAssignmentControlador {

    @Autowired
    private ProjectsAssignmentService projectsAssignmentService;

    
    @GetMapping("/ProjectsAssignments")
    public List<ResponseProjectsAssignmentDTO> getAllProjectsAssignments() {
        List<ProjectsAssignment> projectsAssignments = projectsAssignmentService.getProjectsAssignments();
        return projectsAssignments.stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/ProjectsAssignments/BuscarPorId/{id}")
    public ResponseEntity<ResponseProjectsAssignmentDTO> getProjectsAssignmentById(@PathVariable Long id) {
        Optional<ProjectsAssignment> projectsAssignment = projectsAssignmentService.getProjectsAssignmentById(id);
        return projectsAssignment
                .map(pa -> ResponseEntity.ok(convertToResponseDTO(pa)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseProjectsAssignmentDTO> createProjectsAssignment(@RequestBody RequestProjectsAssignmentDTO request) {
        Optional<EmployeeProjects> employeeProjects = Optional.empty();
        if (!employeeProjects.isPresent()) {
            return ResponseEntity.badRequest().build();
            
        }
        ProjectsAssignment projectsAssignment = new ProjectsAssignment();
        projectsAssignment.setEmployeeProjects(employeeProjects.get());
        projectsAssignment.setIdDepartment(request.getIdDepartment());
        projectsAssignment.setDescription(request.getDescription());
        projectsAssignment.setStatus(request.getStatus());
        ProjectsAssignment created = projectsAssignmentService.saveProjectsAssignment(projectsAssignment);
        return ResponseEntity.ok(convertToResponseDTO(created));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseProjectsAssignmentDTO> updateProjectsAssignment(@PathVariable Long id, @RequestBody RequestProjectsAssignmentDTO request) {
        Optional<ProjectsAssignment> existingProjectsAssignmentOpt = projectsAssignmentService.getProjectsAssignmentById(id);
        if (!existingProjectsAssignmentOpt.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Optional<EmployeeProjects> employeeProjects = Optional.empty();
        if (!employeeProjects.isPresent()) {
            return ResponseEntity.badRequest().build();
        }

        ProjectsAssignment existingProjectsAssignment = existingProjectsAssignmentOpt.get();
        existingProjectsAssignment.setEmployeeProjects(employeeProjects.get());
        existingProjectsAssignment.setIdDepartment(request.getIdDepartment());
        existingProjectsAssignment.setDescription(request.getDescription());
        existingProjectsAssignment.setStatus(request.getStatus());

        ProjectsAssignment updatedProjectsAssignment = projectsAssignmentService.updateProjectsAssignment(existingProjectsAssignment, existingProjectsAssignment);
        return ResponseEntity.ok(convertToResponseDTO(updatedProjectsAssignment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProjectsAssignment(@PathVariable Long id) {
        projectsAssignmentService.deleteProjectsAssignmentById(id);
        return ResponseEntity.noContent().build();
    }

    private ResponseProjectsAssignmentDTO convertToResponseDTO(ProjectsAssignment projectsAssignment) {
        return new ResponseProjectsAssignmentDTO(
                projectsAssignment.getId(),
                projectsAssignment.getEmployeeProjects().getId(),
                projectsAssignment.getIdDepartment(),
                projectsAssignment.getDescription(),
                projectsAssignment.getStatus()
        );
    }
}