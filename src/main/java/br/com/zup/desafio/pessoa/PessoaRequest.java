package br.com.zup.desafio.pessoa;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zup.desafio.config.validacao.UniqueValue;

public class PessoaRequest {

	@NotBlank
	@CPF
	@UniqueValue(fieldName = "cpf", domainClass = Pessoa.class)
	private String cpf;

	@NotBlank
	private String nome;

	@NotBlank
	@Email
	@UniqueValue(fieldName = "email", domainClass = Pessoa.class)
	private String email;

	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate dataNascimento;

	public Pessoa toModel() {
		Pessoa pessoa = new Pessoa(this.cpf, this.nome, this.email, this.dataNascimento);
		return pessoa;
	}

	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the dataNascimento
	 */
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

}
