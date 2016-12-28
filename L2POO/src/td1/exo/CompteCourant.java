package td1.exo;

public class CompteCourant extends CompteBancaire{
	private double tauxAgios;
	public CompteCourant(String nom,String adresse, double tauxAgios) {
		super (nom, adresse);
		this.tauxAgios = tauxAgios;
	}
	public void traitementQuotidien () {
		if (getSolde () < 0) {
			debiter (-1.0*getSolde()*tauxAgios);
		}
	}
	public String toString(){
	return " Compte courant " +super.toString();
	}


}
