package br.com.casadocodigo.repositories;

import br.com.casadocodigo.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
