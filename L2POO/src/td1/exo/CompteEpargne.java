package td1.exo;

public class CompteEpargne extends CompteBancaire{
	private double tauxInterets;
	private double plafond;

	public CompteEpargne ( String nom,String adresse, double tauxInterets, double plafond) {
		super ( nom, adresse );
		this.tauxInterets = tauxInterets;
		this.setPlafond(plafond);
	}
	public void traitementQuotidien () {
		créditer (getSolde()* tauxInterets);
		}
	public double getPlafond() {
		return plafond;
	}
	public void setPlafond(double plafond) {
		this.plafond = plafond;
	}
	
	public String toString(){
	return " Compte épargne " +super.toString();
	}

}


