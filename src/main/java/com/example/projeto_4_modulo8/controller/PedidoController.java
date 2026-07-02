package com.example.projeto_4_modulo8.controller;

import com.example.projeto_4_modulo8.model.Pedido;
import com.example.projeto_4_modulo8.service.PedidoService;
import com.example.projeto_4_modulo8.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<?> cadastrarPedido(@RequestBody Pedido pedido) {
        Long id = pedidoService.savePedido(pedido);

        URI location = URI.create("/pedido/" + id);

        return ResponseEntity.created(location).build();

    }

    @GetMapping
    public ResponseEntity<List<Pedido>>  buscarTodos() {
        List<Pedido> pedidos = pedidoService.findAllPedidos();

        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("{id}")
    public ResponseEntity<Pedido>  buscarPorId(@PathVariable Long id) {
        Pedido pedido = pedidoService.findPedido(id);

        return ResponseEntity.ok(pedido);
    }

    @PutMapping("{id}/finalizar")
    public ResponseEntity<?>  finalizarPedido(@PathVariable Long id) {
        pedidoService.finishPedido(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}/cancelar")
    public ResponseEntity<?>  cancelarPedido(@PathVariable Long id) {
        pedidoService.cancellPedido(id);
        return ResponseEntity.noContent().build();
    }
}
