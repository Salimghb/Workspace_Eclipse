package tp2.exo;

public class Trafic {
	public static void main (String[] args){
		CompteurKilometrique compteur=new CompteurKilometrique();
		String imma ="daodzaz";
		Voiture voiture=new Voiture (imma,compteur);
		voiture.rouler(24236.4);
		System.out.println(voiture.getKmJournalier());
		System.out.println(voiture.getKmTotal());
		System.out.println(voiture.getKmTotal());
	}
}
