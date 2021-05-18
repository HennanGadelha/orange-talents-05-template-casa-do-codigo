package br.com.casadocodigo.dtos;

import br.com.casadocodigo.models.Categoria;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CategoriaDto {

    @NotEmpty @NotNull @NotBlank
    private String nome;

    public String getNome() {
        return nome;
    }

    public Categoria converterCategoriaDtoParaCategoria(CategoriaDto categoriaDto){
        return  new Categoria(categoriaDto.getNome());
    }
}
