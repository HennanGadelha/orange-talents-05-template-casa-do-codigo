package br.com.casadocodigo.dtos.dtosRequest;

import br.com.casadocodigo.config.validacoes.ExistingId;
import br.com.casadocodigo.models.Estado;
import br.com.casadocodigo.models.Pais;
import br.com.casadocodigo.repositories.PaisRepository;

import javax.validation.constraints.NotNull;

public class EstadoDto {


    @NotNull
    private String nome;

    @NotNull @ExistingId(domainClass = Pais.class,fieldName = "id")
    private Long idPais;

    public String getNome() {
        return nome;
    }

    public Long getIdPais() {
        return idPais;
    }

    public Estado converterEstadoDtoParaEstado(EstadoDto estadoDto, PaisRepository paisRepository){

        Pais pais = paisRepository.getOne(estadoDto.getIdPais());

        return new Estado(estadoDto.getNome(), pais);


    }

}
