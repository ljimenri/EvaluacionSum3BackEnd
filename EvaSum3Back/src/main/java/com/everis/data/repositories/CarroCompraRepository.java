package com.everis.data.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.everis.data.models.CarroCompra;

@Repository
public interface CarroCompraRepository extends JpaRepository<CarroCompra, Long> {
	@Modifying
	@Transactional
	@Query(value = "UPDATE carrocompras SET carrocompras.cantidad= :cantidad WHERE carrocompras.id = :id", nativeQuery = true)
	public void ActualizarProductoCarro(@Param("cantidad") String cantidad, @Param("id") Long id);
}
