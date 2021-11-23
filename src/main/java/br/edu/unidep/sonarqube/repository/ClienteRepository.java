package br.edu.unidep.sonarqube.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unidep.sonarqube.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
