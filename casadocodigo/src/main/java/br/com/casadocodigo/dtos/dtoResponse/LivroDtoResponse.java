package br.com.casadocodigo.dtos.dtoResponse;

import br.com.casadocodigo.models.Livro;
import org.springframework.data.domain.Page;

public class LivroDtoResponse {


    private Long id;
    private String titulo;


    public LivroDtoResponse(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public static Page<LivroDtoResponse> converterPageLivrosParaLivrosDtoResponsse(Page<Livro> livros){
        return livros.map(LivroDtoResponse::new);
    }

}
