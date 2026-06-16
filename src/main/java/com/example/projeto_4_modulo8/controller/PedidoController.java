package com.example.projeto_4_modulo8.controller;

import com.example.projeto_4_modulo8.service.ClienteService;
import com.example.projeto_4_modulo8.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;
}
