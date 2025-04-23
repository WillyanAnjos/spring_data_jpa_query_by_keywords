package com.willyan.spring_jpa.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.willyan.spring_jpa.entity.Post;
import com.willyan.spring_jpa.service.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {
	
	@Autowired
	private PostService service;
	
	@PostMapping
	public Post salvar(@RequestBody Post post) {
		return this.service.save(post);
	}
	
	@GetMapping("categoria/{categoria}/autor/{autorId}")
	public List<Post> getByCategoriaAndAutorId(@PathVariable String categoria, @PathVariable Long autorId) {
		return this.service.findAllByCategoriaAndAutorId(categoria, autorId);
	}
	
	@GetMapping("autor/{nome}/{sobrenome}")
	public List<Post> getByAutor(@PathVariable String nome, @PathVariable String sobrenome) {
		return this.service.findAllByAutor(nome, sobrenome);
	}
	
	@GetMapping("titulo/{titulo}")
	public List<Post> getByTitulo(@PathVariable String titulo) {
		return this.service.findAllByTitulo(titulo);
	}
	
	@GetMapping("data-publicacao/{data}")
	public List<Post> getByDataPublicacao(@PathVariable LocalDate data) {
		return this.service.findAllByDataPublicacaoMaiorOuIgual(data);
	}
	
	@GetMapping("sem-data-publicacao")
	public List<Post> getByDataPublicacaoNull() {
		return this.service.findAllBySemDataPublicacao();
	}
}
