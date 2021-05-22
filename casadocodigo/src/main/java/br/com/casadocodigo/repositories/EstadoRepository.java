package br.com.casadocodigo.repositories;

import br.com.casadocodigo.models.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface EstadoRepository extends JpaRepository<Estado, Long> {


    Optional<Estado> findByNomeAndPaisId(String nome, Long idPais);


	List<Estado> findByPaisId(Long idPais);
}
