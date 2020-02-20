/**
 * 
 */
package pooDrills;

/**
 * @author sgobin
 *
 */
public class Equipe {

	private String nom;

	private Joueur[] joueurs;

	public Equipe() {
		joueurs = new Joueur[10];
		for (int i = 0; i < 10; i++) {
			joueurs[i] = null;
		}

	}

	/**
	 * @param nom
	 */
	public Equipe(String nom) {

		this();
		this.nom = nom;
	}

	/**
	 * Cette méthode permet d'ajouter un joueur à l'équipe
	 * 
	 * @param j
	 */
	public void ajouterJoueur(Joueur j) {
		/************************* Votre code : ****************************/
		int i = 0;
		boolean test = false;
		if (j.getEquipe() != null) {
			j.getEquipe().supprimerJoueur(j.getNumero());
		}
		do {
			
			if (joueurs[i] == null) {
				
				joueurs[i] = j;
				joueurs[i].setEquipe(this);
				test = true;

			} else {
				i++;
			}
		} while (!test && i < joueurs.length);
		/*********************************************************************/
	}

	/**
	 * Cette méthode permet d'enlever un joueur de l'equipe en fonction de son
	 * numéro
	 * 
	 * @param numeroDuJoueur
	 */
	public void supprimerJoueur(int numeroDuJoueur) {
		/************************* Votre code : ****************************/
		for (int i = 0; i < joueurs.length; i++) {
			if (joueurs[i] != null && joueurs[i].getNumero() == numeroDuJoueur) {
				joueurs[i].setEquipe(null);
				joueurs[i] = null;
			}
			
		}
		/*********************************************************************/
	}

	/************************* Votre code : ****************************/
	// Supprimer un joueur en connaissant son nom et son prenom
	
	public void supprimerJoueur(String nom, String prenom) {
		for (int i = 0; i < joueurs.length; i++) {
			if (joueurs[i] != null && joueurs[i].getPersonne().getNom().equals(nom) && joueurs[i].getPersonne().getPrenom().equals(prenom)) {
				joueurs[i].setEquipe(null);
				joueurs[i] = null;
			}
			
		}
	}
	/*********************************************************************/

	/**
	 * Affiche sur la console la liste des joueurs de l'equipe
	 */
	public void afficherEquipe() {
		/************************* Votre code : ****************************/
		for (Joueur joueur : joueurs) {
			if(joueur != null) {
				System.out.println(joueur.getPersonne() +", numero : " + joueur.getNumero() +", " + joueur.getEquipe());
			}
		}
		/*********************************************************************/
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Equipe [nom=" + nom + "]";
	}

}
