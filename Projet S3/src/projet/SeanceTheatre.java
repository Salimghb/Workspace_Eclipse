package projet;

public class SeanceTheatre extends Seance{
	private SalleTheatre salleTheatre;
	private int nbFauteuilsVendus;
	public SeanceTheatre(int jour,int nbPlacesVenduesTN,Heure horaire,SalleTheatre salleTheatre,int nbFauteuilsVendus){
		super(jour,nbPlacesVenduesTN,horaire);
		this.salleTheatre=salleTheatre;
		this.nbFauteuilsVendus=nbFauteuilsVendus;
	}

	//Methodes redéfinies a partir de la classe mère
	public int nbPlacesDispo() {
		return salleTheatre.getCapacité()-totalVendu();
	}

	public double tauxRemplissage() {
		return (100*nbPlacesDispo())/salleTheatre.getCapacité();
	}

	//Fauteuils+balcon
	public int totalVendu() {
		return getNbPlacesVenduesTN()+getNbFauteuilsVendus();
	}

	//Retourne le nombre de places disponibles
	public int nbFauteuilsDispo(){
		return salleTheatre.getNbFauteuils()-nbFauteuilsVendus;
	}

	//Appeler pour vendre une place AVEC FAUTEUIL
	public void vendrePlacesFauteuil(int nbre){
		nbFauteuilsVendus += nbre;
	}

	//Redefinition de compareTo, seulement selon les jours 
	//car il n'y a qu'une seule seance par jour
	public int compareTo(Seance s2) {
		if(this.getJour() < s2.getJour()){
			return -1;
		}
		else{
			if(this.getJour() > s2.getJour()){
				return 1;
			}
			return 0;
		}
	}

	//Getters & Setters
	public int getNbFauteuilsVendus() {
		return nbFauteuilsVendus;
	}
	public void setNbFauteuilsVendus(int nbFauteuilsVendus) {
		this.nbFauteuilsVendus = nbFauteuilsVendus;
	}
	public SalleTheatre getSalleTheatre() {
		return salleTheatre;
	}
	public void setSalleTheatre(SalleTheatre salleTheatre) {
		this.salleTheatre = salleTheatre;
	}
	//Redéfinition toString()
		public String toString(){
			return salleTheatre+
					"\n Jour : "+getJour()+
					"\n Horaire : "+getHoraire()+
					"\n Nombre de places restantes : "+nbPlacesDispo()+
					"\n Nombre de fauteuils restants : "+nbFauteuilsDispo();
		}
}