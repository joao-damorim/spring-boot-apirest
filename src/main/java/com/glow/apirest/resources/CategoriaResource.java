package com.glow.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glow.apirest.models.Categoria;
import com.glow.apirest.repository.CategoriaRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value="/api")
@Api(value="API REST Glow")
@CrossOrigin(origins = "*")
public class CategoriaResource {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@GetMapping("/categories")
	@ApiOperation(value="Retorna lista de categorias")
	public List<Categoria> listaCategorias(){	
		return categoriaRepository.findAll();	
	}
	@GetMapping("/categorie/{id}")
	@ApiOperation(value="Retorna uma categoria")
	public Categoria listaCategoriaUnico(@PathVariable(value="id") long id) {	
		return categoriaRepository.findById(id);
	}
	@PostMapping("/categorie")
	@ApiOperation(value="Salva uma categoria")
	public Categoria salvaCategoria(@RequestBody Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	@DeleteMapping("/categorie")
	@ApiOperation(value="Deleta uma categoria")
	public void deletaCategoria(@RequestBody Categoria categoria) {
		categoriaRepository.delete(categoria);
	}
	@PutMapping("/categorie")
	@ApiOperation(value="Atualiza uma categoria")
	public Categoria atualizaCategoria(@RequestBody Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

}
