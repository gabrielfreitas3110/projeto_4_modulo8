package com.example.projeto_4_modulo8.service;

import com.example.projeto_4_modulo8.model.Produto;
import com.example.projeto_4_modulo8.repository.PedidoRepository;
import com.example.projeto_4_modulo8.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Long saveProduto(Produto produto) {
        produto.setAtivo(Boolean.TRUE);
        Produto produtoSalvo = produtoRepository.save(produto);
        return produtoSalvo.getId();
    }

    public List<Produto> findAllProdutos() {
        return produtoRepository.findAll();
    }

    public Produto findProduto(Long id) {
        Produto produto = produtoRepository.findById(id).orElseThrow();
        return produto;
    }

    public void updateProduto(Long id, Produto produto) {
        Produto produtoBase = findProduto(id);

        produtoBase.setAtivo(produto.getAtivo());
        produtoBase.setDescricao(produto.getDescricao());
        produtoBase.setNome(produto.getNome());
        produtoBase.setPreco(produto.getPreco());
        produtoBase.setQuantidadeEstoque(produto.getQuantidadeEstoque());

        produtoRepository.save(produtoBase);
    }

    public void delete(Long id) {
        Produto produto = findProduto(id);
        produto.setAtivo(Boolean.FALSE);
        produtoRepository.save(produto);
    }
}
