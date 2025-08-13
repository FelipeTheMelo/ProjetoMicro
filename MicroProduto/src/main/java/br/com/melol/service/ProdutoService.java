package br.com.melol.service;

import br.com.melol.exception.NotFoundException;
import br.com.melol.model.Produto;
import br.com.melol.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Produto cadastrar(Produto produto) {
        return repository.save(produto);
    }

    @Transactional
    public Produto alterar(Long id, Produto novo) {
        Produto atual = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Produto não encontrado: id=" + id));
        atual.setNome(novo.getNome());
        atual.setPreco(novo.getPreco());
        return repository.save(atual);
    }

    @Transactional(readOnly = true)
    public Produto pesquisarPorNome(String nome) {
        return repository.findByNome(nome)
                .orElseThrow(() -> new NotFoundException("Produto não encontrado: nome=" + nome));
    }
}
