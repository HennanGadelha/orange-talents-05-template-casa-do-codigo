package br.com.casadocodigo.controllers;

import br.com.casadocodigo.dtos.LivroDto;
import br.com.casadocodigo.models.Livro;
import br.com.casadocodigo.repositories.AutorRepository;
import br.com.casadocodigo.repositories.CategoriaRepository;
import br.com.casadocodigo.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
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

}
