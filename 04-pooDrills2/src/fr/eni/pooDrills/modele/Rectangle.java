package fr.eni.pooDrills.modele;

public class Rectangle extends Forme {
	//Attributs
		private float largeur;
		private float hauteur;
		
		
		
		public Rectangle(float largeur, float hauteur) {
			this.largeur = largeur;
			this.hauteur = hauteur;
		}

		//Méthodes
		public float calculerSurface() {
			return largeur * hauteur;
		}
		
		//Getters et Setters
		public float getLargeur() {
			return largeur;
		}
		
		public void setLargeur(float largeur) {
			this.largeur = largeur;
		}
		
		public float getHauteur() {
			return hauteur;
		}
		
		public void setHauteur(float hauteur) {
			this.hauteur = hauteur;
		}

		@Override
		public String toString() {
			return "Rectangle [largeur=" + largeur + ", hauteur=" + hauteur + "]";
		}
		
		

}
