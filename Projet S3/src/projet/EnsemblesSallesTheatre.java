package projet;

import java.util.*;

public class EnsemblesSallesTheatre {
	private List <SalleTheatre> p;

	//Initialisation de la liste
	public EnsemblesSallesTheatre(){
		p=new ArrayList<SalleTheatre>();
	}

	//Ajouter une salle a la liste
	public void ajouterSalleTheatre(int index, SalleTheatre s){
		p.add(index,s);
	}
	public void ajouterSalleTheatre(SalleTheatre s){
		p.add(s);
	}

	//Rechercher une salle dans la liste
	public SalleTheatre RechercherSalleTheatre (String nom) {
		Iterator<SalleTheatre> itr=iterator();	
		while(itr.hasNext()){
			SalleTheatre s= itr.next();
			if(s.getNomSalle().equalsIgnoreCase(nom)){
				return s;
			}
		}
		System.out.println("Aucune salle de theatre n'a ce nom");
		return null;
	}

	//Iterator
	public Iterator<SalleTheatre> iterator() {
		Iterator<SalleTheatre> itr=p.iterator();
		return itr;
	}

	public String toString(){
		String s="";
		Iterator<SalleTheatre> itr = p.iterator();
		while(itr.hasNext()) {
			SalleTheatre salle = itr.next();
			s+=salle.toString() + "\n"+ "\n";
		}
		return s;
	}
}
