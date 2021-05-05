package com.everis.data.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.data.models.Usuario;
import com.everis.data.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository uRepository;

	public void save(Usuario usuario) {
		uRepository.save(usuario);
	}

	public List<Usuario> findAll() {
		return (List<Usuario>) uRepository.findAll();
	}

}
