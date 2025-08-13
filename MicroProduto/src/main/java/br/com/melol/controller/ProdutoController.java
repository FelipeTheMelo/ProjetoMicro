package br.com.melol.controller;

import br.com.melol.model.Produto;
import br.com.melol.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Produto> cadastrar(@Valid @RequestBody Produto produto) {
        Produto salvo = service.cadastrar(produto);
        return ResponseEntity.status(201).body(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> alterar(@PathVariable Long id, @Valid @RequestBody Produto produto) {
        Produto atualizado = service.alterar(id, produto);
        return ResponseEntity.ok(atualizado);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<Produto> pesquisar(@PathVariable String nome) {
        Produto encontrado = service.pesquisarPorNome(nome);
        return ResponseEntity.ok(encontrado);
    }
}
