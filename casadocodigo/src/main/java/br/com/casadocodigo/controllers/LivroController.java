package br.com.casadocodigo.controllers;

import br.com.casadocodigo.dtos.dtoResponse.LivroDtoResponse;
import br.com.casadocodigo.dtos.dtosRequest.LivroDto;
import br.com.casadocodigo.models.Livro;
import br.com.casadocodigo.repositories.AutorRepository;
import br.com.casadocodigo.repositories.CategoriaRepository;
import br.com.casadocodigo.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping(value="/livros")
public class LivroController {

    @Autowired
    LivroRepository livroRepository;

    @Autowired AutorRepository autorRepository;
    @Autowired CategoriaRepository categoriaRepository;

    @PostMapping
    public ResponseEntity<LivroDto> inserindoLivro(@RequestBody @Valid LivroDto livroDto){

        Livro livro = livroDto.converterLivroDtoParaLivro(livroDto, autorRepository, categoriaRepository);
        livro = livroRepository.save(livro);
        return ResponseEntity.ok().body(livroDto);

    }


    @GetMapping
    public Page<LivroDtoResponse> listaLivros(@PageableDefault(page = 0, size = 5, sort = "id",
            direction = Sort.Direction.DESC) Pageable pageable){

        Page<Livro> livros = livroRepository.findAll(pageable);

        return LivroDtoResponse.converterPageLivrosParaLivrosDtoResponsse(livros);

    }

}
