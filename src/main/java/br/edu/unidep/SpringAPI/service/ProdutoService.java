package br.edu.unidep.SpringAPI.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unidep.SpringAPI.model.Produto;
import br.edu.unidep.SpringAPI.repository.ProdutoRepository;

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
		Produto produto = repository.findOne(id);
		return produto;
	}
	
	/**************************************************/
	/********************* Delete *********************/
	/**************************************************/
	
	public void delete(Long id) {
		repository.delete(id);
	}
}
