package com.gestion.empleados.dto;

public class RequestProjectsAssignmentDTO {

    private Long id;
    private Long employeeProjectsId;
    private Long idDepartment;
    private String description;
    private String status;

    public RequestProjectsAssignmentDTO() {
    }

    public RequestProjectsAssignmentDTO(Long id, Long employeeProjectsId, Long idDepartment, String description, String status) {
        this.id = id;
        this.employeeProjectsId = employeeProjectsId;
        this.idDepartment = idDepartment;
        this.description = description;
        this.status = status;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmployeeProjectsId() { 
        return employeeProjectsId;
    }

    public void setEmployeeProjectsId(Long employeeProjectsId) { 
        this.employeeProjectsId = employeeProjectsId;
    }

    public Long getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(Long idDepartment) {
        this.idDepartment = idDepartment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}