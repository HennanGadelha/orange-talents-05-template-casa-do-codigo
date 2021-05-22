package br.com.casadocodigo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.casadocodigo.config.validacoes.ValidacaoEstadoPaisValidator;
import br.com.casadocodigo.dtos.dtosRequest.ClienteDtoRequest;
import br.com.casadocodigo.models.Cliente;
import br.com.casadocodigo.repositories.ClienteRepository;
import br.com.casadocodigo.repositories.EstadoRepository;
import br.com.casadocodigo.repositories.PaisRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	PaisRepository paisRepository;
	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private ValidacaoEstadoPaisValidator validacaoEstadoPaisValidator;

	@InitBinder
	public void init(WebDataBinder binder) {

		binder.addValidators(validacaoEstadoPaisValidator);

	}

	@PostMapping
	public ResponseEntity<ClienteDtoRequest> cadastrarCliente(@RequestBody @Valid ClienteDtoRequest clienteDtoRequest) {

		Cliente cliente = clienteDtoRequest.converterClienteDtoParaCliente(clienteDtoRequest, paisRepository,
				estadoRepository);

		cliente = clienteRepository.save(cliente);

		return ResponseEntity.ok().body(clienteDtoRequest);
	}

}
