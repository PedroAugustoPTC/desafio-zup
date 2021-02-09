package br.com.zup.desafio.cadastro;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity(name = "tb_cadastro")
@Inheritance(strategy = InheritanceType.JOINED)
public class Cadastro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String nomeVacina;

	@NotBlank
	@Email
	private String emailUsuario;

	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate dataCadastro;

	public Cadastro(@NotBlank String nomeVacina, @NotBlank @Email String emailUsuario,
			@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING) LocalDate dataCadastro) {
		super();
		this.nomeVacina = nomeVacina;
		this.emailUsuario = emailUsuario;
		this.dataCadastro = dataCadastro;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
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

	@Override
	public String toString() {
		return "Cadastro [id=" + id + ", nome=" + nomeVacina + ", emailUsuario=" + emailUsuario + ", dataCadastro="
				+ dataCadastro + "]";
	}

}
