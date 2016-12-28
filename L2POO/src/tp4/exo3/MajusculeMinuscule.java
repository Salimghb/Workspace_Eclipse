package tp4.exo3;
import java.util.*;

import td4.exo4.*;

public class MajusculeMinuscule {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		String[] lesMots = {"Bonjour", "HIER","Aujourd'hui"};
		EnsTransformable ens= new EnsTransformable(lesMots);
		System.out.println("Tapez a pour transformer en MAJUSCULE"
						 + " ou i pour transformer en minuscule");
		String choix = sc.next();
		sc.close();
		if (choix.equals("a")){
			ens.transformer(new Transformation(){
								public Object transforme(Object o) {
										return((String) o).toUpperCase();

								}
							});
		}else if(choix.equals("i")){
			ens.transformer(new Transformation(){
								public Object transforme(Object o){
									return((String)o).toLowerCase();
								}
							});
		}else{
			System.out.println("Choix invalide, aucun changement effectué");
		}
		System.out.println(ens);
	}
}
