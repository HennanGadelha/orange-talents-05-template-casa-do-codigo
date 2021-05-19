package br.com.casadocodigo.repositories;

import br.com.casadocodigo.models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
