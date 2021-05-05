package com.everis.data.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.everis.data.models.Usuario;
import com.everis.data.services.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	UsuarioService uService;

	@RequestMapping("")
	public String inicioLogin() {
		return "usuario.jsp";
	}

	@RequestMapping("/insertar")
	public String insertar(@RequestParam("nombreCompleto") String nombreCompleto, @RequestParam("correo") String correo,
			@RequestParam("clave") String clave) {
		Usuario usuario = new Usuario();
		usuario.setNombreCompleto(nombreCompleto);

		usuario.setCorreo(correo);

		uService.save(usuario);

		return "index.jsp";
	}

	@RequestMapping("/login")
	public String login(@RequestParam("correo") String correo, @RequestParam("clave") String clave) {
		Usuario usuario = new Usuario();

		List<Usuario> usuarios = uService.findAll();

		boolean usuarioEncontrado = false;
		for (int i = 0; i < usuarios.size(); i++) {

			if (correo.equals(usuarios.get(i).getCorreo())) {
				usuarioEncontrado = true;
			}

		}

		if (usuarioEncontrado) {

			return "redirect:/producto/";
		}
		return "redirect:/";

	}

}
