package com.example.projeto_4_modulo8.controller;

import com.example.projeto_4_modulo8.model.Produto;
import com.example.projeto_4_modulo8.model.dto.ProdutoRequestDTO;
import com.example.projeto_4_modulo8.model.dto.ProdutoResponseDTO;
import com.example.projeto_4_modulo8.service.PedidoService;
import com.example.projeto_4_modulo8.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<?> cadastrarProduto(@RequestBody ProdutoRequestDTO produto) {
        Long id = produtoService.saveProduto(produto);

        URI location = URI.create("/produto/" + id);

        return ResponseEntity.created(location).build();

    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>>  buscarTodos() {
        List<ProdutoResponseDTO> produtos = produtoService.findAllProdutos();

        return ResponseEntity.ok(produtos);
    }

    @GetMapping("{id}")
    public ResponseEntity<ProdutoResponseDTO>  buscarPorId(@PathVariable Long id) {
        ProdutoResponseDTO produtoResponse = produtoService.findProdutoResponse(id);

        return ResponseEntity.ok(produtoResponse);
    }

    @PutMapping("{id}")
    public ResponseEntity<?>  atualizarProduto(@PathVariable Long id, @RequestBody ProdutoRequestDTO produto) {
        produtoService.updateProduto(id, produto);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletarPorId(@PathVariable Long id) {
        produtoService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
