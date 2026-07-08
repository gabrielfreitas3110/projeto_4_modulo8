package com.example.projeto_4_modulo8.controller;

import com.example.projeto_4_modulo8.model.Cliente;
import com.example.projeto_4_modulo8.model.dto.ClienteRequestDTO;
import com.example.projeto_4_modulo8.model.dto.ClienteResponseDTO;
import com.example.projeto_4_modulo8.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<?> cadastrarCliente(@RequestBody @Valid ClienteRequestDTO cliente) {
        Long id = clienteService.saveCliente(cliente);

        URI location = URI.create("/cliente/" + id);

        return ResponseEntity.created(location).build();

    }

    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>>  buscarTodos() {
        List<ClienteResponseDTO> clientes = clienteService.findAllClientes();

        return ResponseEntity.ok(clientes);
    }

    @GetMapping("{id}")
    public ResponseEntity<ClienteResponseDTO>  buscarPorId(@PathVariable Long id) {
        ClienteResponseDTO cliente = clienteService.findClienteResponse(id);

        return ResponseEntity.ok(cliente);
    }

    @PutMapping("{id}")
    public ResponseEntity<?>  atualizarCliente(@PathVariable Long id, @RequestBody @Valid ClienteRequestDTO cliente) {
        clienteService.updateCliente(id, cliente);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletarPorId(@PathVariable Long id) {
        clienteService.delete(id);

        return ResponseEntity.noContent().build();
    }

}
