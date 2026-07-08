package com.example.projeto_4_modulo8.model;

import com.example.projeto_4_modulo8.model.dto.ClienteRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String telefone;
    private String email;
    private Boolean ativo;

    public Cliente(ClienteRequestDTO clienteRequest) {
        this.nome = clienteRequest.getNome();
        this.telefone = clienteRequest.getTelefone();
        this.email = clienteRequest.getEmail();
    }
}
