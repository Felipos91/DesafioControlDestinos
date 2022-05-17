package com.desafiolatam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.desafiolatam.models.Destino;
import com.desafiolatam.models.Pasajero;
import com.desafiolatam.models.PasajeroDestino;
import com.desafiolatam.service.DestinoService;
import com.desafiolatam.service.PasajeroDestinoService;
import com.desafiolatam.service.PasajeroService;

@Controller
public class DestinoController {

	@Autowired
	PasajeroService pasajeroService;
	
	@Autowired
	DestinoService destinoService;
	
	@Autowired
	PasajeroDestinoService pasajeroDestinoService;
	
	@RequestMapping("/destino")
	public String destino(@ModelAttribute("destino") Destino destino,@ModelAttribute("pasajero") Pasajero pasajero,
			 Model model) {
		
		
		List<Pasajero> listaPasajeros=pasajeroService.findAll();
		model.addAttribute("pasajeroId",0);
		model.addAttribute("listaPasajeros",listaPasajeros);
		return "registroDestino.jsp";
	}
	
	@RequestMapping("/destino/listar")
	public String listarDestinos(Model model){
		
		model.addAttribute("listadoPasajerosDestinos", pasajeroDestinoService.findAll());
		return "listarDestinos.jsp";
	}
	
	
	@PostMapping("/destino/registrar")
	public String registrarDestino(@ModelAttribute("destino") Destino destino,@RequestParam("pasajeroId") Long pasajeroId,
			RedirectAttributes redirectAttributes) {
		
		Destino DestinoEncontrado=destinoService.findByName(destino.getCiudad());
		PasajeroDestino pasajeroDestinoEncontrado=pasajeroDestinoService.findyId(pasajeroId);
		
		//Si se ingresa una ciudad destino y esta no existe en DB, se guardará el nuevo destino junto con el pasajero ingresado
		if(DestinoEncontrado==null && !destino.getCiudad().equals("") && destino.getCiudad()!=null && !destino.getPais().equals("") &&
				destino.getPais()!=null && destino.getFecha()!=null && pasajeroId!=0) {
			destinoService.save(destino);
			Pasajero pasajero=pasajeroService.findById(pasajeroId);
			PasajeroDestino pasajeroDestino=new PasajeroDestino();
			pasajeroDestino.setDestino(destino);
			pasajeroDestino.setPasajero(pasajero);
			pasajeroDestinoService.save(pasajeroDestino);
			redirectAttributes.addFlashAttribute("Correcto","Destino creado y pasajero asignado con éxito");
			return "redirect:/destino";
			
		}else if(DestinoEncontrado!=null && pasajeroDestinoEncontrado==null) { //Cuando la ciudad de destino existe pero el pasajero aún no tiene asociado un viaje a esa ciudad
			Pasajero pasajero=pasajeroService.findById(pasajeroId);
			PasajeroDestino pasajeroDestino=new PasajeroDestino();
			pasajeroDestino.setDestino(DestinoEncontrado);
			pasajeroDestino.setPasajero(pasajero);
			pasajeroDestinoService.save(pasajeroDestino);
			redirectAttributes.addFlashAttribute("Correcto","Pasajero ingresado correctamente en el destino");
			return "redirect:/destino";
		}else {
		//Se entregará este mensaje cuando el nombre del destino y el pasajero ya se encuentren registrados en la base de datos
		redirectAttributes.addFlashAttribute("Error","Error en el ingreso de datos o datos duplicados");
		return "redirect:/destino";
		}
	}
}
