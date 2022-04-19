package pe.edu.upc.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entities.Paciente;
import pe.edu.upc.serviceinterfaces.IPacienteService;

@Named
@RequestScoped 
public class PacienteController {
	
	@Inject
	private IPacienteService pService;
	
	//Variables
	private Paciente p;
	List<Paciente> listaPacientes;
	
	//Constructor
	@PostConstruct
	public void init() {
		this.listaPacientes=new ArrayList<Paciente>();
		this.p = new Paciente();
		this.list();
	}
	
	//metodos
	public String newPaciente() {
		this.setP(new Paciente());
		return "persona.xhtml";
	}
	
	public void insert() {
		try {
			pService.insert(p);
		}catch(Exception e) {
			System.out.println("Error al insertar en el controller de Paciente");
		}
	}
	
	public void list() {
		try {
			listaPacientes = pService.list();
		}catch(Exception e) {
			System.out.println("Error al listar en el controlloer de Pacientes");
		}
	}
	
	public void delete(Paciente paci) {
		try {
			pService.delete(paci.getIdPaciente());
			this.list();
		}catch (Exception e) {
			System.out.println("Error al eliminar el controlador Paciente");
		}
	}
	
	// getters & Setters
	
	
	
	
	public Paciente getP() {
		return p;
	}
	
	public void setP(Paciente p) {
		this.p = p;
	}

	public List<Paciente> getListaPacientes() {
		return listaPacientes;
	}

	public void setListaPacientes(List<Paciente> listaPacientes) {
		this.listaPacientes = listaPacientes;
	}



}