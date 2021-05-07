package com.everis.data.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("")
	public String inicioApp(HttpSession session) {
		session.setAttribute("registrado", 0);
		return "index.jsp";
	}

	@RequestMapping("error-sesion")
	public String errorSesion() {
		return "errorSesion.jsp";
	}
}
