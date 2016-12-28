package pipopipette;

public class CoupsJouables {

	public static int nombreDeCoupJouableAvecBords(int nbCasesLargeur,
			int nbCasesLongueur) {
		return nbCasesLongueur * (nbCasesLargeur - 1) + nbCasesLargeur
				* (nbCasesLargeur - 1);
	}

	public static int nombreDeCoupJouableSansBords(int nbCasesLargeur,
			int nbCasesLongueur) {
		return nbCasesLongueur * (nbCasesLargeur - 1) + nbCasesLargeur
				* (nbCasesLargeur - 1) + 2 * (nbCasesLargeur + nbCasesLongueur);
	}
}
