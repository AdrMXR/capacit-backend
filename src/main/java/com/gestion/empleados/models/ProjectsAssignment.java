package com.gestion.empleados.models;

import javax.persistence.*;

@Entity
@Table(name = "projects_assignment")
public class ProjectsAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PROJECTS")
    private EmployeeProjects employeeProjects;

    @Column(name = "ID_DEPARTMENT")
    private Long idDepartment;

    // Nuevo campo para el nombre del departamento
    @Transient // Opcional, dependiendo de si existe una relación directa mapeada en JPA
    private String departmentName;

    private String description;
    private String status;

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EmployeeProjects getEmployeeProjects() {
        return employeeProjects;
    }

    public void setEmployeeProjects(EmployeeProjects employeeProjects) {
        this.employeeProjects = employeeProjects;
    }

    public Long getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(Long idDepartment) {
        this.idDepartment = idDepartment;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
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

