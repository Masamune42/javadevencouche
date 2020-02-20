package observer;

public class TestPatternObservateur {

	
	public static void main(String[] args) {
		//NE PAS MODIFIER CETTE METHODE !!
		
		//Instanciation du sujet
		Sujet sujet = new Sujet();
		
		//Test avant inscription des observateurs
		System.out.println("Test avant inscription des observateurs:");
		sujet.evenement(); //Doit afficher "Emission evenement..."
		
		
		//Inscription des observateurs
		Observateur obsA = new A();
		sujet.inscrireObservateur(obsA);
		
		Observateur obsB = new B();
		sujet.inscrireObservateur(obsB);
		
		//Test après inscription des observateurs
		System.out.println("\nTest après inscription des observateurs: ");
		
		sujet.evenement(); //Doit afficher "Emission evenement..."
						   //              "A a reçu un evenement."
		                   //              "B a reçu un evenement."
		
	}

	
	
}
