package br.edu.unidep.sonarqube.cliente.unitario.mock;

import br.edu.unidep.sonarqube.model.Cliente;

public class ClienteUT {	

	public Cliente create(Cliente cliente) {
		Cliente clienteCreated = new Cliente();
		clienteCreated.setId(cliente.getId());
		clienteCreated.setNome(cliente.getNome());
		clienteCreated.setCpf(cliente.getCpf());
		
		return clienteCreated;
	}
	
	public Cliente update(Cliente cliente) {
		Cliente clienteUpdated = new Cliente();
		clienteUpdated.setId(cliente.getId());
		clienteUpdated.setNome(cliente.getNome());
		clienteUpdated.setCpf(cliente.getCpf());
		
		return clienteUpdated;
	}	
	
	public Cliente findOne() {
		Cliente cliente = new Cliente();
		cliente.setId(1L);
		cliente.setNome("Teste 1");
		cliente.setCpf("111.111.111-11");
		
		return cliente;
	}
}