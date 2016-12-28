package projet;
import java.util.*;
public class ProgrammationTheatre {
	private List <SeanceTheatre> p;
	//Initialisation de la liste
	public ProgrammationTheatre(){
		p=new ArrayList<SeanceTheatre>();
	}

	//Ajoute une seance
	void ajouterSeance(int index, SeanceTheatre seance){
		p.add(index,seance);
	}
	void ajouterSeance(SeanceTheatre seance){
		p.add(seance);
	}

	//Supprime une seance
	public void supprimerSeance(SeanceTheatre seance){
		p.remove(seance);
	}

	//Cherche la seance correspondant à l'horaire/jour
	public SeanceTheatre chercher (int jour){
		Iterator<SeanceTheatre> itr = p.iterator();
		while(itr.hasNext()){
			SeanceTheatre seance = itr.next();
			if(seance.getJour()==jour){
				return seance;
			}
		}
		System.out.println("Aucune séance ne correspond à ce jour de la semaine");
		return null;
	}

	//Calcule le taux de remplissage en pourcentage pour la séance
	public double tauxRemplissage(int jour){
		return chercher(jour).tauxRemplissage();
	}

	//Retourne le chiffre d'affaires pour de la piece en fonction du nombre total de places vendues pour toutes les seances(Fauteuils+TN)	
	public double chiffreAffaire(){
		Iterator<SeanceTheatre> itr = p.iterator();
		double i=0;
		while(itr.hasNext()) {
			SeanceTheatre theatre = itr.next();
			i+= theatre.getNbPlacesVenduesTN()*theatre.getSalleTheatre().getTarif()
					+
					theatre.getSalleTheatre().getPrixFauteuil()*(theatre.getNbFauteuilsVendus()) ;
		}
		return i;
	}

	//Iterator
	public Iterator<SeanceTheatre> iterator() {
		Iterator<SeanceTheatre> itr=p.iterator();
		return itr;
	}

	//Tri de la liste par jour/horaire
	//Classe interne
	public void tripardate (){
		Collections.sort(p, new Comparator<SeanceTheatre>() {
			public int compare(SeanceTheatre s1, SeanceTheatre s2) {
				return s1.compareTo(s2);
			}
		});
	}

	//Redéfinition de la méthode toString pour la liste des seances
	public String toString(){
		Iterator<SeanceTheatre> itr = p.iterator();
		String s="";
		while(itr.hasNext()) {
			SeanceTheatre seance = itr.next();
			s+=seance.toString() + "\n"+ "\n";
		}
		return s;
	}

	public String toStringEnsHorairePiece() {
		Iterator<SeanceTheatre> itr = p.iterator();
		String s="";
		while(itr.hasNext()) {
			SeanceTheatre seance = itr.next();
			s+="Jour :"+seance.getJour()+"\nHoraire :"+seance.getHoraire() + "\n";
		}
		return s;
	}


}