package tp3.exo2;

import java.util.Scanner;

public class TestEntreprise {
	public static Employe[] lireDonnees (Scanner entree){
		String dateEmbauche=" ";
		String nom=" ";
		String manager="n";
		String dateFonction="";
		System.out.println("Entrez le nombre d'employés:");
		int n=entree.nextInt();
		Employe []lesEmp=new Employe [n];
		for (int i=0;i<n;i++){
			System.out.println("Entrez le nom de l'employé :");
			nom=entree.next();
			System.out.println("Entrez la date d'embauche de l'employé :");
			dateEmbauche = entree.next();
			System.out.println("Est-ce un manager o/n?");
			manager = entree.next();
			if( manager.equals("o")){
				System.out.println("Entrez la date d'entrée en fonction du manager :");
				dateFonction=entree.next();
				lesEmp[i]=new Manager(nom,dateEmbauche,dateFonction);
			}
			else{
				lesEmp[i]=new Employe (nom, dateEmbauche);
			}
		}
		return lesEmp;
	}
	public static void main(String []args){
			Scanner entree=new Scanner(System.in);
			Employe[] lesEmployes=lireDonnees(entree);
			for (int i = 0;i<lesEmployes.length;i++){
				System.out.println(lesEmployes[i]);
			}
			System.out.println("Saisir une augmentation :");
			if (entree.hasNextInt()){
				int augmentation=entree.nextInt();
				Employe.setAugmentation(augmentation);
			}
			else{
				System.out.println("L'augmentation pour les employes sera "+Employe.getAugmentation());
				entree.next();
			}
			System.out.println("Saisir une augmentation pour les managers :");
			if (entree.hasNextInt()){
				int augmentationManager=entree.nextInt();
				Employe.setAugmentation(augmentationManager);
			}
			else{
				System.out.println("L'augmentation pour les managers sera "+Manager.getAugmentationManager());
				entree.next();
			}
			System.out.println("-----------------------");
			System.out.println("Augmentation de salaire");
			System.out.println("-----------------------");
			for (int i=0;i<lesEmployes.length;i++){
				lesEmployes[i].augSalaire("2015/9/15");
			}
			for(int i=0;i<lesEmployes.length;i++){
				System.out.println(lesEmployes[i]);
			}
			entree.close();
	}
	
}
