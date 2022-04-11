package ressources;

import java.util.ArrayList;
import java.util.List;

import modele.Employe;

public class CreationService {
	
	private String nomAbrege;
	private List<Employe> employes = new ArrayList<>();

	public CreationService() {
		super();
	}

	public String getNomAbrege() {
		return nomAbrege;
	}

	public void setNomAbrege(String nomAbrege) {
		this.nomAbrege = nomAbrege;
	}
	
	

	public List<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}

	@Override
	public String toString() {
		return "CreationService [nomAbrege=" + nomAbrege + "]";
	}

	
}
