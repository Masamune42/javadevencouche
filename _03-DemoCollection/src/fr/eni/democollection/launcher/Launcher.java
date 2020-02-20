package fr.eni.democollection.launcher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Launcher {

	public static void main(String[] args) {
		Joueur j1 = new Joueur("Tony", 12);
		Joueur j2 = new Joueur("Nicolas", 8);
		
		//ArrayList<Joueur> joueurs = new ArrayList<>();
		List<Joueur> joueurs = new ArrayList<>();
		
		joueurs.add(j1);
		joueurs.add(j2);
		
		Map<Integer, Joueur> equipe = new HashMap<>();
		
		equipe.put(j1.numero, j1);
		equipe.put(j2.numero,j2);
		
		System.out.println(equipe.get(8).toString());
		
	}

}
