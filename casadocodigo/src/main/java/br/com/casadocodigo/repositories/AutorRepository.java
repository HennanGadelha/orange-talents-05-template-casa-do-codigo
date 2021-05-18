package br.com.casadocodigo.repositories;

import br.com.casadocodigo.models.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
