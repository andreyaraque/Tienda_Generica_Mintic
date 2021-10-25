package com.grupo2.tienda.controladores;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.grupo2.tienda.implementaciones.ImplementacionUsuarios;
import com.grupo2.tienda.implementaciones.ImplementacionVentas;
import com.grupo2.tienda.modelos.UsuarioDTO;
import com.grupo2.tienda.modelos.VentasClienteDTO;

@Controller
public class ControladorReportes {
	
	@Autowired
	private ImplementacionUsuarios impUsuarios;
	
	@Autowired
	private ImplementacionVentas impVentas;
	
	@GetMapping("/Reportes")
	public String Reportes(Principal principal, Model modelo) {
		
		UsuarioDTO usuarioSesion = impUsuarios.ObtenerUsuarioSesion(principal.getName());

		modelo.addAttribute("usuarioSesion", usuarioSesion);
		
		return "Reportes/index";
	}

	@GetMapping("/VentasCliente")
	public String VentasCliente(Principal principal, Model modelo) {
		
		UsuarioDTO usuarioSesion = impUsuarios.ObtenerUsuarioSesion(principal.getName());

		modelo.addAttribute("usuarioSesion", usuarioSesion);
		
		List<VentasClienteDTO> ListaVentas = impVentas.ListarVentasClientes();
		
		modelo.addAttribute("ListaVentas", ListaVentas);
		
		return "Reportes/Lista/index";
	}


}
