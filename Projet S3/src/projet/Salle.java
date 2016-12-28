package projet;

public class Salle {	
	private String nomSalle;
	private int capacité;
	private double tarif;
	private int nbPlacesStandard;
	public Salle(String nomSalle, int capacité, double tarif, 
			int nbPlacesStandard){
		this.nomSalle=nomSalle;
		this.capacité=capacité;
		this.tarif=tarif;
		this.nbPlacesStandard=nbPlacesStandard;
	}
	public String toString() {
		return "Salle : "+nomSalle 
				+ "\n Capacité : " + capacité
				+ "\n Prix standard : " + tarif 
				+ "\n Prix réduit : " + tarif * 0.6
				+ "\n Nombre de places : " + nbPlacesStandard;
	}
	public String getNomSalle() {
		return nomSalle;
	}
	public void setNomSalle(String nomSalle) {
		this.nomSalle = nomSalle;
	}
	public int getCapacité() {
		return capacité;
	}
	public void setCapacité(int capacité) {
		this.capacité = capacité;
	}
	public double getTarif() {
		return tarif;
	}
	public void setTarif(double tarif) {
		this.tarif = tarif;
	}
	public int getNbPlacesStandard() {
		return nbPlacesStandard;
	}
	public void setNbPlacesStandard(int nbPlacesStandard) {
		this.nbPlacesStandard = nbPlacesStandard;
	}

	
}
