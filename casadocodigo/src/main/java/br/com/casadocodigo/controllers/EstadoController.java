package br.com.casadocodigo.controllers;

import br.com.casadocodigo.config.validacoes.ValidacaoEstadoPorPais;
import br.com.casadocodigo.dtos.dtosRequest.EstadoDto;
import br.com.casadocodigo.models.Estado;
import br.com.casadocodigo.repositories.EstadoRepository;
import br.com.casadocodigo.repositories.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/estados")
public class EstadoController {

	@Autowired
	EstadoRepository estadoRepository;

	@Autowired
	PaisRepository paisRepository;

	@Autowired
	ValidacaoEstadoPorPais validacaoEstadoPorPais;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(validacaoEstadoPorPais);
	}

	@PostMapping
	public ResponseEntity<EstadoDto> cadastrarEstado(@RequestBody @Valid EstadoDto estadoDto) {

		Estado estado = estadoDto.converterEstadoDtoParaEstado(estadoDto, paisRepository);
		estadoRepository.save(estado);
		return ResponseEntity.ok().body(estadoDto);

	}

}
