package com.everis.data.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.data.models.Usuario;
import com.everis.data.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository uRepository;

	public Usuario save(Usuario usuario) {

		System.out.println("---SERVICE---");
		System.out.println(usuario.getCorreo());
		System.out.println(usuario.getClave());
		String hashed = BCrypt.hashpw(usuario.getClave(), BCrypt.gensalt());
		System.out.println("clave hashed " + hashed);
		usuario.setClave(hashed);
		return uRepository.save(usuario);
	}

	public List<Usuario> findAll() {
		return (List<Usuario>) uRepository.findAll();
	}

	public Usuario findByCorreo(String correo) {
		return uRepository.findByCorreo(correo);
	}

	public boolean autenticacion(String correo, String clave) {

		System.out.println("---SERVICE---");
		System.out.println(correo);
		System.out.println(clave);
		// este da nullo
		Usuario usuario = uRepository.findByCorreo(correo);

		// System.out.println(usuario.getNombreCompleto());

		// existencia de la persona
		if (usuario == null) {
			return false;
		} else {
			if (BCrypt.checkpw(clave, usuario.getClave())) {
				return true;
			} else {
				return false;
			}
		}
	}

}
