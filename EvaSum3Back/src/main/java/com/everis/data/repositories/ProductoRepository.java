package com.everis.data.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.everis.data.models.Producto;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long> {

}
