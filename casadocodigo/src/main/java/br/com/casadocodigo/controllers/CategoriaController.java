package br.com.casadocodigo.controllers;

import br.com.casadocodigo.config.validacoes.ImpedeNomeDuplicadoValidator;
import br.com.casadocodigo.dtos.CategoriaDto;
import br.com.casadocodigo.models.Categoria;
import br.com.casadocodigo.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    ImpedeNomeDuplicadoValidator impedeNomeDuplicadoValidator;

    @InitBinder
    public void init(WebDataBinder webDataBinder){
        webDataBinder.addValidators(impedeNomeDuplicadoValidator);
    }

    @PostMapping
    public ResponseEntity<CategoriaDto> inserirCategoria(@RequestBody @Valid CategoriaDto categoriaDto){

        Categoria categoria = categoriaDto.converterCategoriaDtoParaCategoria(categoriaDto);
        categoria = categoriaRepository.save(categoria);
        return ResponseEntity.ok().body(categoriaDto);
    }


}
