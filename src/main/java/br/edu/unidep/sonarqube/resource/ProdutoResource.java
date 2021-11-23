package br.edu.unidep.sonarqube.resource;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unidep.sonarqube.event.ObjetoCriadoEvent;
import br.edu.unidep.sonarqube.model.Produto;
import br.edu.unidep.sonarqube.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoResource {

	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private ApplicationEventPublisher publisher;

	// POST
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Produto> create(@Valid @RequestBody Produto produto, HttpServletResponse response) {		
		Produto produtoSalvo = produtoService.create(produto);
		
		publisher.publishEvent(new ObjetoCriadoEvent(this, response, produtoSalvo.getId()));
	
		return ResponseEntity.status(HttpStatus.CREATED).body(produto);
	}
	
	// PUT
	
	@PutMapping("/{id}")
	public ResponseEntity<Produto> update(@PathVariable Long id, @Valid @RequestBody Produto produto) {
		Produto produtoSalvo = produtoService.update(id, produto);
	
		return ResponseEntity.ok(produtoSalvo);
	}
	
	// GET
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> findById(@PathVariable Long id) {		
		Produto produto = produtoService.findById(id);
		
		if (produto != null) {
			return ResponseEntity.ok(produto);
		}
		
		return ResponseEntity.notFound().build();
	}

	// DELETE

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		produtoService.delete(id);
	}
}
