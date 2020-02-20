package fr.eni;

public class Centaure extends Cheval implements Siffleur {

	@Override
	public void siffler() {
		System.out.println("siffle comme un centaure");
		
	}
	
	@Override
	public void communiquer() {
		System.out.println("Communique comme un centaure");
	}
	
}
