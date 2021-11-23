package br.edu.unidep.sonarqube.marca.unitario.mock;

import br.edu.unidep.sonarqube.model.Marca;

public class MarcaUT {	

	public Marca create(Marca marca) {
		Marca marcaCreated = new Marca();
		marcaCreated.setId(marca.getId());
		marcaCreated.setNome(marca.getNome());
		
		return marcaCreated;
	}
	
	public Marca update(Marca marca) {
		Marca marcaUpdated = new Marca();
		marcaUpdated.setId(marca.getId());
		marcaUpdated.setNome(marca.getNome());
		
		return marcaUpdated;
	}	
	
	public Marca findOne() {
		Marca marca = new Marca();
		marca.setId(1L);
		marca.setNome("Teste 1");
		
		return marca;
	}
}