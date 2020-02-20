package fr.eni;

public class Cheval implements Animal {

	@Override
	public void dormir() {
		System.out.println("Zzzzz comme un cheval");
	}
	
	@Override
	public void communiquer() {
		System.out.println("Hiiiihihihiiii");
	}
	
	public void galoper() {
		System.out.println("Cataclop, cataclop");
	}
}
