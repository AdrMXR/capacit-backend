package com.gestion.empleados.dto;

public class RequestTasksDTO {
	 private Long id;
	 private String name_task;
	 private String status;
	 private Long projectID;
	 
	 public RequestTasksDTO (Long id, String name_task, String status, Long projectID) {
		this.id = id;
		this.name_task = name_task;
		this.status = status;
		this.projectID = projectID;
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
	
	public Long getProject() {
		return projectID;
	}
	
	public void setProject (Long newProjectID) {
		this.projectID = newProjectID;
	}
}