package com.gestion.empleados.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gestion.empleados.services.ProjectService;
import com.gestion.empleados.dto.*;
import com.gestion.empleados.exceptions.ResourceNotFoundException;
import com.gestion.empleados.models.EmployeeProjects;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class ProjectContolador {
	 @Autowired
	    ProjectService projectService;

	    @GetMapping("/projects")
	    public List<EmployeeProjects> findAll() {
	        return projectService.findAllProjects();
	    }

	    @PostMapping("/saveProject")
	    public EmployeeProjects guardarProyecto(@RequestBody EmployeeProjects proyecto) {
	        return projectService.saveProject(proyecto);
	    }

	    @PostMapping("/project/filtro")
	    public List<ResponseProjectDTO> getEmployeeProjectsByParams(@RequestBody RequestProjectDTO requestProjectDTO) {
	        return projectService.getEmployeeProjectsByParams(requestProjectDTO);
	    }

	    @GetMapping("/project/buscarPorID/{id}")
	    public ResponseEntity<ResponseProjectDTO> eliminarProyectoPorID(@PathVariable Long id) {
	        ResponseProjectDTO proyecto = projectService.getProjectById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("No existe el proyecto con ID: " + id));
	        return ResponseEntity.ok(proyecto);
	    }
	    }