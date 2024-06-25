package com.gestion.empleados.controlers;

import com.gestion.empleados.exceptions.ResourceNotFoundException;
import com.gestion.empleados.models.Cliente;
import com.gestion.empleados.models.Empleado;
import com.gestion.empleados.repositories.ClienteRepositorio;
import com.gestion.empleados.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")

public class ClienteControlador {

    @Autowired
    ClienteService clienteService;


    @GetMapping("/clientes")
    public List<Cliente> getClientes() {
        return clienteService.getClientes();
    }

    @PostMapping("/clientes")
    public Cliente addCliente(@RequestBody Cliente cliente) {
        return clienteService.saveCliente(cliente);
    }

    @GetMapping("/clientes/buscarPorId/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
        Cliente cliente = clienteService.getClienteoById(id).orElseThrow(() -> new ResourceNotFoundException("No existe la persona"));
        return ResponseEntity.ok(cliente);
    }

    @GetMapping("/clientes/buscarPorCorreoDominio/{dominio}")
    public List<Cliente> getClientesByCorreoDominio(@PathVariable String dominio) {
        return clienteService.getClientesByCorreoDominio(dominio);
    }

    @GetMapping("/clientes/buscarPorMayorPedidos")
    public ResponseEntity<Cliente> getClientesWithMayorPedidos() {
        Cliente cliente = clienteService.getClienteWithMayorPedidos();
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/clientes/{id}")
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable Long id, @RequestBody Cliente detalles) {
        Cliente cliente = clienteService.getClienteoById(id).orElseThrow(() -> new ResourceNotFoundException("No existe el cliente"));
        Cliente clienteActualizado = clienteService.updateCliente(cliente, detalles);
        return ResponseEntity.ok(clienteActualizado);
    }

    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<Cliente> eliminarClientePorId(@PathVariable Long id) {
        Cliente cliente = clienteService.getClienteoById(id).orElseThrow(() -> new ResourceNotFoundException("No existe el cliente"));
        clienteService.deleteClienteById(id);
        return ResponseEntity.ok(cliente);
    }
}
