package ihm;

public interface CalculChances {
	/**
	 * Calcule mes chances de gagner (en %). Le tableau et mon jeux sont des
	 * tableaux de paires de chaines de caractères (rang/couleur), utilisant les
	 * valeurs définies dans Croupier.
	 * 
	 * @param tableau
	 *            Le tableau (rempli à partir du rang 0)
	 * @param nbCartesTableau
	 *            Le nombre de cartes connues dans le tableau
	 * @param monJeu
	 *            Mes deux cartes
	 * @param nbJoueurs
	 *            Le nombre de Joueurs
	 * @return
	 */
	public int mesChances(String[][] tableau, int nbCartesTableau, String[][] monJeu, int nbJoueurs);
}
