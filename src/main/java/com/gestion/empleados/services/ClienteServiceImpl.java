package com.gestion.empleados.services;

import com.gestion.empleados.models.Cliente;
import com.gestion.empleados.repositories.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    ClienteRepositorio clienteRepositorio;

    @Override
    public List<Cliente> getClientes() {
        return clienteRepositorio.findAll();
    }

    @Override
    public Cliente saveCliente(Cliente cliente) {
        return clienteRepositorio.save(cliente);
    }

    @Override
    public Optional<Cliente> getClienteoById(Long id) {
        return clienteRepositorio.findById(id);
    }

    @Override
    public Cliente updateCliente(Cliente oldCliente, Cliente newCliente) {
        oldCliente.setNombre(newCliente.getNombre());
        oldCliente.setDireccion(newCliente.getDireccion());
        oldCliente.setCorreo(newCliente.getCorreo());
        oldCliente.setTelefono(newCliente.getTelefono());
        return clienteRepositorio.save(oldCliente);
    }

    @Override
    public void deleteClienteById(Long id) {
        clienteRepositorio.deleteById(id);
    }

    @Override
    public List<Cliente> getClientesByCorreoDominio(String dominio) {
        return clienteRepositorio.getClientesByCorreoDominio(dominio);
    }

    @Override
    public Cliente getClienteWithMayorPedidos() {
        return clienteRepositorio.getClienteWithMayorPedidos();
    }
}
