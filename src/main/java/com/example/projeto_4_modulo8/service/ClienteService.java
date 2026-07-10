package com.example.projeto_4_modulo8.service;

import com.example.projeto_4_modulo8.config.exception.BusinessException;
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
        if(clienteRequest.getEmail() != null) {
            Cliente cliente = clienteRepository.findByEmail(clienteRequest.getEmail());
            if(cliente != null) {
                throw new BusinessException("E-mail já cadastrado para outro cliente");
            }
        }

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

    public void updateCliente(Long id, ClienteRequestDTO clienteRequest) {
        if(clienteRequest.getEmail() != null) {
            Cliente cliente = clienteRepository.findByEmail(clienteRequest.getEmail());
            if(cliente != null) {
                throw new BusinessException("E-mail já cadastrado para outro cliente");
            }
        }

        Cliente clienteBase = findCliente(id);

        clienteBase.setEmail(clienteRequest.getEmail());
        clienteBase.setNome(clienteRequest.getNome());
        clienteBase.setTelefone(clienteRequest.getTelefone());

        clienteRepository.save(clienteBase);
    }

    public void delete(Long id) {
        Cliente cliente = findCliente(id);
        cliente.setAtivo(Boolean.FALSE);

        clienteRepository.save(cliente);
    }
}
