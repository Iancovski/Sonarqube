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
import br.edu.unidep.sonarqube.model.Cliente;
import br.edu.unidep.sonarqube.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private ApplicationEventPublisher publisher;


	// POST

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Cliente> create(@Valid @RequestBody Cliente cliente, HttpServletResponse response) {
		Cliente clienteSalvo = clienteService.create(cliente);

		publisher.publishEvent(new ObjetoCriadoEvent(this, response, clienteSalvo.getId()));

		return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
	}

	// PUT

	@PutMapping("/{id}")
	public ResponseEntity<Cliente> update(@PathVariable Long id, @Valid @RequestBody Cliente cliente) {
		Cliente clienteSalvo = clienteService.update(id, cliente);

		return ResponseEntity.ok(clienteSalvo);
	}

	// GET

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable Long id) {
		Cliente cliente = clienteService.findById(id);

		if (cliente != null) {
			return ResponseEntity.ok(cliente);
		}

		return ResponseEntity.notFound().build();
	}

	// DELETE

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		clienteService.delete(id);
	}
	
}