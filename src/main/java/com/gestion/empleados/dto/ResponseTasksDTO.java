package com.gestion.empleados.dto;

public class ResponseTasksDTO {
	 private Long id;
	 private String name_task;
	 private String status;
	 private String nombreProyecto;
	 
	 public ResponseTasksDTO() {}
	 
	 public ResponseTasksDTO (Long iD, String name_task, String status, String nombreProyecto) {
		this.id = iD;
		this.name_task = name_task;
		this.status = status;
		this.nombreProyecto = nombreProyecto;
		
	}

	public Long getID() {
		return id;
	}

	public void setID(Long iD) {
		this.id = iD;
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
	
	public String getProject() {
		return nombreProyecto;
	}
	
	public void setProject (String newProjectName) {
		this.nombreProyecto = newProjectName;
	}
}
