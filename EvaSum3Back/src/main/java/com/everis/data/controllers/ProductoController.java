package com.everis.data.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.everis.data.models.Producto;
import com.everis.data.services.ProductoService;

@Controller
@RequestMapping("/producto")
public class ProductoController {

	@Autowired
	ProductoService pService;

	@RequestMapping("/")
	public String productos(Model model) {

		List<Producto> lista = pService.allProductos();
		model.addAttribute("productos", lista);
		return "producto.jsp";

	}

	@RequestMapping("/insertar")
	public String guardarProducto(@RequestParam(value = "nombre") String nombre,
			@RequestParam(value = "precio") String precio,
			@RequestParam(value = "caracteristica") String caracteristica, Model model) {

		Producto producto = new Producto();
		producto.setNombre(nombre);
		producto.setPrecio(precio);
		producto.setCaracteristicas(caracteristica);
		producto = pService.guardarProducto(producto);

		List<Producto> lista = pService.allProductos();
		model.addAttribute("productos", lista);

		return "producto.jsp";
	}

	@RequestMapping("/eliminar")
	public String eliminar(@RequestParam(value = "id") Long id, Model model) {

		pService.deleteById(id);
		List<Producto> lista = pService.allProductos();
		model.addAttribute("productos", lista);
		return "producto.jsp";

	}

}
