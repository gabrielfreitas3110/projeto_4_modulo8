package com.example.projeto_4_modulo8.model.dto;

import com.example.projeto_4_modulo8.model.Cliente;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClienteResponseDTO {
    private String nome;
    private String telefone;
    private String email;
    private Boolean ativo;

    public ClienteResponseDTO(Cliente cliente) {
        this.nome = cliente.getNome();
        this.telefone = cliente.getTelefone();
        this.email = cliente.getEmail();
        this.ativo = cliente.getAtivo();
    }
}
