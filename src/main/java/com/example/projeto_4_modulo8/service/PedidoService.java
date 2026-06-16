package com.example.projeto_4_modulo8.service;

import com.example.projeto_4_modulo8.repository.ClienteRepository;
import com.example.projeto_4_modulo8.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
}
