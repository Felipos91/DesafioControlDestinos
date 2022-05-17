package com.desafiolatam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.desafiolatam.models.Pasajero;
import com.desafiolatam.service.PasajeroDestinoService;
import com.desafiolatam.service.PasajeroService;

@Controller
public class PasajeroController {
	
	@Autowired
	PasajeroService pasajeroService;
	
	@Autowired
	PasajeroDestinoService pasajeroDestinoService;
	
	@RequestMapping("/pasajero")
	public String registroPasajero(@ModelAttribute("pasajero") Pasajero pasajero) {
		return "registroPasajero.jsp";
	}
	
	@PostMapping("/pasajero/agregar")
	public String pasajeroAgregar(@ModelAttribute("pasajero") Pasajero pasajero,RedirectAttributes redirectAttributes) {
		
		if(!pasajero.getNombre().equals("") && pasajero.getNombre()!=null && !pasajero.getApellido().equals("") && pasajero.getApellido()!=null
				&& !pasajero.getRut().equals("") && pasajero.getRut()!=null && pasajero.getEdad()!=null && pasajero.getEdad()>0
				&& !pasajero.getCiudadNatal().equals("") && pasajero.getCiudadNatal()!=null) {
			
			
			redirectAttributes.addFlashAttribute("Correcto","Pasajero ingresado con éxito");
			pasajeroService.save(pasajero);
			return "redirect:/pasajero";
		}
		redirectAttributes.addFlashAttribute("Error","Datos faltantes");
		return "redirect:/pasajero";
		
	}
	
	@RequestMapping("/pasajero/listar")
	public String listarDestinos(Model model){
		
		model.addAttribute("listadoPasajerosDestinos", pasajeroDestinoService.findAll());
		return "listarPasajeros.jsp";
	}
	
}
