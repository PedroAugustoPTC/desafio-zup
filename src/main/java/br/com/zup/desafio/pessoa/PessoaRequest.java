package br.com.zup.desafio.pessoa;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

public class PessoaRequest {

	@NotBlank(message = "CPF não pode ser vazio")
	@CPF(message = "Formato de CPF inválido. " + "Exemplo de formato válido: 000.000.000-00")
	private String cpf;

	@NotBlank(message = "Nome não pode ser vazio")
	private String nome;

	@NotBlank(message = "Email não pode ser vazio")
	@Email(message = "Formato de email inválido. Exemplo de formato válido: xxxxxxx@xxxxxxx")
	private String email;

	@NotBlank(message = "Data de nascimento não pode ser vazio")
	private Date dataNascimento;
}
