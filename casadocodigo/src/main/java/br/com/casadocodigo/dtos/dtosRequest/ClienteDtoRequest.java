package br.com.casadocodigo.dtos.dtosRequest;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.casadocodigo.config.validacoes.CpfOuCnpj;
import br.com.casadocodigo.config.validacoes.ExistingId;
import br.com.casadocodigo.config.validacoes.UniqueValue;
import br.com.casadocodigo.models.Cliente;
import br.com.casadocodigo.models.Estado;
import br.com.casadocodigo.models.Pais;
import br.com.casadocodigo.repositories.EstadoRepository;
import br.com.casadocodigo.repositories.PaisRepository;

public class ClienteDtoRequest {

	@Email
	@NotNull
	@NotBlank
	@NotEmpty
	@UniqueValue(domainClass = Cliente.class, fieldName = "email")
	private String email;

	@NotEmpty
	@NotNull
	@NotBlank
	private String nome;

	@NotEmpty
	@NotNull
	@NotBlank
	private String sobrenome;

	@NotNull
	@NotBlank
	@NotEmpty
	@CpfOuCnpj
	@UniqueValue(domainClass = Cliente.class, fieldName = "documento")
	private String documento;

	@NotEmpty
	@NotNull
	@NotBlank
	private String endereco;

	@NotEmpty
	@NotNull
	@NotBlank
	private String complemento;

	@NotEmpty
	@NotNull
	@NotBlank
	private String cidade;

	@ExistingId(domainClass = Pais.class, fieldName = "id")
	private Long idPais;

	
	private Long idEstado;

	@NotEmpty
	@NotNull
	@NotBlank
	private String telefone;

	@NotEmpty
	@NotNull
	@NotBlank
	private String cep;

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getDocumento() {
		return documento;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public Long getIdPais() {
		return idPais;
	}

	public Long getIdEstado() {
		return idEstado;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}

	public Cliente converterClienteDtoParaCliente(ClienteDtoRequest clienteDtoRequest, PaisRepository paisRepository,
			EstadoRepository estadoRepository) {

		Pais pais = paisRepository.getOne(clienteDtoRequest.getIdPais());

		if (clienteDtoRequest.getIdEstado() == null) {

			return new Cliente(clienteDtoRequest.getEmail(), clienteDtoRequest.getNome(),
					clienteDtoRequest.getSobrenome(), clienteDtoRequest.getDocumento(), clienteDtoRequest.getEndereco(),
					clienteDtoRequest.getComplemento(), clienteDtoRequest.getCidade(), pais, null,
					clienteDtoRequest.getTelefone(), clienteDtoRequest.getCep());

		}

		Estado estado = estadoRepository.getOne(clienteDtoRequest.getIdEstado());

		return new Cliente(clienteDtoRequest.getEmail(), clienteDtoRequest.getNome(), clienteDtoRequest.getSobrenome(),
				clienteDtoRequest.getDocumento(), clienteDtoRequest.getEndereco(), clienteDtoRequest.getComplemento(),
				clienteDtoRequest.getCidade(), pais, estado, clienteDtoRequest.getTelefone(),
				clienteDtoRequest.getCep());

	}

}
