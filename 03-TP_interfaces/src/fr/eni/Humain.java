package fr.eni;

public class Humain implements Animal {
	
	@Override
	public void dormir() {
		System.out.println("Zzzzz comme un humain");
	}
	
	@Override
	public void communiquer() {
		System.out.println("Bonjour");
	}
	
	public void siffler () {
		System.out.println("Pfiouiou");
	}
}
