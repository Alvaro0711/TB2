package pe.edu.upc.tb3.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.edu.upc.tb3.entities.Plan;
import pe.edu.upc.tb3.serviceinterfaces.IPlanService;

@Controller
@RequestMapping("/planes")
public class PlanController {
	@Autowired
	private IPlanService plService;

	@GetMapping("/nuevo")
	public String newPlan(Model model) {
		model.addAttribute("pl", new Plan());
		return "plan/frmRegisterPlan";
	}

	@PostMapping("/guardar")
	public String savePlan(@Valid Plan pla, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			model.addAttribute("error", "Ocurrio un Error");
			return "plan/frmRegisterPlan";
		} else {
			plService.insert(pla);
			model.addAttribute("mensaje", "Se gurado correctamente");
			return "redirect:/planes/nuevo";
		}
	}

	@GetMapping("/listar")
	public String listPlanes(Model model) {
		try {
			model.addAttribute("listaPlanes", plService.list());
			
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		
		return "/plan/frmListPlanes";
	}
	
	@RequestMapping("/eliminar")
	public String deletePlan(Map<String,Object> model, @RequestParam(value = "id")Integer id) {
		try {
			if (id != null && id > 0) {
				plService.delete(id);
				model.put("listaPlanes", plService.list());
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "plan/frmListPlanes";
	}
}
