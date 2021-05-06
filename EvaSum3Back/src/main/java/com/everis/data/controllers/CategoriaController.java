package com.everis.data.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.everis.data.models.Categoria;
import com.everis.data.services.CategoriaService;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	CategoriaService cService;

	@RequestMapping("")
	public String productos(Model model) {

		List<Categoria> lista = cService.allCategorias();
		model.addAttribute("categorias", lista);
		return "categoria.jsp";

	}

	@RequestMapping("/insertar")
	public String guardar(@RequestParam(value = "nombre") String nombre, Model model) {

		Categoria categoria = new Categoria();
		categoria.setNombre(nombre);

		categoria = cService.guardarCategoria(categoria);

		List<Categoria> lista = cService.allCategorias();
		model.addAttribute("categorias", lista);

		return "categoria.jsp";
	}

	@RequestMapping("/eliminar")
	public String eliminar(@RequestParam(value = "id") Long id, Model model) {

		cService.deleteById(id);

		List<Categoria> lista = cService.allCategorias();
		model.addAttribute("categorias", lista);
		return "categoria.jsp";

	}

	@RequestMapping("/editar")
	public String editar(@RequestParam("id") Long id, Model model) {
		Optional<Categoria> categoria = cService.findById(id);
		model.addAttribute("categoria", categoria);
		return "editarCategoria.jsp";
	}

	@RequestMapping("/actualizar")
	public String actualizarCancion(@Valid @ModelAttribute("categoria") Categoria categoria

	) {
		Optional<Categoria> categoria1 = cService.findById(categoria.getId());
		cService.actualizarCategoria(categoria);
		return "redirect:/categoria";
	}

}
