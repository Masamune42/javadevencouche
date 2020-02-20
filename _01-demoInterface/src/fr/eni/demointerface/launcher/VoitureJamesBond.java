package fr.eni.demointerface.launcher;

public class VoitureJamesBond extends Vehicule implements Volant {

	@Override
	public void voler() {
		System.out.println("OK, je sais pas si la voiture de James Bond vole, j'ai juste recopié un exemple...");
		
	}
	
	public void avancer() {
		System.out.println("Avance");
	}

}
