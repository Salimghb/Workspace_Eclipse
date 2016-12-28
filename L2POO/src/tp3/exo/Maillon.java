package tp3.exo;

public class Maillon {
	private Object valeur;
	private Maillon suivant;
	public Maillon(Object s, Maillon m) {
		valeur = s;
		suivant = m;
	}
	public Object getValeur() {
		return valeur;
	}
	public void setValeur(Object valeur) {
		this.valeur = valeur;
	}
	public Maillon getSuivant() {
		return suivant;
	}
	public void setSuivant(Maillon suivant) {
		this.suivant = suivant;
	}
}

