package tp4.exo1;
import java.util.*;

public class TestEnsEntiers  {
	public static void main (String []args){
		Scanner sc=new Scanner (System.in);
		int i=1;
		String choix="";
		EnsElementsOrdonnes ListeEntiers=new EnsElementsOrdonnes(55,1);
		while (i!=0){
			i++;
			System.out.println("Faites votre choix "
					+ ": i (inserer un element)"
					+ ", s (supprimer un element)"
					+ ", q (quitter)"); 
			choix=sc.next();
			if (choix.equals("i")){
				System.out.println("Saisir un entier");
				if(sc.hasNextInt()){
					int k = sc.nextInt();
					ListeEntiers.inserer(new EntierOrdonnable (k));
				}
				else {
					System.out.println("Ce n'est pas un entier à insérer");
					sc.next();
				}
			}
			else if (choix.equals("s")){
				System.out.println("Saisir un entier à supprimer");
				if(sc.hasNextInt()){
					int e = sc.nextInt();
					ListeEntiers.inserer(new EntierOrdonnable (e));
				}
				else {
					System.out.println("Ce n'est pas un entier");
					sc.next();
				}
			}
			if (choix.equals("q")){
				System.out.println(ListeEntiers);
				break;
			}
		}
		sc.close();
	}
}

