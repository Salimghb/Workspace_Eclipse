public class Compte {


	/**
	 * Compte cr�e un nouveau compte avec tous ces param�tres
	 * @param String n qui est le nom
	 * @param String p qui est le pr�nom
	 * @param String num qui est le num�ro de compte
	 * @param init qui est le solde initial
	 * @param dec qui est le d�couvert autoris�
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
	 * Depot ajoute la somme prise en param�tre et l'ajoute au solde de d�part
	 * @param double > 0
	 * @return double la somme + solde avant l'ex�cution
	 */
	public static double depot(double m){
		return m;
	}

	/**
	 * Prelever retire la somme prise en param�tre au solde de d�part
	 * @param double > 0
	 * @return solde apr�s le prelevement
	 */
	public static double prelever(double m){
		return m;
	}

	/**
	 * montantDecouvert renvoie la somme du D�couvert que si le compte est a d�couvert
	 * @return double > 0
	 */
	public static double montantDecouvert(){
		return 0;
	}


}
