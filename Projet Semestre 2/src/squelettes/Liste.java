package squelettes;

public class Liste{
	public Maillon tete=null;
	// Ajout debut de liste	
	public void AjoutDebut (Carte item){
		if(tete==null){
			tete=new Maillon (item);
		}
		else {

			Maillon nouveauNoeud= new Maillon(item);
			nouveauNoeud.setSuivant(tete);
			tete=nouveauNoeud;
		}
	}
	//Ajout fin de liste
	public void AjoutFin (Carte item){
		if(tete==null){
			tete=new Maillon (item);
		}
		else{
			Maillon fin = new Maillon(item);
			fin= tete;
			while(fin.getSuivant()!=null){
				fin=fin.getSuivant();
			}
		}
	}
	
	public Maillon premier (){
		return tete;
	}
	
	public Carte infopremier (){
		assert (! this.estListeVide());
		return tete.getItem();
	}
	
	public boolean estListeVide(){
		if (tete==null)
			return true;
		else{
			return false;
		}
	}
}