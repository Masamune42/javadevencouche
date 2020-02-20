/**
 * 
 */
package pooDrills;

/**
 * @author sgobin
 *
 */
public class Personne {

	private String nom;
	
	private String prenom;
	
	private int age;


	public Personne() {
	}
	
	/**
	 * @param nom
	 * @param prenom
	 * @param age
	 */
	public Personne(String nom, String prenom, int age) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
	}
	
	
	
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}


	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + ", age=" + age + "]";
	}
	
	
	
}
