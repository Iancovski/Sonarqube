package br.edu.unidep.sonarqube.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unidep.sonarqube.model.Produto;
import br.edu.unidep.sonarqube.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repository;
	
	/**************************************************/
	/********************* Create *********************/
	/**************************************************/
	
	public Produto create(Produto produto) {		
		return repository.save(produto);
	}
	
	/**************************************************/
	/********************* Update *********************/
	/**************************************************/
	
	public Produto update(Long id, Produto produto) {
		Produto produtoSalvo = repository.findOne(id);
		BeanUtils.copyProperties(produto, produtoSalvo, "id");		
		return repository.save(produtoSalvo);
	}
	
	/**************************************************/
	/******************* Find by ID *******************/
	/**************************************************/
	
	public Produto findById(Long id) {
		return repository.findOne(id);
	}
	
	/**************************************************/
	/********************* Delete *********************/
	/**************************************************/
	
	public void delete(Long id) {
		repository.delete(id);
	}
}
