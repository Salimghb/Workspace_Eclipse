public class Compte {


	/**
	 * Compte crée un nouveau compte avec tous ces paramètres
	 * @param String n qui est le nom
	 * @param String p qui est le prénom
	 * @param String num qui est le numéro de compte
	 * @param init qui est le solde initial
	 * @param dec qui est le découvert autorisé
	 * @return
	 */
	public Compte(){
		String n = null;
		String p = null;
		int num = 0;
		double init = 0;
		double dec = 0;
	}

	public Compte(String nom, String prenom, int numero,double solde, double decouvert){
		String n = nom;
		String p = prenom;
		int num = numero;
		double init = solde;
		double dec = decouvert;
	}

	/**
	 * Depot ajoute la somme prise en paramètre et l'ajoute au solde de départ
	 * @param double > 0
	 * @return double la somme + solde avant l'exécution
	 */
	public static double depot(double m){
		return m;
	}

	/**
	 * Prelever retire la somme prise en paramètre au solde de départ
	 * @param double > 0
	 * @return solde après le prelevement
	 */
	public static double prelever(double m){
		return m;
	}

	/**
	 * montantDecouvert renvoie la somme du Découvert que si le compte est a découvert
	 * @return double > 0
	 */
	public static double montantDecouvert(){
		return 0;
	}


}
