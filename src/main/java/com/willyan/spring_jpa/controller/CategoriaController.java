package com.willyan.spring_jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.willyan.spring_jpa.entity.Categoria;
import com.willyan.spring_jpa.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService service;

	@PostMapping
	public List<Categoria> salvar(@RequestBody List<Categoria> categorias) {
		return service.save(categorias);
	}

	@GetMapping("/titulo/{titulo}")
	public Categoria getByTitulo(@PathVariable String titulo) {
		return service.findByTitulo(titulo);
	}

	@GetMapping("/titulos")
	public List<Categoria> getByTitulos(@RequestParam(name = "t") List<String> titulos) {
		return service.findByTitulos(titulos);
	}
	
	@GetMapping
	public List<Categoria> getCategoriasOrdenadasAsc() {
		return service.findAllOrderByTitulosAsc();
	}
}
