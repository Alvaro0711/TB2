package pe.edu.upc.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entities.Paciente;
import pe.edu.upc.entities.Suscripcion;
import pe.edu.upc.entities.Plan;

import pe.edu.upc.serviceinterfaces.IPacienteService;
import pe.edu.upc.serviceinterfaces.ISuscripcionService;
import pe.edu.upc.serviceinterfaces.IPlanService;

@Named
@RequestScoped
public class SuscripcionController {
	
	@Inject
	private ISuscripcionService susService;
	@Inject
	private IPacienteService paService;
	@Inject
	private IPlanService plService;
	
	private Suscripcion sus;
	List<Suscripcion> listaSuscripciones;
	List<Paciente> listaPacientes;
	List<Plan> listaPlanes;
	
	@PostConstruct
	public void init() {
		this.sus = new Suscripcion();
		this.listaSuscripciones = new ArrayList<Suscripcion>();
		this.listaPacientes = new ArrayList<Paciente>();
		this.listaPlanes = new ArrayList<Plan>();
		this.listPacientes();
		this.listPlanes();
		this.list();
	}
	
	//metodos
	public void insert() {
		try {
			susService.insert(sus);
		} catch (Exception e) {
			System.out.println("Error al insertar el controlador de suscripción");
		}
	}
	
	public void list() {
		try {
			listaSuscripciones = susService.list();
		} catch(Exception e) {
			System.out.println("Error al listar el controlador de suscripciones");
		}
	}
	
	public void listPacientes() {
		try {
			listaPacientes = paService.list();
		} catch(Exception e) {
			System.out.println("Error al listar pacientes en el controlador Suscripcion");
		}
	}
	
	public void listPlanes() {
		try {
			listaPlanes = plService.list();
		} catch(Exception e) {
			System.out.println("Error al listar planes en el controlador Suscripcion");
		}
	}
	
	public String preUpdate(Suscripcion sus) {
		this.setVa(sus);
		return "modificacionSUS.xhtml";
	}
	
	public void update() {
		try {
			susService.update(this.sus);
		} catch (Exception e) {
			System.out.println("Error al modificar controlador Suscripcion");
		}
	}

	public Suscripcion getSus() {
		return sus;
	}
	public void setVa(Suscripcion sus) {
		this.sus = sus;
	}
	public List<Suscripcion> getListaSuscripciones() {
		return listaSuscripciones;
	}
	public void setListaVacunaciones(List<Suscripcion> listaSuscripciones) {
		this.listaSuscripciones = listaSuscripciones;
	}

	public List<Paciente> getListaPacientes() {
		return listaPacientes;
	}

	public void setListaPacientes(List<Paciente> listaPacientes) {
		this.listaPacientes = listaPacientes;
	}

	public List<Plan> getListaPlanes() {
		return listaPlanes;
	}

	public void setListaVacunas(List<Plan> listaPlanes) {
		this.listaPlanes= listaPlanes;
	}
}
