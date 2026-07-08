package com.example.projeto_4_modulo8.service;

import com.example.projeto_4_modulo8.model.Cliente;
import com.example.projeto_4_modulo8.model.dto.ClienteRequestDTO;
import com.example.projeto_4_modulo8.model.dto.ClienteResponseDTO;
import com.example.projeto_4_modulo8.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Long saveCliente(ClienteRequestDTO clienteRequest) {
        Cliente cliente = new Cliente(clienteRequest);
        cliente.setAtivo(Boolean.TRUE);
        Cliente clienteSalvo = clienteRepository.save(cliente);
        return clienteSalvo.getId();
    }

    public List<ClienteResponseDTO> findAllClientes() {
        List<Cliente> clientes = clienteRepository.findAll();

        List<ClienteResponseDTO> clientResponseList = clientes.stream().map(ClienteResponseDTO::new).toList();

        return clientResponseList;
    }

    public ClienteResponseDTO findClienteResponse(Long id) {
        Cliente cliente = findCliente(id);
        ClienteResponseDTO clienteResponseDTO = new ClienteResponseDTO(cliente);
        return clienteResponseDTO;
    }

    public Cliente findCliente(Long id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow();
        return cliente;
    }

    public void updateCliente(Long id, ClienteRequestDTO cliente) {
        Cliente clienteBase = findCliente(id);

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
