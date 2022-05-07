package pe.edu.upc.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entities.Plan;
import pe.edu.upc.serviceinterfaces.IPlanService;

@Named
@RequestScoped
public class PlanController {
	@Inject
	private IPlanService plPlan;

	// Variables
	private Plan pl;
	List<Plan> listaPlanes;

	// Constructor
	@PostConstruct
	public void init() {
		this.listaPlanes = new ArrayList<Plan>();
		this.pl = new Plan();
		this.list();
	}

	// metodos
	public String newPlan() {
		this.setPl(new Plan());
		return "plan.xhtml";
	}

	public void insert() {
		try {
			plPlan.insert(pl);
		} catch (Exception e) {
			System.out.println("Error al insertar en el controller de Plan");
		}
	}

	public void list() {
		try {
			listaPlanes = plPlan.list();
		} catch (Exception e) {
			System.out.println("Error al listar en el controlloer de Plan");
		}
	}

	public void delete(Plan psi) {
		try {
			plPlan.delete(psi.getIdPlan());
			this.list();
		} catch (Exception e) {
			System.out.println("Error al eliminar el controlador Plan");
		}
	}
	// getters & Setters

	public Plan getPl() {
		return pl;
	}

	public void setPl(Plan pl) {
		this.pl = pl;
	}

	public List<Plan> getListaPlanes() {
		return listaPlanes;
	}

	public void setListaPlanes(List<Plan> listaPlanes) {
		this.listaPlanes = listaPlanes;
	}
	
	
}
