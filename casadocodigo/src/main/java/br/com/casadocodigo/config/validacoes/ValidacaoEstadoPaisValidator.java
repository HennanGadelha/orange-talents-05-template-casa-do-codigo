package br.com.casadocodigo.config.validacoes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.casadocodigo.dtos.dtosRequest.ClienteDtoRequest;
import br.com.casadocodigo.models.Estado;
import br.com.casadocodigo.repositories.EstadoRepository;

@Component
public class ValidacaoEstadoPaisValidator implements Validator {

	@Autowired
	private EstadoRepository estadoRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return ClienteDtoRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub

		if (errors.hasErrors()) {
			return;
		}

		ClienteDtoRequest clienteDtoRequest = (ClienteDtoRequest) target;
		List<Estado> estados = estadoRepository.findByPaisId(clienteDtoRequest.getIdPais());

		if (estados.size() >= 1 && clienteDtoRequest.getIdEstado() == null) {
			errors.rejectValue("idEstado", null, "Selecione um estado");
		}

		if (clienteDtoRequest.getIdEstado() != null && paisSemEstado(estados, clienteDtoRequest)) {
			errors.rejectValue("idEstado", null, "Estado não localizado no país escolhido");
		}

	}

	private boolean paisSemEstado(List<Estado> estados, ClienteDtoRequest clienteDtoRequest) {
		// TODO Auto-generated method stub

		for (Estado estado : estados) {

			if (clienteDtoRequest.getIdEstado() == estado.getId())
				return false;
		}

		return true;
	}

}
