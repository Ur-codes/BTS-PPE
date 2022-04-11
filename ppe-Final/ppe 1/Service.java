package modele;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Service {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idservice;
	@Column(nullable = false, unique = true)
	private String nomAbrege;
	@Column(nullable = false)
	private String nomLong;
	@Column(nullable = false)
	private String localisation;
	@OneToMany(mappedBy = "service", cascade = CascadeType.PERSIST)
	private List<Employe> employes = new ArrayList<>();
	@OneToOne
	@JoinColumn(name = "responsable_fk")
	private Employe responsable;
	
	public void ajouterEmploye(Employe nouvel) {
		employes.add(nouvel);
		nouvel.setService(this);
	}

	public Service() {
		super();
	}

	public Service(String nomAbrege, String nomLong, String localisation) {
		super();
		this.nomAbrege = nomAbrege;
		this.nomLong = nomLong;
		this.localisation = localisation;
	}

	public int getIdservice() {
		return idservice;
	}

	public void setIdservice(int idservice) {
		this.idservice = idservice;
	}

	public String getNomAbrege() {
		return nomAbrege;
	}

	public void setNomAbrege(String nomAbrege) {
		this.nomAbrege = nomAbrege;
	}

	public String getNomLong() {
		return nomLong;
	}

	public void setNomLong(String nomLong) {
		this.nomLong = nomLong;
	}

	public String getLocalisation() {
		return localisation;
	}

	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}

	public List<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}

	public Employe getResponsable() {
		return responsable;
	}

	public void setResponsable(Employe responsable) {
		this.responsable = responsable;
	}

	@Override
	public String toString() {
		return "Service [idservice=" + idservice + ", nomAbrege=" + nomAbrege + ", nomLong=" + nomLong
				+ ", localisation=" + localisation + ", responsable=" + responsable + "]";
	}

}
