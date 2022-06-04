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

import pe.edu.upc.tb3.entities.Categoria;
import pe.edu.upc.tb3.serviceinterfaces.ICategoriaService;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {
	@Autowired
	private ICategoriaService caService;

	@GetMapping("/nuevo")
	public String newCategoria(Model model) {
		model.addAttribute("c", new Categoria());
		return "categoria/frmRegister";
	}

	@PostMapping("/guardar")
	public String saveCategoria(@Valid Categoria ca, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			model.addAttribute("error", "Algo salió mal :(");
			return "categoria/frmRegister";
		} else {
			caService.insert(ca);
			model.addAttribute("mensaje", "se guardó correctamente!");
			return "redirect:/categorias/nuevo";
		}
	}

	@GetMapping("/listar")
	public String listCategorias(Model model) {
		try {

			model.addAttribute("listaCategorias", caService.list());

		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/categoria/frmList";
	}

	@RequestMapping("/eliminar")
	public String deleteCategoria(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				caService.delete(id);
				model.put("listaCategorias", caService.list());
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "categoria/frmList";
	}

	@RequestMapping("irmodificar/{id}")
	public String goUpdateCategoria(@PathVariable int id, Model model) {
		Optional<Categoria> objPer = caService.listId(id);
		model.addAttribute("c_mod", objPer.get());
		return "categoria/frmUpdate";
	}

	@PostMapping("/modificar")
	public String updateCategoria(Categoria ca) {
		caService.update(ca);
		return "redirect:/categorias/listar";
	}
}
