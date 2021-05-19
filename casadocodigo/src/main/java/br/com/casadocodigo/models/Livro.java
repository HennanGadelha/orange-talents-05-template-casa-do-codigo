package br.com.casadocodigo.models;

import br.com.casadocodigo.dtos.LivroDto;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private Integer numeroPaginas;
    private String isbn;
    private LocalDate dataPublicacao;
    @OneToOne
    private Categoria categoria;
    @OneToOne
    private Autor autor;

    public Livro(){}

    public Livro(String titulo, String resumo, String sumario, BigDecimal preco, Integer numeroPaginas, String isbn, LocalDate dataPublicacao,
                  Autor autor, Categoria categoria) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }


}
