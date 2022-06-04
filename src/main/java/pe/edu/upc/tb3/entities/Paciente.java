package pe.edu.upc.tb3.entities;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Paciente")
public class Paciente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "FechaPaciente", nullable = false)
	private Date FechaPaciente;

	@Column(name = "AnotacionesPaciente", nullable = false, length = 46)
	private String AnotacionesPaciente;

	public Paciente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Paciente(int idPaciente, String nombrePaciente, String apellidoPaciente, String celularPaciente,
			String direccionPaciente, String sexoPaciente, String dNIPaciente, Date fechaPaciente,
			String anotacionesPaciente) {
		super();
		this.idPaciente = idPaciente;
		this.NombrePaciente = nombrePaciente;
		this.ApellidoPaciente = apellidoPaciente;
		this.CelularPaciente = celularPaciente;
		this.DireccionPaciente = direccionPaciente;
		this.SexoPaciente = sexoPaciente;
		this.DNIPaciente = dNIPaciente;
		this.FechaPaciente = fechaPaciente;
		this.AnotacionesPaciente = anotacionesPaciente;
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
		this.NombrePaciente = nombrePaciente;
	}

	public String getApellidoPaciente() {
		return ApellidoPaciente;
	}

	public void setApellidoPaciente(String apellidoPaciente) {
		this.ApellidoPaciente = apellidoPaciente;
	}

	public String getCelularPaciente() {
		return CelularPaciente;
	}

	public void setCelularPaciente(String celularPaciente) {
		this.CelularPaciente = celularPaciente;
	}

	public String getDireccionPaciente() {
		return DireccionPaciente;
	}

	public void setDireccionPaciente(String direccionPaciente) {
		this.DireccionPaciente = direccionPaciente;
	}

	public String getSexoPaciente() {
		return SexoPaciente;
	}

	public void setSexoPaciente(String sexoPaciente) {
		this.SexoPaciente = sexoPaciente;
	}

	public String getDNIPaciente() {
		return DNIPaciente;
	}

	public void setDNIPaciente(String dNIPaciente) {
		this.DNIPaciente = dNIPaciente;
	}

	public Date getFechaPaciente() {
		return FechaPaciente;
	}

	public void setFechaPaciente(Date fechaPaciente) {
		this.FechaPaciente = fechaPaciente;
	}

	public String getAnotacionesPaciente() {
		return AnotacionesPaciente;
	}

	public void setAnotacionesPaciente(String anotacionesPaciente) {
		this.AnotacionesPaciente = anotacionesPaciente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(AnotacionesPaciente, ApellidoPaciente, CelularPaciente, DNIPaciente, DireccionPaciente,
				FechaPaciente, NombrePaciente, SexoPaciente, idPaciente);
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
		return Objects.equals(AnotacionesPaciente, other.AnotacionesPaciente)
				&& Objects.equals(ApellidoPaciente, other.ApellidoPaciente)
				&& Objects.equals(CelularPaciente, other.CelularPaciente)
				&& Objects.equals(DNIPaciente, other.DNIPaciente)
				&& Objects.equals(DireccionPaciente, other.DireccionPaciente)
				&& Objects.equals(FechaPaciente, other.FechaPaciente)
				&& Objects.equals(NombrePaciente, other.NombrePaciente)
				&& Objects.equals(SexoPaciente, other.SexoPaciente) && idPaciente == other.idPaciente;
	}
}
