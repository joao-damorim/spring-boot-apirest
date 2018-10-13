package com.glow.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glow.apirest.models.Categoria;
import com.glow.apirest.repository.CategoriaRepository;


@RestController
@RequestMapping(value="/api")
public class CategoriaResource {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@GetMapping("/categories")
	public List<Categoria> listaCategorias(){	
		return categoriaRepository.findAll();	
	}
	@GetMapping("/categorie/{id}")
	public Categoria listaCategoriaUnico(@PathVariable(value="id") long id) {	
		return categoriaRepository.findById(id);
	}
	@PostMapping("/categorie")
	public Categoria salvaCategoria(@RequestBody Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

}
