package com.example.projeto_4_modulo8.service;

import com.example.projeto_4_modulo8.model.Cliente;
import com.example.projeto_4_modulo8.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Long saveCliente(Cliente cliente) {
        Cliente clienteSalvo = clienteRepository.save(cliente);
        return clienteSalvo.getId();
    }

    public List<Cliente> findAllClientes() {
        return clienteRepository.findAll();
    }

    public Cliente findCliente(Long id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow();
        return cliente;
    }

    public void updateCliente(Long id, Cliente cliente) {
        Cliente clienteBase = findCliente(id);

        clienteBase.setAtivo(cliente.getAtivo());
        clienteBase.setEmail(cliente.getEmail());
        clienteBase.setNome(cliente.getNome());
        clienteBase.setTelefone(cliente.getTelefone());

        clienteRepository.save(clienteBase);
    }

    public void delete(Long id) {
        Cliente cliente = findCliente(id);
        cliente.setAtivo(Boolean.FALSE);

        clienteRepository.save(cliente);
    }
}
