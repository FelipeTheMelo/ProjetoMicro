package br.com.melol.controller;

import br.com.melol.model.Cliente;
import br.com.melol.service.ClienteService;
import br.com.melol.model.Cliente;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final br.com.melol.controller.ClienteService service;

    public ClienteController(br.com.melol.controller.ClienteService service) {
        this.service = service;
    }

    @PostMapping
    public <Cliente extends br.com.melol.model.Cliente> ResponseEntity<Cliente> cadastrar(@Valid @RequestBody Cliente cliente) {
        Cliente salvo = (Cliente) service.cadastrar(cliente);
        return ResponseEntity.status(201).body(salvo);
    }

    @PutMapping("/{id}")
    public <Cliente> ResponseEntity<Cliente> alterar(@PathVariable Long id, @Valid @RequestBody Cliente cliente) {
        Cliente atualizado = service.alterar(id, cliente);
        return ResponseEntity.ok(atualizado);
    }

    @GetMapping("/cpf/{cpf}")
    public <Cliente> ResponseEntity<Cliente> pesquisar(@PathVariable String cpf) {
        Cliente encontrado = (Cliente) service.pesquisarPorCpf(cpf);
        return ResponseEntity.ok(encontrado);
    }
}