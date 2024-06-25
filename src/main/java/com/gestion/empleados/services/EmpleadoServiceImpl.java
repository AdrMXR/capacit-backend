package com.gestion.empleados.services;

import com.gestion.empleados.models.Empleado;
import com.gestion.empleados.repositories.EmpleadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{
    @Autowired
    EmpleadoRepositorio empleadoRepositorio;
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Empleado> getEmpleados() {
        return empleadoRepositorio.findAll();
    }

    @Override
    public Empleado saveEmpleado(Empleado empleado) {
        return empleadoRepositorio.save(empleado);
    }

    @Override
    public Optional<Empleado> getEmpleadoById(Long id) {
        return empleadoRepositorio.findById(id);
    }

    @Override
    public Empleado updateEmpleado(Empleado oldEmpleado, Empleado newEmpleado) {
        oldEmpleado.setNombre(newEmpleado.getNombre());
        oldEmpleado.setCargo(newEmpleado.getCargo());
        oldEmpleado.setSalario(newEmpleado.getSalario());
        oldEmpleado.setRfc(newEmpleado.getRfc());
        return empleadoRepositorio.save(oldEmpleado);
    }

    @Override
    public void deleteEmpleadoById(Long id) {
        empleadoRepositorio.deleteById(id);
    }

    @Override
    public List<Empleado> getEmpleadosWithMayorSalario(Double salario) {
        return empleadoRepositorio.getEmpleadosWithMayorSalario(salario);
    }

    @Override
    public Empleado getEmpleadoWithMayorPedidos() {
        return empleadoRepositorio.getEmpleadoWithMayorPedidos();
    }

    @Override
    public List<Empleado> getEmpleadosFisicos() {
        return empleadoRepositorio.getEmpleadosFisicos();
    }

    @Override
    public List<Empleado> getEmpleadosMorales() {
        return empleadoRepositorio.getEmpleadosMorales();
    }

    @Override
    public List<Empleado> getEmpleadoWithMenorSalario(Double salario) {
        return empleadoRepositorio.getEmpleadosWithMenorSalario(salario);
    }
}
