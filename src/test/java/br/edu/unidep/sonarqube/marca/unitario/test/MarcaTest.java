package br.edu.unidep.sonarqube.marca.unitario.test;

import org.junit.jupiter.api.Assertions;

import br.edu.unidep.sonarqube.marca.unitario.mock.MarcaUT;
import br.edu.unidep.sonarqube.model.Marca;

public class MarcaTest {
	
	MarcaUT unitario = new MarcaUT();
	
	@org.junit.Test
	public void shouldValidCreateMarcaObject() {
		Marca marca = new Marca();
		marca.setId(1L);
		marca.setNome("Teste 1");
		
		Marca marcaCreated = unitario.create(marca);
		
		Assertions.assertEquals(1L, marcaCreated.getId());
		Assertions.assertEquals("Teste 1", marcaCreated.getNome());
	}
	
	@org.junit.Test
	public void shouldValidUpdateMarcaObject() {
		Marca marca = new Marca();
		marca.setId(2L);
		marca.setNome("Teste 2");
		
		Marca marcaUpdated = unitario.update(marca);
		
		Assertions.assertEquals(2L, marcaUpdated.getId());
		Assertions.assertEquals("Teste 2", marcaUpdated.getNome());	
	}

	@org.junit.Test
	public void shouldValidFindMarcaObject() {
		Marca marca = unitario.findOne();
		
		Assertions.assertEquals(1L, marca.getId());
		Assertions.assertEquals("Teste 1", marca.getNome());	
	}
}