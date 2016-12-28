package tp2.exo;

public class Pile {
	private Maillon sommet;
	public Pile(){
		sommet=null;
	}
	public void empiler(String s){
		sommet = new Maillon(s, sommet);
	}
	public String depiler (){
		String dep;

		assert(!estVide());
		dep = sommet.getValeur();
		sommet = sommet.getSuivant();
		return dep;
	}
	public Maillon getSommet(){
		return sommet;
	}
	public boolean estVide(){
		if (this.sommet!= null) 
			return true;
		return false;
	}
}
