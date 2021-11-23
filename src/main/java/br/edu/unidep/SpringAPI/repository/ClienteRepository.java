package br.edu.unidep.SpringAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unidep.SpringAPI.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
