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

		System.out.println(correo);
		System.out.println(clave);

		if (uService.autenticacion(correo, clave)) {
			session.setAttribute("correo", correo);
			session.setAttribute("registrado", 1);
			System.out.println("ENCONTRADO");
			return "redirect:/producto";
		} else {
			System.out.println(" NOOOOOOOOOO ENCONTRADO");
			session.removeAttribute("registrado");
			session.setAttribute("registrado", 0);
			model.addAttribute("mensaje", "Datos erroneos");
			return "redirect:/";

		}

		/*
		 * Usuario usuario = new Usuario();
		 * 
		 * List<Usuario> usuarios = uService.findAll();
		 * 
		 * boolean usuarioEncontrado = false; for (int i = 0; i < usuarios.size(); i++)
		 * {
		 * 
		 * if (correo.equals(usuarios.get(i).getCorreo())) { usuarioEncontrado = true; }
		 * 
		 * }
		 * 
		 * if (usuarioEncontrado) {
		 * 
		 * return "redirect:/producto/"; }
		 */

	}

}
