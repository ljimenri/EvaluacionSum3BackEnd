package com.everis.data.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.data.models.Producto;
import com.everis.data.repositories.ProductoRepository;

@Service
public class ProductoService {

	@Autowired
	ProductoRepository pRepository;

	public Producto guardarProducto(Producto producto) {
		return pRepository.save(producto);
	}

	public List<Producto> allProductos() {
		return (List<Producto>) pRepository.findAll();
	}

	public void deleteById(Long id) {
		pRepository.deleteById(id);

	}

	public Optional<Producto> findById(Long id) {
		Optional<Producto> producto = pRepository.findById(id);
		return producto;
	}

	public void actualizarProducto(@Valid Producto producto) {
		pRepository.save(producto);

	}

}
