package com.example.projeto_4_modulo8.service;

import com.example.projeto_4_modulo8.repository.PedidoRepository;
import com.example.projeto_4_modulo8.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;
}
