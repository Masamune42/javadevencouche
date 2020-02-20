package fr.eni.demointerface.launcher;

import java.util.ArrayList;

public class Launcher {

	public static void main(String[] args) {
		Volant v1 = new VoitureJamesBond();
		
		v1.voler();
		
		((VoitureJamesBond) v1).avancer();
		
		
		Superman superMan = new Superman();
		
		ArrayList<Volant> volants = new ArrayList<>();
		
		volants.add(superMan);
		volants.add(v1);
		
		System.out.println("Polymorphisme : ");
		for (Volant volant : volants) {
			volant.voler();
		}

	}

}
