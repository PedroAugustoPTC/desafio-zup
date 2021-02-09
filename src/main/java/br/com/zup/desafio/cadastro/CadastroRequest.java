package br.com.zup.desafio.cadastro;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zup.desafio.config.validacao.Exists;
import br.com.zup.desafio.pessoa.Pessoa;

public class CadastroRequest {

	@NotBlank
	private String nomeVacina;

	@NotBlank
	@Email
	@Exists(classe = Pessoa.class, campo = "email")
	private String emailUsuario;

	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate dataCadastro;

	public Cadastro toModel() {
		Cadastro cadastro = new Cadastro(this.nomeVacina, this.emailUsuario, this.dataCadastro);
		return cadastro;
	}

	/**
	 * @return the nomeVacina
	 */
	public String getNomeVacina() {
		return nomeVacina;
	}

	/**
	 * @return the emailUsuario
	 */
	public String getEmailUsuario() {
		return emailUsuario;
	}

	/**
	 * @return the dataCadastro
	 */
	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

}
