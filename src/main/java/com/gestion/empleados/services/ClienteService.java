package com.gestion.empleados.services;


import com.gestion.empleados.models.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    public List<Cliente> getClientes();
    public Cliente saveCliente(Cliente cliente);
    public Optional<Cliente> getClienteoById(Long id);
    public Cliente updateCliente(Cliente oldCliente, Cliente newCliente);
    public void deleteClienteById(Long id);
    public List<Cliente> getClientesByCorreoDominio(String dominio);
    public Cliente getClienteWithMayorPedidos();
}
