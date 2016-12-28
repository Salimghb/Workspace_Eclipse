package projet;

import java.util.*;
import java.util.Map.Entry;

public class ProgrammationSemaine {


	private int semaine;

	//On crée une Map Key-Values, avec pour clés Film/Theatre et pour valeur l'ensemble de programmation
	Map<PieceTheatre,ProgrammationTheatre> mt;
	Map<Film,ProgrammationFilm> mf;

	//Initialisation
	public ProgrammationSemaine(int semaine){
		this.semaine=semaine;
		mt=new HashMap <PieceTheatre,ProgrammationTheatre> ();
		mf=new HashMap <Film,ProgrammationFilm> ();
	}

	//Films
	public void AjoutFilm(Film f,ProgrammationFilm prog){
		if(!mf.containsKey(f)){
			mf.put(f, prog);
		}
		else
			System.out.println("Ce film existe deja");
	}

	public void AjoutSeance(Film f,SeanceCinema s){
		ProgrammationFilm l=ListeSeanceFilms(f);
		l.ajouterSeance(s);
	}
	public void SupprimerSeanceFilm(Film f,SeanceCinema s){
		ListeSeanceFilms(f).supprimerSeance(s);
	}

	ProgrammationFilm ListeSeanceFilms(Film f){
		return  mf.get(f);
	}

	Iterator <Film> IteratorFilms(){
		Set<Film> set=mf.keySet();
		return set.iterator();
	}

	public Set<Film> EnsembleFilms(){
		Set<Film> EnsFilms=new HashSet<Film>();
		Iterator <Film> itr=IteratorFilms();
		while(itr.hasNext()) {
			Film f = itr.next();
			EnsFilms.add(f);
		}
		return EnsFilms;
	}
	//Rechercher un film selon la date
	public Set <Film> FilmJourDonné(int j,Film f){
		Set<Film> EnsFilmsJour=new HashSet<Film>();
		Iterator <Film> itr=IteratorFilms();
		while(itr.hasNext()) {
			Film f2 = itr.next();
			if(f.equals(f2)){
				Iterator<SeanceCinema> itr2 = new ProgrammationFilm().iterator();
				while(itr2.hasNext()) {
					SeanceCinema s = itr2.next();
					if(s.getJour()==j){
						EnsFilmsJour.add(f);
					}
				}
				return EnsFilmsJour;
			}
		}
		System.out.println("Aucun n'est disponible pour le jour "+j);
		return null;
	}

	//Rechercher un film selon l'heure et la date
	public SeanceCinema FilmJourHoraireDonné(int j,Heure h,Film f){
		Iterator <Film> itr=IteratorFilms();
		while(itr.hasNext()) {
			Film f2 = itr.next();
			if(f.equals(f2)){
				Iterator<SeanceCinema> itr2 = new ProgrammationFilm().iterator();
				while(itr2.hasNext()) {
					SeanceCinema s = itr2.next();
					if(s.getJour()==j){
						if(s.getHoraire()==h)
							return s;
						else
							System.out.println("Aucun film prévu pour cet horaire");
					}
				}
			}
		}
		System.out.println("Le film recherché n'est pas disponible");
		return null;
	}

	//Retourne en pourcentage le taux de remplissage pour un film passé en paramètre
	public double TauxRemplissageFilm(Film f){
		int i=0;
		int k=0;
		ProgrammationFilm prog;
		prog=ListeSeanceFilms(f);
		Iterator<SeanceCinema> itr= prog.iterator();
		while(itr.hasNext()){
			SeanceCinema s = itr.next();
			i+=s.tauxRemplissage();
			k++;
		}
		return i/k;
	}

	//Renvoie l'ensemble des titres des films dans la Programmation
	public String toStringEnsTitreFilm(){
		String s="";
		Set<Film> LesFilms = mf.keySet();
		Iterator<Film> itrfilm=LesFilms.iterator();
		while (itrfilm.hasNext()){
			Film unfilm = itrfilm.next();
			s += unfilm.getTitre() + "\n";
		}
		return s;
	}

	//Rechercher un film selon son titre
	public Film ChercherFilm (String nom){
		Iterator <Film> itr=IteratorFilms();
		while(itr.hasNext()) {
			Film f = itr.next();
			if(f.getTitre().equalsIgnoreCase(nom)){
				return f;
			}
		}
		return null;
	}

	//Chiffre d'affaire du film passé en paramètre
	public double ChiffredAffaireFilm(Film f){
		ProgrammationFilm prog=ListeSeanceFilms(f);
		return prog.chiffreAffaire();
	}

	//Theatre

	public void AjoutPiece(PieceTheatre f,ProgrammationTheatre prog){
		mt.put(f, prog);
	}

	public void AjoutSeance(PieceTheatre f,SeanceTheatre s){
		ProgrammationTheatre l=ListeSeancePieces(f);
		l.ajouterSeance(s);
	}
	public void SupprimerSeance(PieceTheatre f,SeanceTheatre s){
		ListeSeancePieces(f).supprimerSeance(s);
	}

