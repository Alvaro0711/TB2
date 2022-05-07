package pe.edu.upc.entities;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Paciente")
public class Paciente {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idPaciente;

	@Column(name = "NombrePaciente", nullable = false, length = 47)
	private String NombrePaciente;

	@Column(name = "ApellidoPaciente", nullable = false, length = 46)
	private String ApellidoPaciente;

	@Column(name = "CelularPaciente", nullable = false, length = 46)
	private String CelularPaciente;

	@Column(name = "DireccionPaciente", nullable = false, length = 45)
	private String DireccionPaciente;

	@Column(name = "SexoPaciente", nullable = false, length = 47)
	private String SexoPaciente;

	@Column(name = "DNIPaciente", nullable = false, length = 46)
	private String DNIPaciente;

	@Column(name = "FechaPaciente", nullable = false, length = 46)
	private Date FechaPaciente;

	@Column(name = "AnotacionesPaciente", nullable = false, length = 46)
	private String AnotacionesPaciente;

	public Paciente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Paciente(int idPaciente, String NombrePaciente, String ApellidoPaciente, String CelularPaciente,
			String DireccionPaciente, String SexoPaciente, String DNIPaciente, Date FechaPaciente,
			String AnotacionesPaciente) {
		super();
		this.idPaciente = idPaciente;
		this.NombrePaciente = NombrePaciente;
		this.ApellidoPaciente = ApellidoPaciente;
		this.CelularPaciente = CelularPaciente;
		this.DireccionPaciente = DireccionPaciente;
		this.SexoPaciente = SexoPaciente;
		this.DNIPaciente = DNIPaciente;
		this.FechaPaciente = FechaPaciente;
		this.AnotacionesPaciente = AnotacionesPaciente;
	}

	public int getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getNombrePaciente() {
		return NombrePaciente;
	}

	public void setNombrePaciente(String nombrePaciente) {
		NombrePaciente = nombrePaciente;
	}

	public String getApellidoPaciente() {
		return ApellidoPaciente;
	}

	public void setApellidoPaciente(String apellidoPaciente) {
		ApellidoPaciente = apellidoPaciente;
	}

	public String getCelularPaciente() {
		return CelularPaciente;
	}

	public void setCelularPaciente(String celularPaciente) {
		CelularPaciente = celularPaciente;
	}

	public String getDireccionPaciente() {
		return DireccionPaciente;
	}

	public void setDireccionPaciente(String direccionPaciente) {
		DireccionPaciente = direccionPaciente;
	}

	public String getSexoPaciente() {
		return SexoPaciente;
	}

	public void setSexoPaciente(String sexoPaciente) {
		SexoPaciente = sexoPaciente;
	}

	public String getDNIPaciente() {
		return DNIPaciente;
	}

	public void setDNIPaciente(String dNIPaciente) {
		DNIPaciente = dNIPaciente;
	}

	public Date getFechaPaciente() {
		return FechaPaciente;
	}

	public void setFechaPaciente(Date fechaPaciente) {
		FechaPaciente = fechaPaciente;
	}

	public String getAnotacionesPaciente() {
		return AnotacionesPaciente;
	}

	public void setAnotacionesPaciente(String anotacionesPaciente) {
		AnotacionesPaciente = anotacionesPaciente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idPaciente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paciente other = (Paciente) obj;
		return idPaciente == other.idPaciente;
	}
	
	
}
