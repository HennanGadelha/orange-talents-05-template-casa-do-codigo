package br.com.casadocodigo.controllers;


import br.com.casadocodigo.dtos.dtosRequest.PaisDtoRequest;
import br.com.casadocodigo.models.Pais;
import br.com.casadocodigo.repositories.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/paises")
public class PaisController {

    @Autowired
    PaisRepository paisRepository;

    @PostMapping
    public ResponseEntity<PaisDtoRequest> cadastroPais(@RequestBody @Valid PaisDtoRequest paisDtoRequest){

        Pais pais = paisDtoRequest.converterPaisDtoParaaPais(paisDtoRequest);
        paisRepository.save(pais);

        return  ResponseEntity.ok().body(paisDtoRequest);

    }

}