	ProgrammationTheatre ListeSeancePieces(PieceTheatre f){
		return  mt.get(f);
	}

	Iterator<PieceTheatre> IteratorPieces(){
		Set<PieceTheatre> set=mt.keySet();
		return set.iterator();
	}

	public Set<PieceTheatre> EnsemblePieces(){
		Set<PieceTheatre> EnsPieces=new HashSet<PieceTheatre>();
		Iterator <PieceTheatre> itr=IteratorPieces();
		while(itr.hasNext()) {
			PieceTheatre f = itr.next();
			EnsPieces.add(f);
		}
		return EnsPieces;
	}

	//Rechercher une seance de theatre selon la date
	public SeanceTheatre PieceJourDonné(int j,PieceTheatre pt) {
		Iterator <PieceTheatre> itr=IteratorPieces();
		while(itr.hasNext()) {
			PieceTheatre f2 = itr.next();
			if(pt.equals(f2)){
				Iterator<SeanceTheatre> itr2 = new ProgrammationTheatre().iterator();
				while(itr2.hasNext()) {
					SeanceTheatre s = itr2.next();
					if(s.getJour()==j){
						return s;
					}
				}
			}
		}
		System.out.println("Aucune piece de theatre n'est prévue ce jour");
		return null;
	}

	//Retourne en pourcentage le taux de remplissage pour une piece de theatre passée en paramètre
	public double TauxRemplissagePiece(PieceTheatre pt){
		int i=0;
		int k=0;
		ProgrammationTheatre prog;
		prog=ListeSeancePieces(pt);
		Iterator<SeanceTheatre> itr= prog.iterator();
		while(itr.hasNext()){
			SeanceTheatre s = itr.next();
			i+=s.tauxRemplissage();
			k++;
		}
		return i/k;
	}

	//Renvoie l'ensemble des titres des pieces dans la Programmation
	public String toStringEnsTitrePiece(){
		String s="";
		Set<PieceTheatre> LesPieces = mt.keySet();
		Iterator<PieceTheatre> itrth=LesPieces.iterator();
		while (itrth.hasNext()){
			PieceTheatre unepiece = itrth.next();
			s += unepiece.getTitre() + "\n";
		}
		return s;
	}

	//Rechercher une piece de theatre selon son titre
	public PieceTheatre ChercherPieceTheatre(String nom){
		Iterator <PieceTheatre> itr=IteratorPieces();
		while(itr.hasNext()) {
			PieceTheatre f = itr.next();
			if(f.getTitre().equalsIgnoreCase(nom)){
				return f;
			}
		}
		System.out.println("La piece de theatre recherchée n'est pas disponible");
		return null;
	}

	//Chiffre d'affaire de la piece de theatre passée en paramètre
	public double ChiffredAffairePiece(PieceTheatre pt){
		ProgrammationTheatre prog=ListeSeancePieces(pt);
		return prog.chiffreAffaire();
	}

//Affiche l'ensemble des spectacles de la Programmation
	public String toString(){
		String s=" ";
		Set<Map.Entry<PieceTheatre,ProgrammationTheatre>> LesProgTheatre = mt.entrySet();
		Set<Entry<Film, ProgrammationFilm>> LesProgFilm = mf.entrySet();
		Iterator<Entry<PieceTheatre, ProgrammationTheatre>> itrtheatre=LesProgTheatre.iterator();
		Iterator<Entry<Film, ProgrammationFilm>> itrfilm=LesProgFilm.iterator();
		while (itrtheatre.hasNext()){
			Entry<PieceTheatre, ProgrammationTheatre>uneProgtheatre = itrtheatre.next();
			PieceTheatre p=uneProgtheatre.getKey();
			ProgrammationTheatre pt = uneProgtheatre.getValue();
			s += p + " " + pt + "\n";
		}
		while (itrfilm.hasNext()){
			Entry<Film, ProgrammationFilm>uneProgfilm = itrfilm.next();
			Film f=uneProgfilm.getKey();
			ProgrammationFilm pf = uneProgfilm.getValue();
			s += f + " " + pf + "\n";
		}
		return s;
	}



//hashCode() & equals()
	public int hashCode() {
		final int prime = 31;
		int res = 1;
		res = prime * res + ((mf == null) ? 0 : mf.hashCode());
		res = prime * res + ((mt == null) ? 0 : mt.hashCode());
		return res;
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		ProgrammationSemaine other = (ProgrammationSemaine) obj;
		if (mf == null) {
			if (other.mf != null)
				return false;
		} else if (!mf.equals(other.mf))
			return false;
		if (mt == null) {
			if (other.mt != null)
				return false;
		} else if (!mt.equals(other.mt))
			return false;
		return true;
	}
	
	//Getters & Setters de la semaine
	public int getSemaine() {
		return semaine;
	}

	public void setSemaine(int semaine) {
		this.semaine = semaine;
	}
}