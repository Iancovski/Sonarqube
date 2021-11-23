package br.edu.unidep.sonarqube.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unidep.sonarqube.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
