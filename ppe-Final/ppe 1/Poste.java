package modele;

public enum Poste {
	
	CADRE("cadre"), TECHNICIEN("technicien"), EMPLOYE("employé");
	
	Poste(String libelle) {
		this.libelle = libelle;
	}

	private String libelle;

	public String getLibelle() {
		return libelle;
	}
}
