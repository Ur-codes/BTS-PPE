package controleur;

import java.nio.charset.Charset;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.UploadedFile;

import outils.Insertion;



@ManagedBean(name = "uploadeur")
@RequestScoped
public class Controleur {
	
	private UploadedFile fichier = null;

	public Controleur() {
		super();
	}
	
	public void soumettre() {
		
		if(fichier.getSize() == 0) {
			FacesMessage message1 = new FacesMessage("il faut choisir un fichier");
			FacesContext.getCurrentInstance().addMessage(null, message1);
			return;
		}
		try {				
			   	byte[] flux = fichier.getContents();
				String xml = new String(flux, Charset.defaultCharset());
				Insertion insertion = new Insertion();
				insertion.insertion(xml);
				FacesMessage message2 = new FacesMessage("La mise à jour de l'annuaire est terminée");
				FacesContext.getCurrentInstance().addMessage(null, message2);				
		} catch (Exception e) { 
				FacesMessage message3 = new FacesMessage("Un problème a été rencontré, prévenir le service informatique");
				FacesContext.getCurrentInstance().addMessage(null, message3);
				e.printStackTrace();
			}			
	}

	public UploadedFile getFichier() {
		return fichier;
	}

	public void setFichier(UploadedFile fichier) {
		this.fichier = fichier;
	}	
}