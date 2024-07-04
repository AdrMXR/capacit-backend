package com.gestion.empleados.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="projects_tasks")
public class ProjectsTasks implements Serializable {
	 private static final long serialVersionUID = 1L;
	 
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name="ID")
	 private Long id;
	 
	 @Column(name="NAME_TASK", nullable = false)
	 private String name_task;
	 
	 @Column(name="STATUS", nullable = false)
	 private String status;
	 
	 @ManyToOne
	 @JoinColumn(name = "ID_PROJECT", nullable = false)
	 private EmployeeProjects project;
	 
	 public ProjectsTasks() {}
	 
	 public ProjectsTasks (Long id, String name_task, String status, EmployeeProjects project) {
		this.id = id;
		this.name_task = name_task;
		this.status = status;
		this.project = project;
	}


	public Long getID() {
		return id;
	}

	public void setID(Long iD) {
		id = iD;
	}

	public String getName_task() {
		return name_task;
	}

	public void setName_task(String name_task) {
		this.name_task = name_task;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public EmployeeProjects getProject(){
		return project;
	}
	
	public void setProject(EmployeeProjects newProject) {
		this.project = newProject;
	}
}


