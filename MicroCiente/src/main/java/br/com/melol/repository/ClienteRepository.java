package br.com.melol.repository;

import br.com.melol.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<br.com.melol.repository.Cliente> findByCpf(String cpf);
}
