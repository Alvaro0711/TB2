package pe.edu.upc.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entities.Psicologo;
import pe.edu.upc.serviceinterfaces.IPsicologoService;

@Named
@RequestScoped 
public class PsicologoController {
	
	@Inject
	private IPsicologoService psService;
	
	//Variables
	private Psicologo ps;
	List<Psicologo> listaPsicologos;
	
	//Constructor
	@PostConstruct
	public void init() {
		this.listaPsicologos = new ArrayList<Psicologo>();
		this.ps = new Psicologo();
		this.list();
	}
	
	//metodos
	public String newPsicologo() {
		this.setPS(new Psicologo());
		return "psicologo.xhtml";
	}
	
	public void insert() {
		try {
			psService.insert(ps);
		}catch(Exception e) {
			System.out.println("Error al insertar en el controller de Psicologo");
		}
	}
	
	public void list() {
		try {
			listaPsicologos = psService.list();
		}catch(Exception e) {
			System.out.println("Error al listar en el controlloer de Psicologos");
		}
	}
	
	public void delete(Psicologo psi) {
		try {
			psService.delete(psi.getIdPsicologo());
			this.list();
		}catch (Exception e) {
			System.out.println("Error al eliminar el controlador Paciente");
		}
	}
	
	// getters & Setters
	
	public Psicologo getPS() {
		return ps;
	}
	
	public void setPS(Psicologo ps) {
		this.ps = ps;
	}

	public List<Psicologo> getListaPsicologos() {
		return listaPsicologos;
	}

	public void setListaPsicologos(List<Psicologo> listaPsicologos) {
		this.listaPsicologos = listaPsicologos;
	}
}
