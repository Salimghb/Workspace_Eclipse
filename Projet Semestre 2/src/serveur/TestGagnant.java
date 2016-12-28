package serveur;

public interface TestGagnant {
	/**
	 * Renvoie le rang du gagnant
	 * 
	 * @param tableau
	 *            le tableau
	 * @param nbCartesTableau
	 *            nombre cartes connues dans le tableau
	 * @param joueurs
	 *            les jeux des joueurs
	 * @param rangs
	 *            indique la correspondance entre les rangs "absolus" des
	 *            joueurs et leur rang dans le tableau "joueur" (les joueurs sui
	 *            ont perdus ne sont pas présents dans "joueurs", d'où cette
	 *            astuce de recalage)
	 * @return
	 */
	public int[] rangGagnant(String[][] tableau, int nbCartesTableau,
			String[][][] joueurs, int[] rangs);

}
