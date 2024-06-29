package com.gestion.empleados.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gestion.empleados.dto.RequestProjectDTO;
import com.gestion.empleados.dto.ResponsePedidoDTO;
import com.gestion.empleados.dto.ResponseProjectDTO;
import com.gestion.empleados.models.EmployeeProjects;

@Service
public interface ProjectService {
	public List<EmployeeProjects> findAllProjects();
	public EmployeeProjects saveProject (EmployeeProjects employeeProject);
	public void deleteProject (Long id);
	public List<ResponseProjectDTO> getEmployeeProjectsByParams(RequestProjectDTO requestProjectDTO);
	public Optional<ResponseProjectDTO> getProjectById(Long id);
	
	
}
