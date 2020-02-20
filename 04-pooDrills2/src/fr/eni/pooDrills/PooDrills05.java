package fr.eni.pooDrills;

import fr.eni.pooDrills.modele.Personne;

public class PooDrills05 {

	private static int TAILLE = 10;

	public static void main(String[] args) {
		Personne[] tabPersonnes = new Personne[TAILLE];
		int index = 0;
		tabPersonnes[index++] = new Personne(1, "bob");
		tabPersonnes[index++] = new Personne(2, "jim");
		tabPersonnes[index++] = new Personne(3, "jane");
		tabPersonnes[index++] = new Personne(4, "jason");

		// Ajouter le code nécessaire pour que les instructions
		// suivantes trouvent jane
		boolean trouve = false;
		int i = 0;
		Personne persCherchee = new Personne(3, "jane");

		while (!trouve && i < index) {
			if (tabPersonnes[i].equals(persCherchee)) {
				System.out.println("La personne " + persCherchee + " est dans la liste !");
				trouve = true;
			}
			i++;
		}
		if (!trouve) {
			System.out.println("La personne n'est pas dans la liste");
		}

	}

}
