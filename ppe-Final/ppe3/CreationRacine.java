package ressources;

import java.util.ArrayList;
import java.util.List;

import modele.Service;

public class CreationRacine {
	
	private List<CreationService> services = new ArrayList<>();

	public CreationRacine() {
		super();
	}

	public List<CreationService> getServices() {
		return services;
	}

	public void setServices(List<CreationService> services) {
		this.services = services;
	}
}