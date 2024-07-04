package com.gestion.empleados.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gestion.empleados.dto.ResponseTasksDTO;
import com.gestion.empleados.models.ProjectsTasks;
import com.gestion.empleados.repositories.ProjectsTasksRepositorio;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectsTasksServiceImpl implements ProjectsTasksService {
	@Autowired
	ProjectsTasksRepositorio projectsTasksRepositorio;
	
	@Override
	public List<ProjectsTasks> getProjectsTasks(){
		return projectsTasksRepositorio.findAll();
	}
	
	@Override
	public ProjectsTasks saveProjectsTasks(ProjectsTasks projectTask) {
		return projectsTasksRepositorio.save(projectTask);
	}
	
	@Override
	public ProjectsTasks updateProjectTask(ProjectsTasks oldProjectsTasks, ProjectsTasks newProjectsTasks) {
		oldProjectsTasks.setName_task(newProjectsTasks.getName_task());
		oldProjectsTasks.setStatus(newProjectsTasks.getStatus());
		return projectsTasksRepositorio.save(oldProjectsTasks);
	}
	
	@Override
	public void deleteProjectTaskByID(Long id) {
		projectsTasksRepositorio.deleteById(id);
	}
	
	@Override
	public List<ResponseTasksDTO> getProjectsTasksByStatus(String status){
		return projectsTasksRepositorio.getProjectsTasksByStatus(status);
	}
	
	@Override 
	public List<ResponseTasksDTO> getProjectsTasksWithProject(){
		return projectsTasksRepositorio.getProjectsTasksWithProjec();
	}
	
	@Override
	public Optional<ResponseTasksDTO> getProjectsTasksWithID(Long id){
		return Optional.ofNullable(projectsTasksRepositorio.getProjectsTasksWithID(id));
	}
}
