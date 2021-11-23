package br.edu.unidep.SpringAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unidep.SpringAPI.model.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Long> {

}
