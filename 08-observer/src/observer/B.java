package observer;

public class B implements Observateur {

	@Override
	public void traiterEvenement() {
		System.out.println("B a reçu un evenement.");

	}

}
