package com.gestion.empleados.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gestion.empleados.services.ProjectsTasksService;
import com.gestion.empleados.dto.ResponseTasksDTO;
import com.gestion.empleados.exceptions.ResourceNotFoundException;
import com.gestion.empleados.models.ProjectsTasks;
import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class ProjectsTasksControlador {
	
	@Autowired
	ProjectsTasksService projectsTasksService;
	
	@GetMapping("/projects-tasks")
	public List<ProjectsTasks> findAll(){
		return projectsTasksService.getProjectsTasks();
	}
	
	@GetMapping("/projects-tasksByStatus/{status}")
	public ResponseEntity<List<ResponseTasksDTO>> getProjectsTasksForStatus(@PathVariable String status){
		List<ResponseTasksDTO> list = projectsTasksService.getProjectsTasksByStatus(status);
		return ResponseEntity.ok(list);
	}

	@GetMapping("/projectsTasksByID/{id}")
	public ResponseEntity<ResponseTasksDTO> getProjectsTasksbyID(@PathVariable Long id){
		ResponseTasksDTO task = projectsTasksService.getProjectsTasksWithID(id)
				.orElseThrow(() -> new ResourceNotFoundException("No existe el proyecto con ID: " + id));
		return ResponseEntity.ok(task);
	}
	
	@GetMapping("/tasks-projects")
	public ResponseEntity<List<ResponseTasksDTO>> getProjectsTasksComplete(){
		List<ResponseTasksDTO> list = projectsTasksService.getProjectsTasksWithProject();
		return ResponseEntity.ok(list);
	}
	
	@PostMapping("/save-projectsTasks")
	public ResponseEntity<Void> saveProjectsTasks(@RequestBody ProjectsTasks newProjectsTasks) {
		projectsTasksService.saveProjectsTasks(newProjectsTasks);
		return ResponseEntity.status(200).build();
	}
	
	@DeleteMapping("/delete-projectsTasks/{id}")
	public ResponseEntity<Void> deleteProjectsTasks(@PathVariable Long id){
		projectsTasksService.getProjectsTasksWithID(id).orElseThrow(() -> new ResourceNotFoundException("No existe el proyecto con ID: " + id));
		projectsTasksService.deleteProjectTaskByID(id);
		return ResponseEntity.status(200).build();
	}
}
