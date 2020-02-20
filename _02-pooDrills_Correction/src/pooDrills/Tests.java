/**
 * 
 */
package pooDrills;

public class Tests {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Consignes : Ceci est un exercice � trous, vous ne devez pas modifier le code
		// existant,
		// seulement en ajouter.
		// Le resultat affich� dans la console doit correspondre au fichier
		// AFFICHAGE_ATTENDU.txt fourni

		// Drill 1 - Cr�er une instance d'une personne ayant pour pr�nom G�rard,
		// pour nom Mansoif et ayant 33 ans. Affecter l'instance � la variable p.
		Personne p = null;
		/************************* Votre code : ****************************/
		p = new Personne("Mansoif", "Gerard", 33);
		Personne gerard = p;
		/*********************************************************************/
		System.out.println("Drill 1 : " + p.toString());

		// Drill 2 : afficher le nom et le prenom de la personne uniquement
		// en utilisant System.out.format(...)
		System.out.println("\nDrill 2 : ");
		/************************* Votre code : ****************************/
		System.out.format("Nom: %s %nPrenom: %s ", 
				 p.getNom(),
				 p.getPrenom());
		/*********************************************************************/

		// Drill 3 - Changez l'�ge de Nordine � 44 ans
		p = new Personne("Nordine", "Ateur", 36);		
		/************************* Votre code : ****************************/
		
		p.setAge(44);
		/*********************************************************************/
		System.out.println("\nDrill 3 : Nordine doit avoir 44 ans : " + p.toString());

		// Drill 4
		// Modifiez l'�ge de G�rard � 65 et affichez l'�tat de l'objet
		// (Seul l'�ge doit �tre modifi�)
		/*************************  Votre code :  ****************************/ 
		p = gerard;
		p.setAge(65);
		/*********************************************************************/
		System.out.println("\nDrill 4 : G�rard a mainteant 65 ans : " + p.toString());

		// Drill 5
		p = new Personne("Tony", "Parker", 44);
		Joueur j1 = new Joueur();
		j1.setNumero(10);
		j1.setPersonne(p);
		p = null;
		System.out.println("\nDrill 5 : Affichage du joueur : " + j1.toString());
		// Quel est l'effet de la ligne p=null; ?
		// Votre r�ponse : Rien ne se passe - L'instance reste

		// Drill 6 : Changez l'age du joueur Tony Parker � 52 en utilisant la variable j1
		/*************************  Votre code :  ****************************/ 
		j1.getPersonne().setAge(52);
		/*********************************************************************/
		System.out.println("\nDrill 6 : Tony Parker doit maintenant avoir 52 ans : " + j1.toString());
		
		
		// Drill 7
		Joueur j2 = new Joueur();
		j2.setPersonne(new Personne("BATUM", "Nicolas", 40));
		j2.setNumero(5);

		Joueur j3 = new Joueur();
		j3.setPersonne(new Personne("WILLIAMS", "Marvin", 29));
		j3.setNumero(12);

		Joueur j4 = new Joueur();
		j4.setPersonne(new Personne("ZELLER", "Cody", 42));
		j4.setNumero(23);

		Joueur j5 = new Joueur();
		j5.setPersonne(new Personne("WALKER", "Kemba", 31));
		j5.setNumero(9);

		// Codez la m�thode ajouterJoueur de la classe Equipe et testez en
		// ajoutant Nicolas Batum, Marvin Williams, et Cody Zeller � l'equipe des
		// Charlotte HORNETS
		Equipe charlotteHornets = new Equipe("Charlotte Hornets");
		charlotteHornets.ajouterJoueur(j1);
		charlotteHornets.ajouterJoueur(j2);
		charlotteHornets.ajouterJoueur(j3);
		charlotteHornets.ajouterJoueur(j4);
		charlotteHornets.ajouterJoueur(j5);

		// Drill 8 : Codez la m�thode afficherEquipe de la classe Equipe
		System.out.println("\nDrill 8 : Liste des joueurs des Charlotte hornets : ");
		charlotteHornets.afficherEquipe();

		// Drill 9
		// Codez la m�thode supprimerJoueur de la classe Equipe et testez en
		// supprimant le joueur num�ro 9 de l'�quipe des Charlotte HORNETS
		charlotteHornets.supprimerJoueur(9);
		System.out.println("\nDrill 9 : Le joueur num�ro 9 est vir� des Charlotte Hornets");
		charlotteHornets.afficherEquipe();

		// Drill 10
		// Ajouter une m�thode � la classe Equipe pour supprimer un joueur par son nom
		// et pr�nom
		// Testez en supprimant le joueur Cody ZELLER de l'equipe des Charlotte Hornets
		System.out.println("\nDrill 10 : Cody ZELLER est vir� !");
		/*************************  Votre code :  ****************************/ 
		charlotteHornets.supprimerJoueur(j4.getPersonne().getNom(),
				                          j4.getPersonne().getPrenom());
		/*********************************************************************/
		charlotteHornets.afficherEquipe();

		// Drill 11
		// TODO: Passez Marvin Williams dans l'�quipe des Los Angeles LAKERS
		Equipe lal = new Equipe("Los Angeles LAKERS");
		lal.ajouterJoueur(j3);
		System.out.println("\nDrill 11 : Marvin Williams va � Los Angeles LAKERS");
		lal.afficherEquipe();
		charlotteHornets.afficherEquipe();

	}

}
