package tp2.exo;

public class CompteurKilometrique {
	private double compTotal;
	private double comptRelatif;
	
	public CompteurKilometrique(){
		compTotal = 0;
		comptRelatif = 0;
	}
	void resetKmJournalier(){
		this.comptRelatif=0;
	}
	void comptabiliser (double kmParcouru){
		this.compTotal+=kmParcouru;
		this.comptRelatif+=kmParcouru;
	}
	public double getCompTotal() {
		return compTotal;
	}
	public void setCompTotal(double compTotal) {
		this.compTotal = compTotal;
	}
	public double getComptRelatif() {
		return comptRelatif;
	}
	public void setComptRelatif(double comptRelatif) {
		this.comptRelatif = comptRelatif;
	}
	
}
