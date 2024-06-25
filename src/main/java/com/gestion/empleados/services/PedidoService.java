package com.gestion.empleados.services;


import com.gestion.empleados.dto.RequestPedidoDTO;
import com.gestion.empleados.dto.ResponsePedidoDTO;
import com.gestion.empleados.models.Pedido;

import java.util.List;
import java.util.Optional;

public interface PedidoService {
    public List<ResponsePedidoDTO> getPedidosWithClienteAndEmpleado();
    public Pedido savePedido(Pedido pedido);
    public Optional<ResponsePedidoDTO> getPedidoById(Long id);
    public void deletePedidoById(Long id);
    public List<ResponsePedidoDTO> getPedidoByParams(RequestPedidoDTO requestPedidoDTO);
}
