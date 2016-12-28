package tp2.exo;

public class Voiture {
	private String immatriculation;
	private CompteurKilometrique compteur;
	
	public Voiture (String immatriculation, CompteurKilometrique compteur){
		this.immatriculation=immatriculation;
		this.compteur=compteur;
	}
	public void rouler ( double kmParcouru){
		compteur.comptabiliser(kmParcouru);
	}
	public double getKmTotal (){
		return compteur.getCompTotal();
		
	}
	public double getKmJournalier (){
		return compteur.getComptRelatif();
		
	}
	public void resetKmJournalier (){
		compteur.resetKmJournalier();
	}
	public String getImmatriculation() {
		return immatriculation;
	}
	public CompteurKilometrique getCompteur() {
		return compteur;
	}
}
