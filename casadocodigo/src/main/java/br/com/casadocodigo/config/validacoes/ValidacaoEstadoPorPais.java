package br.com.casadocodigo.config.validacoes;

import br.com.casadocodigo.dtos.dtosRequest.EstadoDto;
import br.com.casadocodigo.models.Estado;
import br.com.casadocodigo.repositories.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;
import java.util.Optional;

@Component
public class ValidacaoEstadoPorPais implements Validator {

    @Autowired
    EstadoRepository estadoRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return EstadoDto.class.isAssignableFrom(clazz);

    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()){ return; }

        EstadoDto estadoDto = (EstadoDto) target;
        Optional<Estado> listaEstados = estadoRepository.findByNomeAndPaisId(estadoDto.getNome(), estadoDto.getIdPais());


        if(listaEstados.isPresent()){
            errors.rejectValue("nome", null, "Já existe um estado com o nome informado neste país");

        }
    }



}
