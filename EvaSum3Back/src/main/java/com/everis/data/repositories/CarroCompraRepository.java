package com.everis.data.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.everis.data.models.CarroCompra;

@Repository
public interface CarroCompraRepository extends CrudRepository<CarroCompra, Long> {

}
