package pe.edu.upc.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entities.Respuesta;
import pe.edu.upc.entities.Paciente;
import pe.edu.upc.entities.Foro;

import pe.edu.upc.serviceinterfaces.IRespuestaService;
import pe.edu.upc.serviceinterfaces.IPacienteService;
import pe.edu.upc.serviceinterfaces.IForoService;

@Named
@RequestScoped
public class RespuestaController {

	@Inject
	private IRespuestaService reService;
	@Inject
	private IPacienteService paService;
	@Inject
	private IForoService foService;

	private Respuesta re;
	
	List<Respuesta> listaRespuestas;
	List<Paciente> listaPacientes;
	List<Foro> listaForos;

	@PostConstruct
	public void init() {
		this.re = new Respuesta();
		this.listaForos = new ArrayList<Foro>();
		this.listaPacientes = new ArrayList<Paciente>();
		this.listaRespuestas = new ArrayList<Respuesta>();
		this.listPacientes();
		this.listForos();
		this.list();
	}

	public void insert() {
		try {
			reService.insert(re);
		} catch (Exception e) {
			System.out.println("Error al insertar en el controlador de respuestas");
		}
	}

	public void list() {
		try {
			listaRespuestas = reService.list();
		} catch (Exception e) {
			System.out.println("Error al listar en el controlador de respuestas");
		}
	}

	public void listPacientes() {
		try {
			listaPacientes = paService.list();
		} catch (Exception e) {
			System.out.println("Error al listar pcaientes en el controlador de respuestas");
		}
	}

	public void listForos() {
		try {
			listaForos = foService.list();
		} catch (Exception e) {
			System.out.println("Error al listar foros en el controlador de respuestas");
		}
	}

	public void delete(Respuesta re) {
		try {
			reService.delete(re.getIdRespuesta());
			this.list();
		} catch (Exception e) {
			System.out.println("Error al eliminar en el controller de respuesta");
		}
	}

	public String preUpdate(Respuesta re) {
		this.setRe(re);
		return "modRespuesta.xhtml";
	}

	public void update() {
		try {
			reService.update(this.re);
		} catch (Exception e) {
			System.out.println("Error al modificar en el controller respuesta");
		}

	}

	public void findByName() {
		try {
			listaRespuestas = reService.findByName(this.getRe());
		} catch (Exception e) {
			System.out.println("Error al bucar en el controller respuestas");
		}
	}
	
	public Respuesta getRe() {
		return re;
	}

	public void setRe(Respuesta re) {
		this.re = re;
	}

	public List<Respuesta> getListaRespuestas() {
		return listaRespuestas;
	}

	public void setListaRespuestas(List<Respuesta> listaRespuestas) {
		this.listaRespuestas = listaRespuestas;
	}

	public List<Paciente> getListaPacientes() {
		return listaPacientes;
	}

	public void setListaPacientes(List<Paciente> listaPacientes) {
		this.listaPacientes = listaPacientes;
	}

	public List<Foro> getListaForos() {
		return listaForos;
	}

	public void setLitaForos(List<Foro> listaForos) {
		this.listaForos = listaForos;
	}
}
