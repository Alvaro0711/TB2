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
@Table(name = "Psicologo")
public class Psicologo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPsicologo;

	@Column(name = "NombrePsicologo", nullable = false, length = 47)
	private String NombrePsicologo;

	@Column(name = "ApellidoPsicologo", nullable = false, length = 46)
	private String ApellidoPsicologo;

	@Column(name = "CelularPsicologo", nullable = false, length = 46)
	private String CelularPsicologo;

	@Column(name = "DireccionPsicologo", nullable = false, length = 45)
	private String DireccionPsicologo;

	@Column(name = "SexoPsicologo", nullable = false, length = 47)
	private String SexoPsicologo;

	@Column(name = "DNIPsicologo", nullable = false, length = 46)
	private String DNIPsicologo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "FechaInicioPsicologo", nullable = false)
	private Date FechaInicioPsicologo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "FechaFinalPsicologo", nullable = false)
	private Date FechaFinalPsicologo;

	@Column(name = "Sueldo", nullable = false, length = 46)
	private String Sueldo;

	public Psicologo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Psicologo(int idPsicologo, String NombrePsicologo, String ApellidoPsicologo, String CelularPsicologo,
			String DireccionPsicologo, String SexoPsicologo, String DNIPsicologo, Date FechaInicioPsicologo, Date FechaFinalPsicologo,
			String Sueldo) {
		super();
		this.idPsicologo = idPsicologo;
		this.NombrePsicologo = NombrePsicologo;
		this.ApellidoPsicologo = ApellidoPsicologo;
		this.CelularPsicologo = CelularPsicologo;
		this.DireccionPsicologo = DireccionPsicologo;
		this.SexoPsicologo = SexoPsicologo;
		this.DNIPsicologo = DNIPsicologo;
		this.FechaInicioPsicologo = FechaInicioPsicologo;
		this.FechaFinalPsicologo = FechaFinalPsicologo;
		this.Sueldo = Sueldo;
	}

	public int getIdPsicologo() {
		return idPsicologo;
	}

	public void setIdPsicologo(int idPsicologo) {
		this.idPsicologo = idPsicologo;
	}

	public String getNombrePsicologo() {
		return NombrePsicologo;
	}

	public void setNombrePsicologo(String nombrePsicologo) {
		NombrePsicologo = nombrePsicologo;
	}

	public String getApellidoPsicologo() {
		return ApellidoPsicologo;
	}

	public void setApellidoPsicologo(String apellidoPsicologo) {
		ApellidoPsicologo = apellidoPsicologo;
	}

	public String getCelularPsicologo() {
		return CelularPsicologo;
	}

	public void setCelularPsicologo(String celularPsicologo) {
		CelularPsicologo = celularPsicologo;
	}

	public String getDireccionPsicologo() {
		return DireccionPsicologo;
	}

	public void setDireccionPsicologo(String direccionPsicologo) {
		DireccionPsicologo = direccionPsicologo;
	}

	public String getSexoPsicologo() {
		return SexoPsicologo;
	}

	public void setSexoPsicologo(String sexoPsicologo) {
		SexoPsicologo = sexoPsicologo;
	}

	public String getDNIPsicologo() {
		return DNIPsicologo;
	}

	public void setDNIPsicologo(String dNIPsicologo) {
		DNIPsicologo = dNIPsicologo;
	}

	public Date getFechaInicioPsicologo() {
		return FechaInicioPsicologo;
	}

	public void setFechaInicioPsicologo(Date fechaInicioPsicologo) {
		FechaInicioPsicologo = fechaInicioPsicologo;
	}

	public Date getFechaFinalPsicologo() {
		return FechaFinalPsicologo;
	}

	public void setFechaFinalPsicologo(Date fechaFinalPsicologo) {
		FechaFinalPsicologo = fechaFinalPsicologo;
	}

	public String getSueldo() {
		return Sueldo;
	}

	public void setSueldo(String sueldo) {
		Sueldo = sueldo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ApellidoPsicologo, CelularPsicologo, DNIPsicologo, DireccionPsicologo, FechaFinalPsicologo,
				FechaInicioPsicologo, NombrePsicologo, SexoPsicologo, Sueldo, idPsicologo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Psicologo other = (Psicologo) obj;
		return Objects.equals(ApellidoPsicologo, other.ApellidoPsicologo)
				&& Objects.equals(CelularPsicologo, other.CelularPsicologo)
				&& Objects.equals(DNIPsicologo, other.DNIPsicologo)
				&& Objects.equals(DireccionPsicologo, other.DireccionPsicologo)
				&& Objects.equals(FechaFinalPsicologo, other.FechaFinalPsicologo)
				&& Objects.equals(FechaInicioPsicologo, other.FechaInicioPsicologo)
				&& Objects.equals(NombrePsicologo, other.NombrePsicologo)
				&& Objects.equals(SexoPsicologo, other.SexoPsicologo) && Objects.equals(Sueldo, other.Sueldo)
				&& idPsicologo == other.idPsicologo;
	}

	
}
