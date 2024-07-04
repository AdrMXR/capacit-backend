package com.gestion.empleados.services;

import com.gestion.empleados.models.ProjectsTasks;
import com.gestion.empleados.dto.ResponseTasksDTO;
import java.util.Optional;
import java.util.List;

public interface ProjectsTasksService {
	public List<ProjectsTasks> getProjectsTasks();
	public ProjectsTasks saveProjectsTasks(ProjectsTasks newProjectTask);
	public ProjectsTasks updateProjectTask(ProjectsTasks oldProjectsTasks, ProjectsTasks newProjectsTasks);
	public void deleteProjectTaskByID(Long id);
	public List<ResponseTasksDTO> getProjectsTasksByStatus(String status);
	public List<ResponseTasksDTO> getProjectsTasksWithProject();
	public Optional<ResponseTasksDTO> getProjectsTasksWithID(Long id);
}
