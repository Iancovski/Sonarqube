package br.edu.unidep.sonarqube.cliente.unitario.test;

import org.junit.jupiter.api.Assertions;

import br.edu.unidep.sonarqube.cliente.unitario.mock.ClienteUT;
import br.edu.unidep.sonarqube.model.Cliente;


public class ClienteTest {
	
	ClienteUT unitario = new ClienteUT();
	
	@org.junit.Test
	public void shouldValidCreateClienteObject() {
		Cliente cliente = new Cliente();
		cliente.setId(1L);
		cliente.setNome("Teste 1");
		cliente.setCpf("111.111.111-11");
		
		Cliente clienteCreated = unitario.create(cliente);
		
		Assertions.assertEquals(1L, clienteCreated.getId());
		Assertions.assertEquals("Teste 1", clienteCreated.getNome());
		Assertions.assertEquals("111.111.111-11", clienteCreated.getCpf());	
	}
	
	@org.junit.Test
	public void shouldValidUpdateClienteObject() {
		Cliente cliente = new Cliente();
		cliente.setId(2L);
		cliente.setNome("Teste 2");
		cliente.setCpf("222.222.222-22");
		
		Cliente clienteUpdated = unitario.update(cliente);
		
		Assertions.assertEquals(2L, clienteUpdated.getId());
		Assertions.assertEquals("Teste 2", clienteUpdated.getNome());
		Assertions.assertEquals("222.222.222-22", clienteUpdated.getCpf());	
	}

	
	@org.junit.Test
	public void shouldValidFindClienteObject() {
		Cliente cliente = unitario.findOne();
		
		Assertions.assertEquals(1L, cliente.getId());
		Assertions.assertEquals("Teste 1", cliente.getNome());
		Assertions.assertEquals("111.111.111-11", cliente.getCpf());	
	}
	
}
