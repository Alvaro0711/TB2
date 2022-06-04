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

import pe.edu.upc.tb3.entities.Foro;
import pe.edu.upc.tb3.serviceinterfaces.ICategoriaService;
import pe.edu.upc.tb3.serviceinterfaces.IForoService;
import pe.edu.upc.tb3.serviceinterfaces.IPsicologoService;

@Controller
@RequestMapping("/foros")
public class ForoController {
	@Autowired
	private ICategoriaService caService;
	
	@Autowired
	private IForoService foService;
	
	@Autowired
	private IPsicologoService psiService;

	@GetMapping("/nuevo")
	public String newForo(Model model) {
		model.addAttribute("f", new Foro());
		model.addAttribute("listaCategorias", caService.list());
		model.addAttribute("listaPsicologos", psiService.list());
		return "/Foro/frmRegister";
	}

	@PostMapping("/guardar")
	public String saveForo(@Valid Foro objforo, BindingResult binRes) {

		if (binRes.hasErrors()) {
			return "/Foro/frmRegister";
		} else {
			foService.insert(objforo);
			return "redirect:/foros/nuevo";
		}
	}

	@GetMapping("/listar")
	public String listForo(Model model) {
		try {
			model.addAttribute("listaForos", foService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/Foro/frmList";
	}

	@RequestMapping("/eliminar")
	public String deleteForo(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				foService.delete(id);
				model.put("listaForos", foService.list());
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "Foro/frmList";
	}

	@RequestMapping("irmodificar/{id}")
	public String goUpdateForo(@PathVariable int id, Model model) {
		Optional<Foro> objFor = foService.listId(id);
		model.addAttribute("f_mod", objFor.get());
		return "Foro/frmUpdate";
	}

	@PostMapping("/modificar")
	public String updateForo(Foro fo) {
		foService.update(fo);
		return "redirect:/foros/listar";
	}
}
