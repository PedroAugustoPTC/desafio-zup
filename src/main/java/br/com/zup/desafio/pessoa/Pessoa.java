package br.com.zup.desafio.pessoa;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

@Entity(name = "tb_pessoa")
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

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

	
	public Pessoa(Long id,
			@NotBlank(message = "CPF não pode ser vazio") @CPF(message = "Formato de CPF inválido. Exemplo de formato válido: 000.000.000-00") String cpf,
			@NotBlank(message = "Nome não pode ser vazio") String nome,
			@NotBlank(message = "Email não pode ser vazio") @Email(message = "Formato de email inválido. Exemplo de formato válido: xxxxxxx@xxxxxxx") String email,
			@NotBlank(message = "Data de nascimento não pode ser vazio") Date dataNascimento) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
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
	public Date getDataNascimento() {
		return dataNascimento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (dataNascimento == null) {
			if (other.dataNascimento != null)
				return false;
		} else if (!dataNascimento.equals(other.dataNascimento))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
