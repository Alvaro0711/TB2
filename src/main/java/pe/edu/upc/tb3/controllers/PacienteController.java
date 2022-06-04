package pe.edu.upc.tb3.controllers;

import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.edu.upc.tb3.entities.Paciente;
import pe.edu.upc.tb3.serviceinterfaces.IPacienteService;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {
	@Autowired
	private IPacienteService pacService;

	@GetMapping("/nuevo")
	public String newPaciente(Model model) {
		model.addAttribute("pa", new Paciente());
		return "paciente/frmRegisterPaciente";
	}

	@PostMapping("/guardar")
	public String savePaciente(@Valid Paciente p, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			model.addAttribute("error", "Ocurrio un Error");
			return "paciente/frmRegisterPaciente";
		} else {
			pacService.insert(p);
			model.addAttribute("mensaje", "Se gurado correctamente");
			return "redirect:/pacientes/nuevo";
		}
	}

	@GetMapping("/listar")
	public String listPaciente(Model model) {
		try {
			model.addAttribute("listaPacientes", pacService.list());
			
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		
		return "/paciente/frmListPacientes";
	}
	
	@RequestMapping("/eliminar")
	public String deletePaciente(Map<String,Object> model, @RequestParam(value = "id")Integer id) {
		try {
			if (id != null && id > 0) {
				pacService.delete(id);
				model.put("listaPacientes", pacService.list());
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "paciente/frmListPacientes";
	}
	@RequestMapping("irmodificar/{id}")
	public String goUpdatePaciente(@PathVariable int id, Model model) {
		Optional<Paciente> objPer=pacService.listId(id);
		model.addAttribute("psa",objPer.get());
		return "paciente/frmUpdatePaciente";
	}
	
	@PostMapping("modificar")
	public String updatePaciente(Paciente pa) {
		pacService.update(pa);
		
		return "redirect:/pacientes/listar";
	}
}
