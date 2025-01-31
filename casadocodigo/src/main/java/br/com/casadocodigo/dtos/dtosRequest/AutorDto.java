package br.com.casadocodigo.dtos.dtosRequest;

import br.com.casadocodigo.config.validacoes.UniqueValue;
import br.com.casadocodigo.models.Autor;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AutorDto {

    @NotNull @NotBlank @NotEmpty
    private String nome;
    @Email @NotNull @NotBlank @NotEmpty @UniqueValue(domainClass = Autor.class, fieldName = "email")
    private String email;
    @NotNull @Length(max = 400) @NotBlank @NotEmpty
    private String descricao;


    public AutorDto(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

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

        return new Autor(autorDto.getNome(), autorDto.getEmail(), autorDto.getDescricao());

    }



}
