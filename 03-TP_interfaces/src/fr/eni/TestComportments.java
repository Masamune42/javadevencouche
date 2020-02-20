package fr.eni;

import java.util.ArrayList;

public class TestComportments {

	public static void main(String[] args) {
		
		Cheval tornado = new Cheval();
		tornado.communiquer();
		tornado.dormir();
		tornado.galoper();
		
		
		Humain zorro = new Humain();
		zorro.communiquer();
		zorro.dormir();
		zorro.siffler();
		
		
		System.out.println("\nETAPE 1 : ");
		ArrayList<Animal> animals = new ArrayList<Animal>();
		animals.add(zorro);
		animals.add(tornado);
		
		for (Animal animal : animals) {
			animal.communiquer();
			animal.dormir();
		}
		
		System.out.println("\nETAPE 2 : ");
		Animal anonyme1 = tornado ;
		anonyme1.communiquer() ;
		Animal anonyme2 = zorro ;
		anonyme2.communiquer() ;
		// le cheval et l'humain ont tous les 2 une façon différente de communiquer mais avec la méthode de son type réel (animal)
		
		Humain inconnu = (Humain) anonyme2 ;
		inconnu.siffler() ;
		// On cast anonyme2 en humain pour définir que c'est un humain et pour le faire siffler comme un humain si c'est le cas
		
		
		
// DECOMMENTER POUR LA QUESTION 6 		
//		Oiseau titi = new Oiseau();
//		titi.siffler();
//		titi.communiquer();
//		titi.dormir();		

	}

}
