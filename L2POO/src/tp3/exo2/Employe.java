package tp3.exo2;

import java.util.*;

public class Employe {
	private String nom;
	private String dateEmbauche;
	protected double salaire;
	private static int augmentation=10;
	private String dateAugmentation;

	public Employe ( String nom, String dateEmbauche, double salaire ){
		this.nom=nom;
		this.dateEmbauche=dateEmbauche;
		this.salaire=salaire;
		this.dateAugmentation=dateEmbauche;
	}
	public Employe(String nom , String dateEmbauche){
		this(nom,dateEmbauche,1300);
	}
	public int nbmoisEcoules (String dateCourante,String dateDeb){
		Scanner sc=new Scanner (dateCourante);
		Scanner sd=new Scanner (dateCourante);
		Scanner c = sc.useDelimiter("/");
		Scanner d = sd.useDelimiter("/");
		int anneeDebut=d.nextInt();
		int anneeCourante=c.nextInt();
		int moisDebut=d.nextInt();
		int moisCourant=c.nextInt();
		int nbMois;
		if(moisCourant>moisDebut){
			nbMois=((anneeCourante - anneeDebut)*12)+(moisCourant - moisDebut);
		}else{
			nbMois=((anneeCourante - anneeDebut)*12)-(moisCourant - moisDebut);
		}
		sc.close();
		sd.close();
		c.close();
		d.close();	
		return nbMois;
	}
	public int evolution ( String dateCourante ){
		return nbmoisEcoules(dateCourante, dateCourante);
	}
	public void augSalaire (String dateCourante){
		this.salaire=this.salaire+(evolution(dateCourante)*getAugmentation());
		this.dateAugmentation=dateCourante;
	}
	public String toString() {
		return "Nom :" + nom + "\n Date d'embauche :" + 
	dateEmbauche + "\n Salaire actuel :" + salaire ;
	}

	public String getDateAugmentation() {
		return dateAugmentation;
	}
	
	public static void setAugmentation(int augmentation) {
		Employe.augmentation = augmentation;
	}
	public static int getAugmentation() {
		return augmentation;
	}
}










