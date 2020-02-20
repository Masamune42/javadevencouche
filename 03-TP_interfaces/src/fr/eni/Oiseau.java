package fr.eni;

public class Oiseau implements Siffleur, Animal {

	@Override
	public void siffler () {
		System.out.println("Triliiiliiiiouuu");
	}

	@Override
	public void dormir() {
		System.out.println("Zzzzzzzzz");
		
	}

	@Override
	public void communiquer() {
		siffler();
		
	}
}
