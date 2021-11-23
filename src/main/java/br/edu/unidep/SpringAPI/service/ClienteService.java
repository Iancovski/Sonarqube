package br.edu.unidep.SpringAPI.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unidep.SpringAPI.model.Cliente;
import br.edu.unidep.SpringAPI.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	/**************************************************/
	/********************* Create *********************/
	/**************************************************/
	
	public Cliente create(Cliente venda) {		
		return repository.save(venda);
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
		Cliente cliente = repository.findOne(id);	
		return cliente;
	}
	
	/**************************************************/
	/********************* Delete *********************/
	/**************************************************/
	
	public void delete(Long id) {
		repository.delete(id);
	}
}
