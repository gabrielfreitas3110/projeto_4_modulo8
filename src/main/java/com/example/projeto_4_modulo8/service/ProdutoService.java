package com.example.projeto_4_modulo8.service;

import com.example.projeto_4_modulo8.model.Produto;
import com.example.projeto_4_modulo8.model.dto.ClienteResponseDTO;
import com.example.projeto_4_modulo8.model.dto.ProdutoRequestDTO;
import com.example.projeto_4_modulo8.model.dto.ProdutoResponseDTO;
import com.example.projeto_4_modulo8.repository.PedidoRepository;
import com.example.projeto_4_modulo8.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Long saveProduto(ProdutoRequestDTO produtoRequestDTO) {
        Produto produto = new Produto(produtoRequestDTO);

        produto.setAtivo(Boolean.TRUE);
        produto = produtoRepository.save(produto);
        return produto.getId();
    }

    public List<ProdutoResponseDTO> findAllProdutos() {
        List<Produto> produtos = produtoRepository.findAll();

        List<ProdutoResponseDTO> produtoResponseDTOList = produtos.stream().map(ProdutoResponseDTO::new).toList();

        return produtoResponseDTOList;
    }

    public ProdutoResponseDTO findProdutoResponse(Long id) {
        Produto produto = findProduto(id);
        return new ProdutoResponseDTO(produto);
    }

    public Produto findProduto(Long id) {
        Produto produto = produtoRepository.findById(id).orElseThrow();
        return produto;
    }

    public void updateProduto(Long id, ProdutoRequestDTO produtoRequestDTO) {
        Produto produtoBase = findProduto(id);

        produtoBase.setDescricao(produtoRequestDTO.getDescricao());
        produtoBase.setNome(produtoRequestDTO.getNome());
        produtoBase.setPreco(produtoRequestDTO.getPreco());
        produtoBase.setQuantidadeEstoque(produtoRequestDTO.getQuantidadeEstoque());

        produtoRepository.save(produtoBase);
    }

    public void delete(Long id) {
        Produto produto = findProduto(id);
        produto.setAtivo(Boolean.FALSE);
        produtoRepository.save(produto);
    }
}
