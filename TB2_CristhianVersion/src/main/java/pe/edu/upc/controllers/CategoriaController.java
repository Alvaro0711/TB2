package pe.edu.upc.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entities.Categoria;
import pe.edu.upc.serviceinterfaces.ICategoriaService;

@Named
@RequestScoped
public class CategoriaController {

	@Inject
	private ICategoriaService caService;

	private Categoria ca;
	List<Categoria> listaCategorias;

	@PostConstruct
	public void init() {
		this.ca = new Categoria();
		this.listaCategorias = new ArrayList<Categoria>();
		this.list();
	}

	public String newCategoria() {
		this.setCa(new Categoria());
		return "categoria.xhtml";
	}

	public void insert() {
		try {
			caService.insert(ca);
		} catch (Exception e) {
			System.out.println("Error al insertar en el controlador de Categoria");
		}
	}

	public void list() {
		try {
			listaCategorias = caService.list();
		} catch (Exception e) {
			System.out.println("Error al listar en el controlador de Categoria controller");
		}
	}

	public void delete(Categoria ca) {
		try {
			caService.delete(ca.getIdCategoria());
			this.list();
		} catch (Exception e) {
			System.out.println("Error al eliminar en el controller Categoria Controller");
		}
	}

	public String preUpdate(Categoria ca) {
		this.setCa(ca);
		return "modCategoria.xhtml";
	}

	public void update() {
		try {
			caService.update(this.ca);
		} catch (Exception e) {
			System.out.println("Error al modificar en el controller Categoria");
		}

	}

	public void findByName() {
		try {
			listaCategorias = caService.findByName(this.getCa());
		} catch (Exception e) {
			System.out.println("Error al bucar en el controller categoria");
		}
	}

	// solamente getteres o setters
	public Categoria getCa() {
		return ca;
	}

	public void setCa(Categoria ca) {
		this.ca = ca;
	}

	public List<Categoria> getListaCategoria() {
		return listaCategorias;
	}

	public void setListaCategoria(List<Categoria> listaCategoria) {
		this.listaCategorias = listaCategoria;
	}

}
