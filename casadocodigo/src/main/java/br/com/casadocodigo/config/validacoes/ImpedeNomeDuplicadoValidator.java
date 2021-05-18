package br.com.casadocodigo.config.validacoes;

import br.com.casadocodigo.dtos.CategoriaDto;
import br.com.casadocodigo.models.Categoria;
import br.com.casadocodigo.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ImpedeNomeDuplicadoValidator implements Validator {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return CategoriaDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        if(errors.hasErrors()) return;

        CategoriaDto categoriaDto = (CategoriaDto) target;
        Optional<Categoria> categoriaDuplicada = categoriaRepository.findByNome(categoriaDto.getNome());

        if(categoriaDuplicada.isPresent()) errors.rejectValue("nome", null, "Categoria: "
                + categoriaDto.getNome() + " já cadastrada");

    }
}
