package com.example.projeto_4_modulo8.controller;

import com.example.projeto_4_modulo8.service.PedidoService;
import com.example.projeto_4_modulo8.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;
}
