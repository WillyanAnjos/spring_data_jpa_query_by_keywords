package com.willyan.spring_jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.willyan.spring_jpa.entity.Categoria;
import com.willyan.spring_jpa.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repository;
	
	@Transactional
	public List<Categoria> save(List<Categoria> categorias) {
		return repository.saveAll(categorias);
	}
	
	@Transactional(readOnly = true)
	public Categoria findByTitulo(String titulo) {
		return repository.findByTitulo(titulo).orElse(null);
	}
	
	@Transactional(readOnly = true)
	public List<Categoria> findByInicioTitulo(String titulo) {
		return repository.findByTituloStartingWith(titulo);
	}
	
	@Transactional(readOnly = true)
	public List<Categoria> findByTitulos(List<String> titulos) {
		return repository.findByTituloIn(titulos);
	}
	
	@Transactional(readOnly = true)
	public List<Categoria> findAllOrderByTitulosAsc() {
		return repository.findByOrderByTituloAsc();
	}
}
