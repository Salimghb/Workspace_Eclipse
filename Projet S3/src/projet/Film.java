package projet;

public class Film extends Spectacle{
	private String realisateur;
	private Heure duree;
	public Film(String realisateur, Heure duree,String interpretes, String titre) {
		super(interpretes, titre);
		this.realisateur = realisateur;
		this.duree = duree;
	}

	public String getRealisateur() {
		return realisateur;
	}
	public void setRealisateur(String realisateur) {
		this.realisateur = realisateur;
	}
	public Heure getDuree() {
		return duree;
	}
	public void setDuree(Heure duree) {
		this.duree = duree;
	}

	
	public String toString() {
		return super.toString()+
				"\n Realisateur :" + realisateur + 
				"\n Durée :" + duree;
	}
}
