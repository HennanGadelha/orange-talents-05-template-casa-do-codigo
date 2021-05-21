package br.com.casadocodigo.dtos.dtosRequest;

import br.com.casadocodigo.config.validacoes.UniqueValue;
import br.com.casadocodigo.models.Pais;

import javax.validation.constraints.NotNull;

public class PaisDtoRequest {


    @NotNull @UniqueValue(domainClass = Pais.class,fieldName = "nome")
    private String nome;

    public PaisDtoRequest(){}

    public PaisDtoRequest(String nome){
        this.nome = nome;;
    }

    public String getNome() {
        return nome;
    }

    public Pais converterPaisDtoParaaPais(PaisDtoRequest paisDtoRequest){

        return new Pais(paisDtoRequest.getNome());
    }

}
