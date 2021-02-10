package br.com.zup.desafio.pessoa;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	private PessoaRepository repository;

	@PostMapping
	public ResponseEntity<String> cadastrar(@RequestBody @Valid PessoaRequest request,
			UriComponentsBuilder uriBuilder) {
		Pessoa pessoa = request.toModel();
		repository.save(pessoa);

		URI uri = uriBuilder.path("/pessoa/{id}").buildAndExpand(pessoa.getId()).toUri();
		return ResponseEntity.created(uri).body(pessoa.toString());
	}
}
