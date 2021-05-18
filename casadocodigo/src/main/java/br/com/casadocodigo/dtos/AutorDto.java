package br.com.casadocodigo.dtos;

import br.com.casadocodigo.models.Autor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class AutorDto {

    @NotNull @NotBlank @NotEmpty
    private String nome;
    @Email @NotNull @NotBlank @NotEmpty
    private String email;
    @NotNull @Length(max = 400) @NotBlank @NotEmpty
    private String descricao;


    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public Autor converterAutor(AutorDto autorDto){

        Autor autor = new Autor(autorDto.getNome(), autorDto.getEmail(), autorDto.getDescricao());
        return autor;

    }
}
