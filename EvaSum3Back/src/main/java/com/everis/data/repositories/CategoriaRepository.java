package com.everis.data.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.everis.data.models.Categoria;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long> {

}
