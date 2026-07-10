package com.example.projeto_4_modulo8.model;

import com.example.projeto_4_modulo8.model.dto.ProdutoRequestDTO;
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
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private Double preco;
    private Integer quantidadeEstoque;
    private Boolean ativo;

    public Produto(ProdutoRequestDTO produtoRequestDTO) {
        this.nome = produtoRequestDTO.getNome();
        this.descricao = produtoRequestDTO.getDescricao();
        this.preco = produtoRequestDTO.getPreco();
        this.quantidadeEstoque = produtoRequestDTO.getQuantidadeEstoque();
    }
}
