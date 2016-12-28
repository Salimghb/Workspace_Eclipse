package tp7.exo2;

import java.util.*;

public class Annuaire {

	Map<Personne,ListeNumTel> hm;

	public Annuaire(){
		hm=new HashMap<Personne,ListeNumTel>() ;
	}
	boolean ajouterEntree(Personne p, ListeNumTel nums){
		if(hm.containsKey(p)){
			return false;
		}
		hm.put (p,nums);
		return true;
	}

	ListeNumTel numeros(Personne p){
		return hm.get(p);
	}

	java.util.Iterator <Personne> personnes(){
		Set<Personne> set=hm.keySet();
		return set.iterator();
	}

	void ajouterNumeroFin(Personne p, NumTel n){
		ListeNumTel l=numeros(p);
		l.ajouterFin(n);
	}

	public NumTel premierNumero (Personne p){
		return hm.get(p).premierNumero();
	}

	public void supprimer (Personne p){
		hm.remove(p);
	}

	public void supprimerNumero (int n, Personne p){
		NumTel num=new NumTel(n);
		if(hm.get(p).nbNumeros()<2){
			supprimer(p);
		}
		hm.get(p).supprimer(num);
	}

	public Set<Personne> lesEntreesPour (String nom){
		Set<Personne> LesPersonnes=new HashSet<Personne>();
		Iterator <Personne> itr=personnes();
		while(itr.hasNext()) {
			Personne p = itr.next();
			if(p.getNom_().equalsIgnoreCase(nom)){
				LesPersonnes.add(p);
			}
		}
		return LesPersonnes;
	}

	public String toString (){
		String s=" ";
		Set<Map.Entry<Personne,ListeNumTel>> LesEntrees = hm.entrySet();
		Iterator <Map.Entry<Personne,ListeNumTel>> itr=LesEntrees.iterator();
		while (itr.hasNext()){
			Map.Entry<Personne,ListeNumTel>uneEntree = itr.next();
			Personne p=uneEntree.getKey();
			ListeNumTel l = uneEntree.getValue();
			s += p + " " + l + "\n";
		}
		return s;
	}
}
