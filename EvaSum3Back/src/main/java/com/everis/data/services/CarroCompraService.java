package com.everis.data.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.everis.data.models.CarroCompra;
import com.everis.data.repositories.CarroCompraRepository;

@Service
public class CarroCompraService {

	@Autowired
	CarroCompraRepository ccRepository;

	public CarroCompra save(CarroCompra carrocompra) {
		return ccRepository.save(carrocompra);
	}

	public List<CarroCompra> allCarroCompra() {
		return (List<CarroCompra>) ccRepository.findAll();
	}

	public void deleteById(Long id) {
		ccRepository.deleteById(id);

	}

	public Optional<CarroCompra> findById(Long id) {
		Optional<CarroCompra> carrocompra = ccRepository.findById(id);
		return carrocompra;
	}

	public void actualizarCarroCompra(CarroCompra carroCompra) {

		ccRepository.save(carroCompra);

	}

	public void ActualizaCarro(String cantidad, Long id) {
		ccRepository.ActualizarProductoCarro(cantidad, id);
	}

	public Page<CarroCompra> productosPaginados(int numeroPagina, int cantElementos) {

		PageRequest pageRequest = PageRequest.of(numeroPagina, cantElementos);

		return ccRepository.findAll(pageRequest);
	}

}
