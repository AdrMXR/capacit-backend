package com.gestion.empleados.dto;

import java.time.LocalDate;

public class ResponseProjectsAssignmentDTO {
    private Long id;
    private Long employeeProjectsId;
    private Long idDepartment;
    private String description;
    private String status;
    private String departmentName;
    private String projectName;
    private LocalDate projectStartDate;
    private LocalDate projectEndDate;

    public ResponseProjectsAssignmentDTO() {

    }

    public ResponseProjectsAssignmentDTO(Long id, Long employeeProjectsId, Long idDepartment, String description,
            String status, String departmentName, String projectName, LocalDate projectStartDate,
            LocalDate projectEndDate, String employeeName, String employeePosition, Double employeeSalary,
            String employeeRfc) {
        this.id = id;
        this.employeeProjectsId = employeeProjectsId;
        this.idDepartment = idDepartment;
        this.description = description;
        this.status = status;
        this.departmentName = departmentName;
        this.projectName = projectName;
        this.projectStartDate = projectStartDate;
        this.projectEndDate = projectEndDate;

    }

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

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public LocalDate getProjectStartDate() {
		return projectStartDate;
	}

	public void setProjectStartDate(LocalDate projectStartDate) {
		this.projectStartDate = projectStartDate;
	}

	public LocalDate getProjectEndDate() {
		return projectEndDate;
	}

	public void setProjectEndDate(LocalDate projectEndDate) {
		this.projectEndDate = projectEndDate;
	}

}
