package br.com.casadocodigo.dtos.dtoResponse;

import br.com.casadocodigo.dtos.dtosRequest.AutorDto;
import br.com.casadocodigo.models.Livro;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroDtoDetalhesResponse {

    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private String isbn;
    private Integer numeroPaginas;
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;
    private AutorDtoResponse autor;
    private String categoria;

    public  LivroDtoDetalhesResponse(Livro livro){

        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.isbn = livro.getIsbn();
        this.numeroPaginas = livro.getNumeroPaginas();
        this.dataPublicacao = livro.getDataPublicacao();
        this.autor = new AutorDtoResponse((livro.getAutor().getNome()));
        this.categoria= livro.getCategoria().getNome();


    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
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

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public AutorDtoResponse getAutor() {
        return autor;
    }

    public String getCategoria() {
        return categoria;
    }
}
