package projet;

public class SalleTheatre extends Salle {
	private int nbFauteuils;
	private double prixFauteuil;
	public SalleTheatre(int nbFauteuils,double prixFauteuil,String nomSalle,
			int capacité, double tarif, int nbPlacesStandard){
		super(nomSalle,capacité,tarif,nbPlacesStandard);
		this.nbFauteuils=nbFauteuils;
		this.prixFauteuil=prixFauteuil;
	}
	
	
	public String toString() {
		return super.toString()
				+"\n Prix fauteuil : " + prixFauteuil
				+"\n Nombre de fauteuils : " + nbFauteuils;
	}
	
	
	public int getNbFauteuils() {
		return nbFauteuils;
	}
	public void setNbFauteuils(int nbFauteuils) {
		this.nbFauteuils = nbFauteuils;
	}
	public double getPrixFauteuil() {
		return prixFauteuil;
	}
	public void setPrixFauteuil(int prixFauteuil) {
		this.prixFauteuil = prixFauteuil;
	}

}
