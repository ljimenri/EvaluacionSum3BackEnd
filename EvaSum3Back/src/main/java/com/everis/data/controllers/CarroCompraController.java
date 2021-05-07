package com.everis.data.controllers;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.everis.data.models.CarroCompra;
import com.everis.data.models.Producto;
import com.everis.data.services.CarroCompraService;
import com.everis.data.services.ProductoService;

@Controller
@RequestMapping("/carro-compra")
public class CarroCompraController {

	@Autowired
	CarroCompraService ccService;

	@Autowired
	ProductoService pService;

	@RequestMapping("")
	public String inicioCarroCompra(Model model, HttpSession session) {

		Integer registrado = (Integer) session.getAttribute("registrado");
		if (registrado == 1) {

			List<CarroCompra> lista_carro = ccService.allCarroCompra();
			model.addAttribute("carrocompras", lista_carro);

			List<Producto> lista = pService.allProductos();
			model.addAttribute("productos", lista);

			return "carroCompra.jsp";

		}
		return "redirect:/error-sesion";

	}

	@RequestMapping("/insertar")
	public String insertarCarroCompra(@RequestParam("cantidad") String cantidad,
			@RequestParam("producto") Producto producto, Model model, HttpSession session) {

		Integer registrado = (Integer) session.getAttribute("registrado");
		if (registrado == 1) {

			CarroCompra carrocompra = new CarroCompra();
			carrocompra.setCantidad(cantidad);
			carrocompra.setProducto(producto);

			carrocompra = ccService.save(carrocompra);

			List<CarroCompra> lista_carro = ccService.allCarroCompra();
			model.addAttribute("carrocompras", lista_carro);

			int sum = 0;
			for (int i = 0; i < lista_carro.size(); i++) {
				sum = sum + Integer.parseInt(lista_carro.get(i).getProducto().getPrecio())
						* Integer.parseInt(lista_carro.get(i).getCantidad());
			}
			model.addAttribute("total", sum);
			List<Producto> lista = pService.allProductos();
			model.addAttribute("productos", lista);
			return "carroCompra.jsp";
		}
		return "redirect:/error-sesion";
	}

	@RequestMapping("/eliminar")
	public String eliminarCarroCompra(@RequestParam(value = "id") Long id, Model model, HttpSession session) {
		Integer registrado = (Integer) session.getAttribute("registrado");
		if (registrado == 1) {
			ccService.deleteById(id);
			List<CarroCompra> lista_carro = ccService.allCarroCompra();
			model.addAttribute("carrocompras", lista_carro);
			return "redirect:/carro-compra";
		}
		return "redirect:/error-sesion";
	}

	@RequestMapping("/editar")
	public String editarCarroCompra(@RequestParam("id") Long id, Model model, HttpSession session) {

		Integer registrado = (Integer) session.getAttribute("registrado");
		if (registrado == 1) {

			Optional<CarroCompra> carrocompra = ccService.findById(id);
			model.addAttribute("carrito", carrocompra);
			List<Producto> lista = pService.allProductos();
			model.addAttribute("productos", lista);
			return "editar.jsp";
		}
		return "redirect:/error-sesion";
	}

	@RequestMapping("/actualizar")
	public String actualizarCarro(@Valid @ModelAttribute("carrito") CarroCompra carrito, HttpSession session) {

		Integer registrado = (Integer) session.getAttribute("registrado");
		if (registrado == 1) {
			System.out.println(carrito.getId());
			System.out.println(carrito.getCantidad());

			ccService.ActualizaCarro(carrito.getCantidad(), carrito.getId());
			return "redirect:/carro-compra";

		}
		return "redirect:/error-sesion";
	}

}
