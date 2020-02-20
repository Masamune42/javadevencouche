package observer;

public class A implements Observateur {

	@Override
	public void traiterEvenement() {
		System.out.println("A a reçu un evenement.");
		
	}

}
