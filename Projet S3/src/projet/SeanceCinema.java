package projet;

public class SeanceCinema extends Seance{
	private Salle salle;
	private int nbPlacesVenduesTR;
	public SeanceCinema(int jour,int nbPlacesVenduesTN,Heure horaire,Salle salle,int nbPlacesVenduesTR){
		super(jour,nbPlacesVenduesTN,horaire);
		this.salle=salle;
		this.nbPlacesVenduesTR=nbPlacesVenduesTR;
	}
	//Methodes redéfinies a partir de la classe mère
	public int nbPlacesDispo() {
		return salle.getCapacité()-totalVendu();
	}

	public double tauxRemplissage() {
		return (100*nbPlacesDispo())/salle.getCapacité();
	}

	//TN+TR
	public int totalVendu() {
		return getNbPlacesVenduesTN()+getNbPlacesVenduesTR();
	}

	//Appeler pour vendre une place a tarif réduit
	public void vendrePlacesTR(int nbre){
		nbPlacesVenduesTR += nbre;
	}
	//Redefinition de compareTo, tri par jour puis par horaire
	public int compareTo(Seance s2){
		if(this.getJour() < s2.getJour()){
			return -1;
		}
		else{
			if(this.getJour() > s2.getJour()){
				return 1;
			}
		}
		//Si les jours sont egaux, compare les heures
		return (this.getHoraire()).compareTo(s2.getHoraire());
	}
	//Getters & Setters
	public int getNbPlacesVenduesTR() {
		return nbPlacesVenduesTR;
	}

	public void setNbPlacesVenduesTR(int nbPlacesVenduesTR) {
		this.nbPlacesVenduesTR = nbPlacesVenduesTR;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	//Redéfinition toString()
	public String toString(){
		return salle+
				"\n Jour : "+getJour()+
				"\n Horaire : "+getHoraire()+
				"\n Nombre de places restantes : "+nbPlacesDispo();
	}
}
