package com.willyan.spring_jpa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.willyan.spring_jpa.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

	Optional<Categoria> findByTitulo(String titulo);

	List<Categoria> findByTituloStartingWith(String titulo);

	List<Categoria> findByTituloIn(List<String> titulos);

	List<Categoria> findByOrderByTituloAsc();
}