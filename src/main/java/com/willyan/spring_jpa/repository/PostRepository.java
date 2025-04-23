package com.willyan.spring_jpa.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.willyan.spring_jpa.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long>{
	List<Post> findByCategoriasTituloAndAutorId(String categoria, Long autorId);
	
	List<Post> findByAutorNomeOrAutorSobrenome(String nome, String sobrenome);

	List<Post> findByTituloContainsOrderByAutorNomeAsc(String titulo);

	List<Post> findByDataPublicacaoIsGreaterThanEqual(LocalDate data);

	List<Post> findByDataPublicacaoIsNull();
}
