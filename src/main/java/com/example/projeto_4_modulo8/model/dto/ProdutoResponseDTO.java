package com.example.projeto_4_modulo8.model.dto;

import com.example.projeto_4_modulo8.model.Produto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProdutoResponseDTO {
    private String nome;
    private String descricao;
    private Double preco;
    private Integer quantidadeEstoque;

    public ProdutoResponseDTO(Produto produto) {
        this.nome = produto.getNome();
        this.descricao = produto.getDescricao();
        this.preco = produto.getPreco();
        this.quantidadeEstoque = produto.getQuantidadeEstoque();
    }
}
