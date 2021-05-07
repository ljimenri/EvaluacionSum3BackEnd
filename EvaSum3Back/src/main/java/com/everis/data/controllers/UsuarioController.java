package com.everis.data.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		usuario.setClave(clave);
		uService.save(usuario);
		return "index.jsp";
	}

	@RequestMapping("/login")
	public String login(@RequestParam("correo") String correo, @RequestParam("clave") String clave, HttpSession session,
			Model model) {
		if (uService.autenticacion(correo, clave)) {
			session.setAttribute("correo", correo);
			session.setAttribute("registrado", 1);
			return "redirect:/producto";
		} else {
			session.removeAttribute("registrado");
			session.setAttribute("registrado", 0);
			return "redirect:/";

		}

	}

	@RequestMapping("/log-aout")
	public String logout(HttpSession session) {
		session.setAttribute("registrado", 0);
		return "redirect:/";

	}

}
