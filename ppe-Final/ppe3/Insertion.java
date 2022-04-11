package outils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import modele.Employe;
import modele.Poste;
import modele.Service;
import ressources.CreationRacine;
import ressources.CreationService;

public class Insertion {

	private XStream xstream = new XStream(new StaxDriver());

	public Insertion() {
		super();
		this.parametrage();
	}

	private void parametrage() {
		Class<?>[] classes = new Class[] {CreationRacine.class, CreationService.class, Employe.class, Poste.class};
		XStream.setupDefaultSecurity(xstream);
		xstream.allowTypes(classes);
		xstream.alias("creation", CreationRacine.class);
		xstream.alias("employe", Employe.class);
		xstream.alias("service", CreationService.class);
		xstream.aliasField("telephone-fixe", Employe.class, "telephoneFixe");
		xstream.aliasField("telephone-mobile", Employe.class, "telephoneMobile");
		xstream.aliasField("poste", Employe.class, "poste");
		xstream.aliasField("nom-abrege", CreationService.class, "nomAbrege");
		xstream.addImplicitCollection(CreationRacine.class, "services");
		xstream.addImplicitCollection(CreationService.class, "employes");
		xstream.setMode(XStream.XPATH_RELATIVE_REFERENCES);		
	}
	
	public void insertion(String xml) throws Exception {
					
		CreationRacine creation = (CreationRacine) xstream.fromXML(xml);
		
		// connexion à la base de données via JPA
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("annuaire");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
				// restauration des objets de type Service via JPA et la requête SELECT ci-dessous
				for(CreationService iter: creation.getServices()) {
					Query requete = em.createNativeQuery("SELECT * FROM SERVICE WHERE NOMABREGE = ?", Service.class);
					requete.setParameter(1, iter.getNomAbrege());
					Service service = (Service) requete.getSingleResult();
					// ajout de chaque nouvel employé dans son service d'affectation
					for(Employe e: iter.getEmployes()) {
						service.ajouterEmploye(e);
						// si l'employé est le responsable du service
						if(e.isResponsable()) service.setResponsable(e);
					}
					// persistance par transitivité d'un service et de ses nouveaux employés
					em.persist(service);
				}		
		em.flush();
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	
}
