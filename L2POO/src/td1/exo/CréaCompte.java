package td1.exo;

public class CréaCompte {


	public static void main (String []args){
		CompteBancaire [] agence=new CompteBancaire[100];
		int nbComptes=0;
		double plafond = 15000;
		double tauxAgios = 0;
		double tauxInteret = 2;
		CompteCourant c= new CompteCourant("Robert", "8 rue exemple", tauxAgios);
		CompteEpargne e= new CompteEpargne("Nom","14 rue Adresse", tauxInteret,plafond );
		agence[0] = c; nbComptes++;
		agence[1] = e; nbComptes++;
		for (int i =0;i<nbComptes; i++)
			agence[i].traitementQuotidien();
	}
}
