package com.gestion.empleados.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gestion.empleados.dto.RequestProjectDTO;
import com.gestion.empleados.dto.ResponsePedidoDTO;
import com.gestion.empleados.dto.ResponseProjectDTO;
import com.gestion.empleados.models.Employee_Projects;

@Service
public interface ProjectService {
	public List<Employee_Projects> findAllProjects();
	public Employee_Projects saveProject (Employee_Projects employeeProject);
	public void deleteProject (Long id);
	public List<ResponseProjectDTO> getEmployee_ProjectsByParams(RequestProjectDTO requestProjectDTO);
	public Optional<ResponseProjectDTO> getProjectById(Long id);
	
}
