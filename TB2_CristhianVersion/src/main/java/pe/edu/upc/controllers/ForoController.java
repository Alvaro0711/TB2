package pe.edu.upc.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entities.Categoria;
import pe.edu.upc.entities.Psicologo;
import pe.edu.upc.entities.Foro;

import pe.edu.upc.serviceinterfaces.ICategoriaService;
import pe.edu.upc.serviceinterfaces.IPsicologoService;
import pe.edu.upc.serviceinterfaces.IForoService;


@Named
@RequestScoped
public class ForoController {

	@Inject
	private IForoService foService;
	@Inject
	private IPsicologoService psiService;
	@Inject
	private ICategoriaService caService;

	private Foro fo;
	List<Foro> listaForos;
	List<Psicologo> listaPsicologos;
	List<Categoria> listaCategorias;

	@PostConstruct
	public void init() {
		this.fo = new Foro();
		this.listaForos = new ArrayList<Foro>();
		this.listaPsicologos = new ArrayList<Psicologo>();
		this.listaCategorias = new ArrayList<Categoria>();
		this.listPsicologos();
		this.listCategorias();
		this.list();
	}

	public void insert() {
		try {
			foService.insert(fo);
		} catch (Exception e) {
			System.out.println("Error al insertar en el controlador de foro");
		}
	}

	public void list() {
		try {
			listaForos = foService.list();
		} catch (Exception e) {
			System.out.println("Error al listar en el controlador de foros");
		}
	}

	public void listPsicologos() {
		try {
			listaPsicologos = psiService.list();
		} catch (Exception e) {
			System.out.println("Error al listar psicologos en el controlador de foro");
		}
	}

	public void listCategorias() {
		try {
			listaCategorias = caService.list();
		} catch (Exception e) {
			System.out.println("Error al listar categorias en el controlador de foro");
		}
	}

	public void delete(Foro fo) {
		try {
			foService.delete(fo.getIdForo());
			this.list();
		} catch (Exception e) {
			System.out.println("Error al eliminar en el controller de foro");
		}
	}

	public String preUpdate(Foro fo) {
		this.setFo(fo);
		return "modForo.xhtml";
	}

	public void update() {
		try {
			foService.update(this.fo);
		} catch (Exception e) {
			System.out.println("Error al modificar en el controller foro");
		}

	}

	public void findByName() {
		try {
			listaForos = foService.findByName(this.getFo());
		} catch (Exception e) {
			System.out.println("Error al bucar en el controller foro");
		}
	}
	
	public Foro getFo() {
		return fo;
	}

	public void setFo(Foro fo) {
		this.fo = fo;
	}

	public List<Foro> getListaForos() {
		return listaForos;
	}

	public void setListaForos(List<Foro> listaForos) {
		this.listaForos = listaForos;
	}

	public List<Psicologo> getListaPsicologos() {
		return listaPsicologos;
	}

	public void setListaPiscologos(List<Psicologo> listaPsicologos) {
		this.listaPsicologos = listaPsicologos;
	}

	public List<Categoria> getListaCategorias() {
		return listaCategorias;
	}

	public void setListaCategorias(List<Categoria> listaCategorias) {
		this.listaCategorias = listaCategorias;
	}

}
