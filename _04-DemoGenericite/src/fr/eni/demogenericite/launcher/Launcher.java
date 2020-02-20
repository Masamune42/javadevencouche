package fr.eni.demogenericite.launcher;

import java.util.ArrayList;

public class Launcher {

	public static void main(String[] args) {
		ArrayList<String> maListe = new ArrayList<>();
		
		maListe.add("riri");
		maListe.add("fifi");
		maListe.add("loulou");
		//maListe.add(125); // Pas possible avec la généricité
		
		System.out.println((String)maListe.get(3));

	}

}
