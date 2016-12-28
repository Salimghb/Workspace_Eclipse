package tp3.exo;

public class Pile {
	private Maillon sommet;
	public Pile(){
		sommet=null;
	}
	public void empiler(String s){
		sommet = new Maillon(s, sommet);
	}
	public Object depiler (){
		Object dep;

		assert(!estVide());
		dep = sommet.getValeur();
		sommet = sommet.getSuivant();
		return dep;
	}
	public Maillon getSommet(){
		return sommet;
	}
	public boolean estVide(){
		return(this.sommet!= null);
	}
	public String toString(){
		Maillon courant=sommet;
		String s = "[";
		while (courant!=null){
			Object t=courant.getValeur();
			s+=t.toString()+" ";
			courant=courant.getSuivant();
		}
		s+="]";
		return s;
	}
}
