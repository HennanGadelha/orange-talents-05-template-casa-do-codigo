package br.com.casadocodigo.controllers;

import br.com.casadocodigo.dtos.dtosRequest.AutorDto;
import br.com.casadocodigo.models.Autor;
import br.com.casadocodigo.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/autores")
public class AutorController {

    @Autowired
    AutorRepository autorRepository;

    @PostMapping
    public ResponseEntity<AutorDto> inserirAutor(@RequestBody  @Valid  AutorDto autorDto){

        Autor autor = autorDto.converterAutor(autorDto);
        autor = autorRepository.save(autor);

            return ResponseEntity.ok().body(autorDto);

    }
}
