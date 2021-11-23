package br.edu.unidep.sonarqube.produto.unitario.test;

import org.junit.jupiter.api.Assertions;

import br.edu.unidep.sonarqube.model.Marca;
import br.edu.unidep.sonarqube.model.Produto;
import br.edu.unidep.sonarqube.produto.unitario.mock.ProdutoUT;


public class ProdutoTest {
	
	ProdutoUT unitario = new ProdutoUT();
	
	@org.junit.Test
	public void shouldValidCreateProdutoObject() {
		Marca marca = new Marca();
		marca.setId(1L);
		marca.setNome("Teste 1");
		
		Produto produto = new Produto();
		produto.setId(1L);
		produto.setNome("Teste 1");
		produto.setMarca(marca);
		
		Produto produtoCreated = unitario.create(produto);
		
		Assertions.assertEquals(1L, produtoCreated.getId());
		Assertions.assertEquals("Teste 1", produtoCreated.getNome());
		Assertions.assertEquals(1L, produtoCreated.getMarca().getId());
		Assertions.assertEquals("Teste 1", produtoCreated.getMarca().getNome());	
	}
	
	@org.junit.Test
	public void shouldValidUpdateProdutoObject() {
		Marca marca = new Marca();
		marca.setId(2L);
		marca.setNome("Teste 2");
		
		Produto produto = new Produto();
		produto.setId(2L);
		produto.setNome("Teste 2");
		produto.setMarca(marca);
		
		Produto produtoUpdated = unitario.update(produto);
		
		Assertions.assertEquals(2L, produtoUpdated.getId());
		Assertions.assertEquals("Teste 2", produtoUpdated.getNome());
		Assertions.assertEquals(2L, produtoUpdated.getMarca().getId());
		Assertions.assertEquals("Teste 2", produtoUpdated.getMarca().getNome());	
	}

	
	@org.junit.Test
	public void shouldValidFindProdutoObject() {
		Marca marca = new Marca();
		marca.setId(1L);
		marca.setNome("Teste 1");
		
		Produto produto = unitario.findOne();
		
		Assertions.assertEquals(1L, produto.getId());
		Assertions.assertEquals("Teste 1", produto.getNome());
		Assertions.assertEquals(1L, produto.getMarca().getId());
		Assertions.assertEquals("Teste 1", produto.getMarca().getNome());
	}
	
}
