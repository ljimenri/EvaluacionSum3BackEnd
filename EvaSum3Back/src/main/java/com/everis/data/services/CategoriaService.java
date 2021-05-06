package com.everis.data.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.data.models.Categoria;
import com.everis.data.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
	CategoriaRepository cRepository;

	public Categoria guardarCategoria(Categoria categoria) {
		return cRepository.save(categoria);
	}

	public List<Categoria> allCategorias() {
		return (List<Categoria>) cRepository.findAll();
	}

	public void deleteById(Long id) {
		cRepository.deleteById(id);

	}

	public Optional<Categoria> findById(Long id) {
		Optional<Categoria> categoria = cRepository.findById(id);
		return categoria;
	}

	public void actualizarCategoria(@Valid Categoria categoria) {
		cRepository.save(categoria);

	}
}
