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

import pe.edu.upc.tb3.entities.Respuesta;
import pe.edu.upc.tb3.serviceinterfaces.IForoService;
import pe.edu.upc.tb3.serviceinterfaces.IPacienteService;
import pe.edu.upc.tb3.serviceinterfaces.IRespuestaService;

@Controller
@RequestMapping("/respuestas")
public class RespuestaController {
	
	@Autowired
	private IForoService forService;
	
	@Autowired
	private IRespuestaService reService;
	
		@Autowired
	private IPacienteService paciService;

	@GetMapping("/nuevo")
	public String newRespuesta(Model model) {
		model.addAttribute("r", new Respuesta());
		model.addAttribute("listaForos", forService.list());
		model.addAttribute("listaPacientes", paciService.list());
		return "/Respuesta/frmRegister";
	}

	@PostMapping("/guardar")
	public String saveRespuesta(@Valid Respuesta objrespuesta, BindingResult binRes) {

		if (binRes.hasErrors()) {
			return "/Respuesta/frmRegister";
		} else {
			reService.insert(objrespuesta);
			return "redirect:/respuestas/nuevo";
		}
	}

	@GetMapping("/listar")
	public String listRespuesta(Model model) {
		try {
			model.addAttribute("listaRespuestas", reService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/Respuesta/frmList";
	}

	@RequestMapping("/eliminar")
	public String deleteRespuesta(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				reService.delete(id);
				model.put("listaRespuestas", reService.list());
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "Respuesta/frmList";
	}

	@RequestMapping("irmodificar/{id}")
	public String goUpdateRespuesta(@PathVariable int id, Model model) {
		Optional<Respuesta> objRes = reService.listId(id);
		model.addAttribute("r_mod", objRes.get());
		return "Respuesta/frmUpdate";
	}

	@PostMapping("/modificar")
	public String updateRespuesta(Respuesta re) {
		reService.update(re);
		return "redirect:/respuestas/listar";
	}
}
