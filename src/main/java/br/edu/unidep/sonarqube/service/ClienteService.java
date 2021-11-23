package br.edu.unidep.sonarqube.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unidep.sonarqube.model.Cliente;
import br.edu.unidep.sonarqube.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	/**************************************************/
	/********************* Create *********************/
	/**************************************************/
	
	public Cliente create(Cliente cliente) {		
		return repository.save(cliente);
	}
	
	/**************************************************/
	/********************* Update *********************/
	/**************************************************/
	
	public Cliente update(Long id, Cliente cliente) {
		Cliente clienteSalvo = repository.findOne(id);
		
		BeanUtils.copyProperties(cliente, clienteSalvo, "id");
		
		return repository.save(clienteSalvo);
	}
	
	/**************************************************/
	/******************* Find by ID *******************/
	/**************************************************/
	
	public Cliente findById(Long id) {
		return repository.findOne(id);
	}
	
	/**************************************************/
	/********************* Delete *********************/
	/**************************************************/
	
	public void delete(Long id) {
		repository.delete(id);
	}
}
