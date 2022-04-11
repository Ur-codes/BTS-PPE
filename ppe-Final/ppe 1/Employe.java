package modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Employe {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idemploye;
	@Column(nullable = false, unique = true)
	private String matricule;
	@Column(nullable = false)
	private String nom;
	@Column(nullable = false)
	private String prenom;
	@Column(name = "telephone_fixe", nullable = false, unique = true)
	private String telephoneFixe;
	@Column(name = "telephone_mobile", nullable = false, unique = true)
	private String telephoneMobile;
	@Column(nullable = false, unique = true)
	private String courriel;
	@ManyToOne
	@JoinColumn(name = "service_fk", nullable = false)
	private Service service;
	@Column(nullable = false)
	private boolean responsable = false;
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Poste poste;

	public Employe() {
		super();
	}

	public Employe(String matricule, String nom, String prenom, String telephoneFixe, String telephoneMobile,
			String courriel, Poste poste) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.telephoneFixe = telephoneFixe;
		this.telephoneMobile = telephoneMobile;
		this.courriel = courriel;
		this.poste = poste;
	}

	public long getIdemploye() {
		return idemploye;
	}

	public void setIdemploye(long idemploye) {
		this.idemploye = idemploye;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTelephoneFixe() {
		return telephoneFixe;
	}

	public void setTelephoneFixe(String telephoneFixe) {
		this.telephoneFixe = telephoneFixe;
	}

	public String getTelephoneMobile() {
		return telephoneMobile;
	}

	public void setTelephoneMobile(String telephoneMobile) {
		this.telephoneMobile = telephoneMobile;
	}

	public String getCourriel() {
		return courriel;
	}

	public void setCourriel(String courriel) {
		this.courriel = courriel;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}	

	public Poste getPoste() {
		return poste;
	}

	public void setPoste(Poste poste) {
		this.poste = poste;
	}

	public boolean isResponsable() {
		return responsable;
	}

	public void setResponsable(boolean responsable) {
		this.responsable = responsable;
	}

	@Override
	public String toString() {
		return "Employe [idemploye=" + idemploye + ", matricule=" + matricule + ", nom=" + nom + ", prenom=" + prenom
				+ ", telephoneFixe=" + telephoneFixe + ", telephoneMobile=" + telephoneMobile + ", courriel=" + courriel
				+ ", responsable=" + responsable + ", poste=" + poste + "]";
	}

	

	
}
