package com.glow.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.glow.apirest.models.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	
	Categoria findById(long id);

}
