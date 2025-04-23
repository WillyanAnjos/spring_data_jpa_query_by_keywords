package com.willyan.spring_jpa.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.willyan.spring_jpa.entity.Autor;
import com.willyan.spring_jpa.entity.Categoria;
import com.willyan.spring_jpa.entity.Post;
import com.willyan.spring_jpa.repository.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;
	
	@Autowired
	private AutorService autorService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Transactional
	public Post save(Post post) {
		Autor autor = this.autorService.findById(post.getAutor().getId());
		post.setAutor(autor);
		
		List<String> titulos = post.getCategorias().stream().map(Categoria::getTitulo).toList();
		List<Categoria> categorias = this.categoriaService.findByTitulos(titulos);
		post.setCategorias(categorias);
		
		return this.repository.save(post);
	}
	
	@Transactional(readOnly = true)
	public List<Post> findAllByCategoriaAndAutorId(String categoria, Long autorId) {
		return this.repository.findByCategoriasTituloAndAutorId(categoria,autorId);
	} 
	
	@Transactional(readOnly = true)
	public List<Post> findAllByAutor(String nome, String sobrenome) {
		return this.repository.findByAutorNomeOrAutorSobrenome(nome, sobrenome);
	}
	
	@Transactional(readOnly = true)
	public List<Post> findAllByTitulo(String titulo) {
		return this.repository.findByTituloContainsOrderByAutorNomeAsc(titulo);
	}
	
	@Transactional(readOnly = true)
	public List<Post> findAllByDataPublicacaoMaiorOuIgual(LocalDate data) {
		return this.repository.findByDataPublicacaoIsGreaterThanEqual(data);
	}
	
	@Transactional(readOnly = true)
	public List<Post> findAllBySemDataPublicacao() {
		return this.repository.findByDataPublicacaoIsNull();
	}
}
