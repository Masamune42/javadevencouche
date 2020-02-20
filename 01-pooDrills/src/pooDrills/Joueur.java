/**
 * 
 */
package pooDrills;

/**
 * @author sgobin
 *
 */
public class Joueur {

	private Personne personne ;
	private int numero;
	private Equipe equipe;

	/**
	 * @return the personne
	 */
	public Personne getPersonne() {
		return personne;
	}

	/**
	 * @param personne the personne to set
	 */
	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	/**
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * @return the equipe
	 */
	public Equipe getEquipe() {
		return equipe;
	}

	/**
	 * @param equipe the equipe to set
	 */
	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public String toString() {
		return "Joueur [personne=" + personne.toString() + ", numero=" + numero + ", equipe=" + equipe + "]";
	}
	
}
