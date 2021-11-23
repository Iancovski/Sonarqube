package br.edu.unidep.SpringAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unidep.SpringAPI.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
