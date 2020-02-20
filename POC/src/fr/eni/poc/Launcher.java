package fr.eni.poc;

public class Launcher {

	public static void main(String[] args) {
		
		Personne p1 = new Personne("Bob", 1);
		Personne p2 = new Personne("Bob", 1);
		Personne p3 = new Personne("Rob", 1);
		
		String s1 = new String();
		String s2 = new String();
		
		s1="test1";
		s2="test1";
		
		System.out.println(p1.equals(p2));
		System.out.println(s1.equals(s2));
		System.out.println(p3);;

	}

}
