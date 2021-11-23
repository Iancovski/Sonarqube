package br.edu.unidep.sonarqube.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unidep.sonarqube.model.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Long> {

}
