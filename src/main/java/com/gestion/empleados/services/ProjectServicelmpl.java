package com.gestion.empleados.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.empleados.dto.RequestPedidoDTO;
import com.gestion.empleados.dto.RequestProjectDTO;
import com.gestion.empleados.dto.ResponseProjectDTO;
import com.gestion.empleados.models.EmployeeProjects;
import com.gestion.empleados.repositories.PedidoRepositorio;
import com.gestion.empleados.repositories.ProjectRepositorio;

@Service
public class ProjectServicelmpl implements ProjectService{
	@Autowired
	ProjectRepositorio projecRepository;

	@Override
	public List<EmployeeProjects> findAllProjects() {
		// TODO Auto-generated method stub
		return projecRepository.findAllProjects();
	}

	@Override
	public List<ResponseProjectDTO> getEmployee_ProjectsByParams(RequestProjectDTO requestProjectDTO ) {
		 return projecRepository.getEmployee_ProjectsByParams(requestProjectDTO.getNombreProyecto(),
                 requestProjectDTO.getFechaInicio(),
                 requestProjectDTO.getFechaFin(),
                 requestProjectDTO.getEstatus(),
                 requestProjectDTO.getNombreEmpleado());
}

	@Override
	public EmployeeProjects saveProject(EmployeeProjects employeeProject) {
		return projecRepository.save(employeeProject);
	}

	@Override
	public void deleteProject(Long id) {
		projecRepository.deleteById(id);
		
	}
	@Override
	public Optional<ResponseProjectDTO> getProjectById(Long id){
		return Optional.ofNullable(projecRepository.getProjectById(id));
	}
	
}
