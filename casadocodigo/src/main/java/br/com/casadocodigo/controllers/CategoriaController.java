package br.com.casadocodigo.controllers;

import br.com.casadocodigo.dtos.dtosRequest.CategoriaDto;
import br.com.casadocodigo.models.Categoria;
import br.com.casadocodigo.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

    @Autowired
    CategoriaRepository categoriaRepository;

    @PostMapping
    public ResponseEntity<CategoriaDto> inserirCategoria(@RequestBody @Valid CategoriaDto categoriaDto){

        Categoria categoria = categoriaDto.converterCategoriaDtoParaCategoria(categoriaDto);
        categoria = categoriaRepository.save(categoria);
        return ResponseEntity.ok().body(categoriaDto);
    }


}
