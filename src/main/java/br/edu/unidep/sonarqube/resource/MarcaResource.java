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
import br.edu.unidep.sonarqube.model.Marca;
import br.edu.unidep.sonarqube.service.MarcaService;

@RestController
@RequestMapping("/marcas")
public class MarcaResource {

	@Autowired
	private MarcaService marcaService;
	
	@Autowired
	private ApplicationEventPublisher publisher;

	// POST
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Marca> create(@Valid @RequestBody Marca marca, HttpServletResponse response) {		
		Marca marcaSalvo = marcaService.create(marca);
		
		publisher.publishEvent(new ObjetoCriadoEvent(this, response, marcaSalvo.getId()));
	
		return ResponseEntity.status(HttpStatus.CREATED).body(marca);
	}
	
	// PUT
	
	@PutMapping("/{id}")
	public ResponseEntity<Marca> update(@PathVariable Long id, @Valid @RequestBody Marca marca) {
		Marca marcaSalvo = marcaService.update(id, marca);
	
		return ResponseEntity.ok(marcaSalvo);
	}
	
	// GET
	
	@GetMapping("/{id}")
	public ResponseEntity<Marca> findById(@PathVariable Long id) {		
		Marca marca = marcaService.findById(id);
		
		if (marca != null) {
			return ResponseEntity.ok(marca);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	// DELETE

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		marcaService.delete(id);
	}
}