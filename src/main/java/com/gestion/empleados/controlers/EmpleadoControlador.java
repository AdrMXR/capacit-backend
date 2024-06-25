package com.gestion.empleados.controlers;

import com.gestion.empleados.exceptions.ResourceNotFoundException;
import com.gestion.empleados.models.Cliente;
import com.gestion.empleados.models.Empleado;
import com.gestion.empleados.repositories.EmpleadoRepositorio;
import com.gestion.empleados.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")

public class EmpleadoControlador {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping("/empleados")
    public List<Empleado> getEmpleados() {
        return empleadoService.getEmpleados();
    }

    @PostMapping("/empleados")
    public Empleado guardarEmpleado(@RequestBody Empleado empleado) {
        return empleadoService.saveEmpleado(empleado);
    }

    @GetMapping("/empleados/buscarPorId/{id}")
    public ResponseEntity<Empleado> obtenerEmpleadoPorId(@PathVariable Long id) {
        Empleado empleado = empleadoService.getEmpleadoById(id).orElseThrow(() -> new ResourceNotFoundException("No existe la persona"));
        return ResponseEntity.ok(empleado);
    }

    @GetMapping("/empleados/buscarPorSalarioMayorA/{salario}")
    public List<Empleado> getEmpleadosWithMayorSalario(@PathVariable Double salario) {
        return empleadoService.getEmpleadosWithMayorSalario(salario);
    }

    @GetMapping("/empleados/buscarPorSalarioMenorA/{salario}")
    public List<Empleado> getEmpleadosWithMenorSalario(@PathVariable Double salario) {
        return empleadoService.getEmpleadoWithMenorSalario(salario);
    }

    @GetMapping("/empleados/buscarPorMayorPedidos")
    public ResponseEntity<Empleado> getEmpleadoWithMayorPedidos() {
        Empleado empleado = empleadoService.getEmpleadoWithMayorPedidos();
        return ResponseEntity.ok(empleado);
    }

    @GetMapping("/empleados/personasFisicas")
    public List<Empleado> getEmpleadosFisicos() {
        return empleadoService.getEmpleadosFisicos();
    }

    @GetMapping("/empleados/personasMorales")
    public List<Empleado> getEmpleadosMorales() {
        return empleadoService.getEmpleadosMorales();
    }

    @PutMapping("/empleados/{id}")
    public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable Long id, @RequestBody Empleado detalles) {
        Empleado empleado = empleadoService.getEmpleadoById(id).orElseThrow(() -> new ResourceNotFoundException("No existe la persona"));
        Empleado empleadoActualizado = empleadoService.updateEmpleado(empleado, detalles);
        return ResponseEntity.ok(empleadoActualizado);
    }

    @DeleteMapping("/empleados/{id}")
    public ResponseEntity<Empleado> eliminarEmpleadoPorId(@PathVariable Long id) {
        Empleado empleado = empleadoService.getEmpleadoById(id).orElseThrow(() -> new ResourceNotFoundException("No existe la persona"));
        empleadoService.deleteEmpleadoById(id);
        return ResponseEntity.ok(empleado);
    }
}
