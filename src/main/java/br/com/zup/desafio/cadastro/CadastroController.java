package br.com.zup.desafio.cadastro;

import java.net.URI;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/cadastro")
public class CadastroController {

	@PersistenceContext
	private EntityManager entityManager;

	@PostMapping
	@Transactional
	public ResponseEntity<String> cadastrar(@RequestBody @Valid CadastroRequest request,
			UriComponentsBuilder uriBuilder) {
		Cadastro cadastro = request.toModel();
		entityManager.persist(cadastro);

		URI uri = uriBuilder.path("/cadastro/{id}").buildAndExpand(cadastro.getId()).toUri();
		return ResponseEntity.created(uri).body(cadastro.toString());
	}
}
