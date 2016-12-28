package projet;
import java.util.*;
public class ProgrammationFilm {
	private List <SeanceCinema> p;
	//Initialisation de la liste
	public ProgrammationFilm(){
		p=new ArrayList<SeanceCinema>();
	}

	//Ajoute une seance
	void ajouterSeance(int index, SeanceCinema seance){
		p.add(index,seance);
	}
	void ajouterSeance(SeanceCinema seance){
		p.add(seance);
	}

	//Supprime une seance
	public void supprimerSeance(SeanceCinema seance){
		p.remove(seance);
	}

	//Cherche la seance correspondant à l'horaire/jour
	public SeanceCinema chercher (int jour, Heure horaire){
		Iterator<SeanceCinema> itr = p.iterator();
		while(itr.hasNext()) {
			SeanceCinema seance = itr.next();
			if(seance.getJour()==jour && seance.getHoraire()==horaire){
					return seance;
			}
		}
		System.out.println("Aucune seance ne correspond à ces horaires");
		return null;
	}

	//Calcule le taux de remplissage en pourcentage pour la séance
	public double tauxRemplissage(int jour,	Heure h){
		return chercher(jour,h).tauxRemplissage();
	}

	//Retourne le chiffre d'affaire du film en fonction du nombre total de places vendues pour toutes les seances(TN+TR)
	public double chiffreAffaire(){
		Iterator<SeanceCinema> itr = p.iterator();
		double i=0;
		while(itr.hasNext()) {
			SeanceCinema seance = itr.next();
			i += ((seance.getNbPlacesVenduesTN()+0.6*seance.getNbPlacesVenduesTR()) * seance.getSalle().getTarif());
		}
		return i;
	}

	//Iterator
	public Iterator<SeanceCinema> iterator() {
		Iterator<SeanceCinema> itr=p.iterator();
		return itr;
	}

	//Tri de la liste par jour/horaire
	//Classe interne
	public void tripardate (){
		Collections.sort(p, new Comparator<SeanceCinema>() {
			public int compare(SeanceCinema s1, SeanceCinema s2) {
				return s1.compareTo(s2);
			}
		});
	}
	public String toStringEnsHoraireFilm(){
		Iterator<SeanceCinema> itr = p.iterator();
		String s="";
		while(itr.hasNext()) {
			SeanceCinema seance = itr.next();
			s+="Jour :"+seance.getJour()+"\nHoraire :"+seance.getHoraire() + "\n";
		}
		return s;
	}
	//Redéfinition de la méthode toString pour la liste des seances
	public String toString(){
		Iterator<SeanceCinema> itr = p.iterator();
		String s="";
		while(itr.hasNext()) {
			SeanceCinema seance = itr.next();
			s+=seance.toString() + "\n"+ "\n";
		}
		return s;
	}

}