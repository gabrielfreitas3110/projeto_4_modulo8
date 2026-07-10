package com.example.projeto_4_modulo8.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProdutoRequestDTO {

    @NotBlank(message = "O campo nome é obrigatório")
    private String nome;

    private String descricao;

    @Positive(message = "O preço deve ser maior que zero")
    private Double preco;

    @PositiveOrZero(message = "A quantidade no estoque não pode ser negativa.")
    private Integer quantidadeEstoque;
}
