package projet;

public abstract class Seance {
	private int jour;
	private int nbPlacesVenduesTN;
	private Heure horaire;
	public Seance(int jour,int nbPlacesVenduesTN,Heure horaire){
		this.jour=jour;
		this.nbPlacesVenduesTN=nbPlacesVenduesTN;
		this.horaire=horaire;
	}

	//Renvoie le nbre de places restantes
	public abstract int nbPlacesDispo();

	//Calcule en pourcentage le taux de remplissage de la salle pour la séance.
	public abstract double tauxRemplissage();

	//Renvoie le nbre de places vendues
	public abstract int totalVendu();
	
	//Redéfinition de compareTo() pour une comparaison chronologique (q9)
	public abstract int compareTo(Seance s2);
	
	//Appeler pour vendre une place
	public void vendrePlacesTN(int nbre){
		nbPlacesVenduesTN += nbre;
	}
	
	//Getters & Setters
	public Heure getHoraire() {
		return horaire;
	}
	public void setHoraire(Heure horaire) {
		this.horaire = horaire;
	}
	public int getNbPlacesVenduesTN() {
		return nbPlacesVenduesTN;
	}
	public int getJour() {
		return jour;
	}
	public void setJour(int jour) {
		this.jour = jour;
	}
}
