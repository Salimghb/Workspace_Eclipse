package projet;

import java.util.*;

public class EnsemblesSalles {
	private List <Salle> p;

	//Initialisation de la liste
	public EnsemblesSalles(){
		p=new ArrayList<Salle>();
	}

	//Ajouter une salle a la liste
	public void ajouterSalle(int index, Salle s){
		p.add(index,s);
	}
	public void ajouterSalle(Salle s){
		p.add(s);
	}

	//Rechercher une salle dans la liste
	public Salle RechercherSalle (String nom){
		Iterator <Salle> itr=iterator();	
		while(itr.hasNext()){
			Salle s= itr.next();
			if(s.getNomSalle().equalsIgnoreCase(nom)){
				return s;
			}
		}
		System.out.println("Aucune salle n'a ce nom");
		return null;
	}

	//Iterator
	public Iterator<Salle> iterator() {
		Iterator<Salle> itr=p.iterator();
		return itr;
	}

	public String toString(){
		String s="";
		Iterator<Salle> itr = p.iterator();
		while(itr.hasNext()) {
			Salle salle = itr.next();
			s+=salle.toString() + "\n"+ "\n";
		}
		return s;
	}
}
