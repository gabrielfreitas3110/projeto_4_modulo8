package com.example.projeto_4_modulo8.service;

import com.example.projeto_4_modulo8.enums.StatusEnum;
import com.example.projeto_4_modulo8.model.Pedido;
import com.example.projeto_4_modulo8.repository.PedidoRepository;
import com.example.projeto_4_modulo8.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Long savePedido(Pedido pedido) {
        Pedido pedidoSalvo = pedidoRepository.save(pedido);
        return pedidoSalvo.getId();
    }

    public List<Pedido> findAllPedidos() {
        return pedidoRepository.findAll();
    }

    public Pedido findPedido(Long id) {
        Pedido pedido = pedidoRepository.findById(id).orElseThrow();
        return pedido;
    }

    public void finishPedido(Long id) {
        Pedido pedido = findPedido(id);
        pedido.setStatusEnum(StatusEnum.FINALIZADO);
        pedidoRepository.save(pedido);
    }

    public void cancellPedido(Long id) {
        Pedido pedido = findPedido(id);
        pedido.setStatusEnum(StatusEnum.CANCELADO);
        pedidoRepository.save(pedido);
    }
}
