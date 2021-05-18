package br.com.casadocodigo.config.validacoes;


import br.com.casadocodigo.dtos.AutorDto;
import br.com.casadocodigo.models.Autor;
import br.com.casadocodigo.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;


@Component
public class ImpedeEmailDuplicadoValidator implements Validator {

    @Autowired
    AutorRepository autorRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return AutorDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        if(errors.hasErrors()) return;

        AutorDto autorDto = (AutorDto) target;
        Optional<Autor> autorCadastrado  = autorRepository.findByEmail(autorDto.getEmail());

        if(autorCadastrado.isPresent()) errors.rejectValue("email", null,"Email: "
                + autorDto.getEmail() + " já cadastrado");

    }
}
