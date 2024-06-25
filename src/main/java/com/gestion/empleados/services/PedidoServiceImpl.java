package com.gestion.empleados.services;

import com.gestion.empleados.dto.RequestPedidoDTO;
import com.gestion.empleados.dto.ResponsePedidoDTO;
import com.gestion.empleados.models.Pedido;
import com.gestion.empleados.repositories.PedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService{
    @Autowired
    PedidoRepositorio pedidoRepositorio;

    @Override
    public List<ResponsePedidoDTO> getPedidosWithClienteAndEmpleado() {
        return pedidoRepositorio.getPedidosWithClienteAndEmpleado();
    }

    @Override
    public Pedido savePedido(Pedido pedido) {
        return pedidoRepositorio.save(pedido);
    }

    @Override
    public Optional<ResponsePedidoDTO> getPedidoById(Long id) {
        return Optional.ofNullable(pedidoRepositorio.getPedidosWithClienteAndEmpleadoById(id));
    }

    @Override
    public void deletePedidoById(Long id) {
        pedidoRepositorio.deleteById(id);
    }

    @Override
    public List<ResponsePedidoDTO> getPedidoByParams(RequestPedidoDTO requestPedidoDTO) {
        return pedidoRepositorio.getPedidoByParams(requestPedidoDTO.getClienteNombre(), requestPedidoDTO.getEmpleadoNombre(),
                requestPedidoDTO.getPrecioTotalMin(), requestPedidoDTO.getPrecioTotalMax(), requestPedidoDTO.getFecha(),
                requestPedidoDTO.getStatus());
    }
}
