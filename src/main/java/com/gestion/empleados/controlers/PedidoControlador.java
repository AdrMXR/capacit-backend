package com.gestion.empleados.controlers;

import com.gestion.empleados.dto.RequestPedidoDTO;
import com.gestion.empleados.dto.ResponsePedidoDTO;
import com.gestion.empleados.exceptions.ResourceNotFoundException;
import com.gestion.empleados.models.Pedido;
import com.gestion.empleados.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")

public class PedidoControlador {
    @Autowired
    PedidoService pedidoService;

    @GetMapping("/pedidos")
    public List<ResponsePedidoDTO> getPedidos() {
        return pedidoService.getPedidosWithClienteAndEmpleado();
    }

    @PostMapping("/pedidos")
    public Pedido guardarPedido(@RequestBody Pedido pedido) {
        return pedidoService.savePedido(pedido);
    }

    @GetMapping("/pedidos/buscarPorId/{id}")
    public ResponseEntity<ResponsePedidoDTO> obtenerPedidoPorId(@PathVariable Long id) {
        ResponsePedidoDTO pedido = pedidoService.getPedidoById(id).orElseThrow(() -> new ResourceNotFoundException("No existe el pedido"));
        return ResponseEntity.ok(pedido);
    }

    @PostMapping("/pedidos/filtro")
    public List<ResponsePedidoDTO> getPedidoByParams(@RequestBody RequestPedidoDTO requestPedidoDTO) {
        return pedidoService.getPedidoByParams(requestPedidoDTO);
    }

    @DeleteMapping("/pedidos/{id}")
    public ResponseEntity<ResponsePedidoDTO> eliminarPedidoPorId(@PathVariable Long id) {
        ResponsePedidoDTO pedido = pedidoService.getPedidoById(id).orElseThrow(() -> new ResourceNotFoundException("No existe el pedido"));
        pedidoService.deletePedidoById(id);
        return ResponseEntity.ok(pedido);
    }
}

