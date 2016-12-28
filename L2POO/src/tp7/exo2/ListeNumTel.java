package tp7.exo2;

import java.util.*;


public class ListeNumTel {

	private List <NumTel> p; 
	//On crée une liste sans specifié le type, 
	//puis on la spécifie après selon les besoins

	

	public boolean ajouter(int index, NumTel num){
		if(p.contains(num)){
			return false;
		}
		p.add(index,num);
		return true;
	}

	public boolean ajouterFin(NumTel num){
		boolean ajoute=false;
		if(!p.contains(num)){
			ajoute=p.add(num);
		}
		return ajoute;
	}

	public boolean contientNumero(int num){
		NumTel numrecherche=new NumTel(num);
		return p.contains(numrecherche);
	}

	public int nbNumeros(){
		return p.size();
	}

	public NumTel numero(int index){
		return p.get(index);
	}
	
	public Iterator<NumTel> iterator(){
		return p.iterator();
	}

	public NumTel premierNumero(){
		return  p.get(0);
	}
	
	public boolean retirer(int num){
		boolean retrait=false;
		if(p.contains(num) && nbNumeros()>=2){
			NumTel numaretirer = new NumTel(num);
			retrait=p.remove(numaretirer);
		}
		return retrait;
	}
	
	public void supprimer(NumTel n){
		p.remove(n);
	}
	
	public String toString(){
		return p.toString();
	}
}