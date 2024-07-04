package com.gestion.empleados.services;

import com.gestion.empleados.dto.ResponseProjectsAssignmentDTO;
import com.gestion.empleados.models.ProjectsAssignment;
import com.gestion.empleados.repositories.ProjectsAssignmentRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectsAssignmentServiceImpl implements ProjectsAssignmentService {

    @Autowired
    private ProjectsAssignmentRepositorio projectsAssignmentRepositorio;

    @Override
    public List<ProjectsAssignment> getProjectsAssignments() {
        return projectsAssignmentRepositorio.findAll();
    }

    @Override
    public ProjectsAssignment saveProjectsAssignment(ProjectsAssignment projectsAssignment) {
        return projectsAssignmentRepositorio.save(projectsAssignment);
    }

    @Override
    public Optional<ProjectsAssignment> getProjectsAssignmentById(Long id) {
        return projectsAssignmentRepositorio.findById(id);
    }

    @Override
    public ProjectsAssignment updateProjectsAssignment(ProjectsAssignment oldProjectsAssignment, ProjectsAssignment newProjectsAssignment) {
        oldProjectsAssignment.setEmployeeProjects(newProjectsAssignment.getEmployeeProjects());
        oldProjectsAssignment.setIdDepartment(newProjectsAssignment.getIdDepartment());
        oldProjectsAssignment.setDescription(newProjectsAssignment.getDescription());
        oldProjectsAssignment.setStatus(newProjectsAssignment.getStatus());
        return projectsAssignmentRepositorio.save(oldProjectsAssignment);
    }

    @Override
    public void deleteProjectsAssignmentById(Long id) {
        projectsAssignmentRepositorio.deleteById(id);
    }

    @Override
    public List<ProjectsAssignment> findByDepartmentId(Long departmentId) {
        return projectsAssignmentRepositorio.findByDepartmentId(departmentId);
    }

    @Override
    public List<ProjectsAssignment> findByStatus(String status) {
        return projectsAssignmentRepositorio.findByStatus(status);
    }

    @Override
    public List<ProjectsAssignment> findByDescriptionContaining(String keyword) {
        return projectsAssignmentRepositorio.findByDescriptionContaining(keyword);
    }

    @Override
    public ProjectsAssignment findByProjectId(Long projectId) {
        return projectsAssignmentRepositorio.findByProjectId(projectId);
    }

    @Override
    public List<ProjectsAssignment> findByProjectName(String projectName) {
        return projectsAssignmentRepositorio.findByProjectName(projectName);
    }

    @Override
    public List<ResponseProjectsAssignmentDTO> getProjectAssignmentsWithDepartmentsInfo() {
        List<Object[]> assignmentsWithDepartmentsInfo = projectsAssignmentRepositorio.findAllWithDepartmentInfo();
        return assignmentsWithDepartmentsInfo.stream()
                .map(this::convertToObjectDTO)
                .collect(Collectors.toList());
    }

    private ResponseProjectsAssignmentDTO convertToObjectDTO(Object[] objectArray) {
        // Mapea el resultado del query a un ResponseProjectsAssignmentDTO
        return new ResponseProjectsAssignmentDTO(
                (Long) objectArray[0], // id
                (Long) objectArray[1], // employeeProjectsId
                (Long) objectArray[2], // idDepartment
                (String) objectArray[3], // description
                (String) objectArray[4], // status
                (String) objectArray[5], // departmentName
                (String) objectArray[6], // projectName
                (LocalDate) objectArray[7], // projectStartDate
                (LocalDate) objectArray[8], // projectEndDate
                (String) objectArray[9], // employeeName
                (String) objectArray[10], // employeePosition
                (Double) objectArray[11], // employeeSalary
                (String) objectArray[12] // employeeRfc
        );
    }
}
