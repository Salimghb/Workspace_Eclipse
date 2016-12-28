package squelettes;

public class Maillon {
	private Carte item;
	private Maillon  suivant;

	public Maillon(Carte c) {
		item=c;
		suivant=null;
	}
	public Maillon(Carte c, Maillon  n){
		item=c;
		suivant=n;
	}
	public Carte getItem() {
		return item;
	}
	public void setItem(Carte _item){
		item=_item;
	}
	public Maillon  getSuivant() {
		return suivant;
	}
	public void setSuivant(Maillon  tete) {
		suivant = tete;
	}
}
