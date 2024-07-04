package com.gestion.empleados.repositories;

import com.gestion.empleados.models.ProjectsTasks;

import com.gestion.empleados.dto.ResponseTasksDTO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ProjectsTasksRepositorio extends JpaRepository<ProjectsTasks, Long>{
	@Query("SELECT new com.gestion.empleados.dto.ResponseTasksDTO(pt.id, pt.name_task, pt.status, ep.nombreProyecto) " + 
	"FROM ProjectsTasks pt JOIN pt.project ep WHERE STATUS = :status")
	List<ResponseTasksDTO> getProjectsTasksByStatus(@Param("status") String status);
	
	@Query("SELECT new com.gestion.empleados.dto.ResponseTasksDTO(pt.id, pt.name_task, pt.status, ep.nombreProyecto) " + 
	"FROM ProjectsTasks pt JOIN pt.project ep")
	List<ResponseTasksDTO> getProjectsTasksWithProjec();
	
	@Query("SELECT new com.gestion.empleados.dto.ResponseTasksDTO(pt.id, pt.name_task, pt.status, ep.nombreProyecto) " + 
	"FROM ProjectsTasks pt JOIN pt.project ep WHERE pt.id = :id")
	ResponseTasksDTO getProjectsTasksWithID(@Param("id") Long id);
}
