package observer;

import java.util.ArrayList;
import java.util.List;

public class Sujet {
	List<Observateur> listeObservateur;
	
	public Sujet() {
		listeObservateur = new ArrayList<>();
	}
	
	
	/*
	 * Description : Cette méthode correspond à l'émission d'un événement  
	 */
	public void evenement(){
		System.out.println("Emission evenement...");
		notifier();
	}

	public void inscrireObservateur(Observateur observateur) {
		listeObservateur.add(observateur);
		
	}
	
	private void notifier() {
		for (Observateur obs : listeObservateur) {
			obs.traiterEvenement();
		}
	}


}
