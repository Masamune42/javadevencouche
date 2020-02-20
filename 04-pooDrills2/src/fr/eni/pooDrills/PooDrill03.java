package fr.eni.pooDrills;

import fr.eni.pooDrills.modele.Rectangle;

public class PooDrill03 {

	public static void main(String[] args) {

		//Créer une classe Rectangle pour que le 
		//code ci-dessous compile
		Rectangle rect = new Rectangle(12, 12);
		
		//Calculer et afficher la surface du rectangle
		System.out.println("Surface du rectangle = " + rect.calculerSurface());

	}

}
