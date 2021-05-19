package br.com.casadocodigo.dtos;

import br.com.casadocodigo.config.validacoes.UniqueValue;
import br.com.casadocodigo.models.Categoria;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CategoriaDto {

    @NotEmpty @NotNull @NotBlank @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
    private String nome;

    public String getNome() {
        return nome;
    }

    public Categoria converterCategoriaDtoParaCategoria(CategoriaDto categoriaDto){
        return  new Categoria(categoriaDto.getNome());
    }
}
