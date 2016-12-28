package ihm;

public class ConfigurationFinCoup {
	private int nbCartesTableau;
	private String[][] tableau = new String[5][2];
	int nbjoueurs;
	String[] joueurs;
	int[] etatJoueurs;
	int[] miseJoueurs;
	private String[][][] cartesJoueurs;
	int rangJoueur;
	int[] rangsGagnantsCoup = new int[0];

	public ConfigurationFinCoup(int nbCartesTableau, String[][] tableau,
			int nbjoueurs, String[] joueurs, int[] etatJoueurs,
			int[] miseJoueurs, String[][][] cartesJoueurs, int rangJoueur,
			int[] rangsGagnantsCoup) {
		super();
		this.nbCartesTableau = nbCartesTableau;
		this.tableau = tableau;
		this.nbjoueurs = nbjoueurs;
		this.joueurs = joueurs;
		this.etatJoueurs = etatJoueurs;
		this.miseJoueurs = miseJoueurs;
		this.cartesJoueurs = cartesJoueurs;
		this.rangJoueur = rangJoueur;
		this.rangsGagnantsCoup = rangsGagnantsCoup;
	}

	/**
	 * 
	 * @return les noms des joueurs
	 */
	public String[] getJoueurs() {
		return joueurs;
	}

	/**
	 * 
	 * @return L'état courant des joueurs (voir ConfigurationJeu)
	 */

	public int[] getEtatJoueurs() {
		return etatJoueurs;
	}

	/**
	 * 
	 * @return La mise de chaque joueur
	 */
	public int[] getMiseJoueurs() {
		return miseJoueurs;
	}

	/**
	 * 
	 * @return Les cartes de chaque joueur (attention aux joueurs couchés ou
	 *         ayant perdus : cartes non significatives)
	 */
	public String[][][] getCartesJoueurs() {
		return cartesJoueurs;
	}

	/**
	 * 
	 * @return Les rangs du ou des gagnants (si ex aequo)
	 */
	public int[] getRangsGagnantsCoup() {
		return rangsGagnantsCoup;
	}

	/**
	 * 
	 * @return Le nombre de carte affichées au tableau
	 */
	public int getNbCartesTableau() {
		return nbCartesTableau;
	}

	/**
	 * 
	 * @return Le tableau
	 */
	public String[][] getTableau() {
		return tableau;
	}

	/**
	 * 
	 * @return Le nombre de joueurs (moi compris)
	 */
	public int getNbjoueurs() {
		return nbjoueurs;
	}

	/**
	 * 
	 * @return Mon rang parmi les joueurs du tableau
	 */
	public int getRangJoueur() {
		return rangJoueur;
	}

}
