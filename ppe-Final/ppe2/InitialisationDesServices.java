package initialisation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modele.Service;

public class InitialisationDesServices {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("annuaire");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Service s1 = new Service("COMPTA", "Service Comptabilité Générale", "bâtiment A");
		Service s2 = new Service("DRH", "Direction des Ressources Humaine", "bâtiment A");
		Service s3 = new Service("INFO", "Service Informatique", "bâtiment B");
		Service s4 = new Service("CLIENT", "Service Client", "bâtiment C");
		Service s5 = new Service("MARKET", "Service Marketing", "bâtiment A");
		
		em.persist(s1);
		em.persist(s2);
		em.persist(s3);
		em.persist(s4);
		em.persist(s5);
		
		em.flush();
		em.getTransaction().commit();
		em.close();
		emf.close();	

	}

}
