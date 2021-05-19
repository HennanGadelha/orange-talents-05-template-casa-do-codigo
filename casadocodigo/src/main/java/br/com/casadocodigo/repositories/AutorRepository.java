package br.com.casadocodigo.repositories;

import br.com.casadocodigo.models.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    Optional<Autor> findByEmail(String email);

}
