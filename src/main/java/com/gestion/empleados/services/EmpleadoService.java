package com.gestion.empleados.services;

import com.gestion.empleados.models.Empleado;

import java.util.List;
import java.util.Optional;

public interface EmpleadoService {
    public List<Empleado> getEmpleados();
    public Empleado saveEmpleado(Empleado empleado);
    public Optional<Empleado> getEmpleadoById(Long id);
    public Empleado updateEmpleado(Empleado oldEmpleado, Empleado newEmpleado);
    public void deleteEmpleadoById(Long id);
    public List<Empleado> getEmpleadosWithMayorSalario(Double salario);
    public Empleado getEmpleadoWithMayorPedidos();
    public List<Empleado> getEmpleadosFisicos();
    public List<Empleado> getEmpleadosMorales();

    public List<Empleado> getEmpleadoWithMenorSalario(Double salario);
}
