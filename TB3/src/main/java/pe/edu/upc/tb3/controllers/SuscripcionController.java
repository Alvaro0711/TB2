package pe.edu.upc.tb3.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.tb3.entities.Suscripcion;
import pe.edu.upc.tb3.serviceinterfaces.IPacienteService;
import pe.edu.upc.tb3.serviceinterfaces.IPlanService;
import pe.edu.upc.tb3.serviceinterfaces.ISuscripcionService;

@Controller
@RequestMapping("/suscripciones")
public class SuscripcionController {
	@Autowired
	private ISuscripcionService susService;
	
	@Autowired
	private IPacienteService paService;
	
	@Autowired
	private IPlanService plService;

	@GetMapping("/nuevo")
	public String newSuscripcion(Model model) {
		model.addAttribute("sus", new Suscripcion());
		model.addAttribute("listaPacientes", paService.list());
		model.addAttribute("listaPlanes", plService.list());
		return "suscripcion/frmRegisterSus";
	}

	@PostMapping("/guardar")
	public String saveSuscripcion(@Valid Suscripcion sus, BindingResult binRes) {
		if (binRes.hasErrors()) {
			return "suscripcion/frmRegisterSus";
		} else {
			susService.insert(sus);
			return "redirect:/suscripciones/nuevo";
		}
	}

	@GetMapping("/listar")
	public String listSuscripciones(Model model) {
		try {
			model.addAttribute("listaSuscripciones", susService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/suscripcion/frmBoleta";
	}
}
