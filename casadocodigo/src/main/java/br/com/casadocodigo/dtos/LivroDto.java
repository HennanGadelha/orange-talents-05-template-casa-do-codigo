package br.com.casadocodigo.dtos;

import br.com.casadocodigo.config.validacoes.ExistingId;
import br.com.casadocodigo.config.validacoes.UniqueValue;
import br.com.casadocodigo.models.Autor;
import br.com.casadocodigo.models.Categoria;
import br.com.casadocodigo.models.Livro;
import br.com.casadocodigo.repositories.AutorRepository;
import br.com.casadocodigo.repositories.CategoriaRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.OneToOne;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

public class LivroDto {

    @NotNull @NotBlank @NotEmpty @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;
    @NotNull @Length(max = 500)
    private String resumo;
    private String sumario;
    @Min(20) @NotNull
    private BigDecimal preco;
    @Min(100) @NotNull
    private Integer numeroPaginas;
    @NotNull @NotEmpty @NotBlank @UniqueValue(domainClass = Livro.class, fieldName = "isbn")
    private String isbn;
    @Future
    @JsonFormat(pattern = "dd/MM/yyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;

    @NotNull @ExistingId(domainClass = Autor.class,fieldName = "id")
    private Long idAutor;
    @NotNull @ExistingId(domainClass = Categoria.class,fieldName = "id")
    private Long idCategoria;


    public String getTitulo() {
        return titulo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public Long getIdAutor() {
        return idAutor;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public String getResumo() {
        return resumo;
    }

    public Livro converterLivroDtoParaLivro(LivroDto livroDto,
                                            AutorRepository autorRepository, CategoriaRepository categoriaRepository){

        Autor autor =  autorRepository.getOne(livroDto.getIdAutor());
        Categoria categoria = categoriaRepository.getOne(livroDto.getIdCategoria());

        return new Livro(livroDto.titulo,livroDto.getResumo(),livroDto.getSumario(),livroDto.getPreco(),livroDto.getNumeroPaginas(),
                livroDto.getIsbn(),livroDto.getDataPublicacao(), autor, categoria);
    }

}
