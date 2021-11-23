package br.edu.unidep.sonarqube.produto.unitario.mock;

import br.edu.unidep.sonarqube.model.Marca;
import br.edu.unidep.sonarqube.model.Produto;

public class ProdutoUT {	

	public Produto create(Produto produto) {
		Marca marca = new Marca();
		marca.setId(1L);
		marca.setNome("Teste 1");
		
		Produto produtoCreated = new Produto();
		produtoCreated.setId(produto.getId());
		produtoCreated.setNome(produto.getNome());
		produtoCreated.setMarca(produto.getMarca());
		
		return produtoCreated;
	}
	
	public Produto update(Produto produto) {
		Marca marca = new Marca();
		marca.setId(1L);
		marca.setNome("Teste 1");
		
		Produto produtoUpdated = new Produto();
		produtoUpdated.setId(produto.getId());
		produtoUpdated.setNome(produto.getNome());
		produtoUpdated.setMarca(produto.getMarca());
		
		return produtoUpdated;
	}
	
	public Produto findOne() {
		Marca marca = new Marca();
		marca.setId(1L);
		marca.setNome("Teste 1");
		
		Produto produto = new Produto();
		produto.setId(1L);
		produto.setNome("Teste 1");
		produto.setMarca(marca);
		
		return produto;
	}
}