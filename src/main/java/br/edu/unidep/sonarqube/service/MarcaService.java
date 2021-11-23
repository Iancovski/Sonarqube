package br.edu.unidep.sonarqube.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unidep.sonarqube.model.Marca;
import br.edu.unidep.sonarqube.repository.MarcaRepository;

@Service
public class MarcaService {
	
	@Autowired
	private MarcaRepository repository;
	
	/**************************************************/
	/********************* Create *********************/
	/**************************************************/
	
	public Marca create(Marca marca) {		
		return repository.save(marca);
	}
	
	/**************************************************/
	/********************* Update *********************/
	/**************************************************/
	
	public Marca update(Long id, Marca cliente) {
		Marca marcaSalva = repository.findOne(id);
		BeanUtils.copyProperties(cliente, marcaSalva, "id");
		return repository.save(marcaSalva);
	}
	
	/**************************************************/
	/******************* Find by ID *******************/
	/**************************************************/
	
	public Marca findById(Long id) {	
		return repository.findOne(id);
	}
	
	/**************************************************/
	/********************* Delete *********************/
	/**************************************************/
	
	public void delete(Long id) {
		repository.delete(id);
	}
}
