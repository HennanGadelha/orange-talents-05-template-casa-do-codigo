package br.com.casadocodigo.models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @OneToMany
    List<Livro> livros = new ArrayList<>();

    @Deprecated
    public Categoria(){}

    public Categoria(String nome) {
        this.nome = nome;
    }
}
