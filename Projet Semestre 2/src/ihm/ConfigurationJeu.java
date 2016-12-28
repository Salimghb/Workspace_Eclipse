package ihm;

public class ConfigurationJeu {

	private int caisse;
	private String[][] cartes = new String[2][2];

	private int miseCourante;
	private int relance;
	private boolean parolePossible;
	private boolean suivrePossible;
	private int miseJoueur;

	// tableau
	private int nbCartesTableau;
	private String[][] tableau = new String[5][2];

	private int nbjoueurs;
	private int[] etatJoueurs;
	private int[] miseJoueurs;
	private int rangJoueur;

	private int mesChances;

	public ConfigurationJeu(int caisse, String[][] cartes, int miseCourante,
			int relanceMini, boolean parolePossible, boolean suivrePossible,
			int miseJoueur, int nbCartesTableau, String[][] tableau,
			int nbjoueurs, int[] etatJoueurs, int[] miseJoueurs,
			int mesChances, int rangJoueur) {
		super();
		this.caisse = caisse;
		this.cartes = cartes;
		this.miseCourante = miseCourante;
		this.relance = relanceMini;
		this.parolePossible = parolePossible;
		this.suivrePossible = suivrePossible;
		this.miseJoueur = miseJoueur;
		this.nbCartesTableau = nbCartesTableau;
		this.tableau = tableau;
		this.nbjoueurs = nbjoueurs;
		this.etatJoueurs = etatJoueurs;
		this.miseJoueurs = miseJoueurs;
		this.mesChances = mesChances;
	}

	/**
	 * 
	 * @return L'état actuel de la caisse du joueur (mise comprise)
	 */
	public int getCaisse() {
		return caisse;
	}

	/**
	 * 
	 * @return les cartes du joueur
	 */
	public String[][] getCartes() {
		return cartes;
	}

	/**
	 * 
	 * @return le montant courant de la mise
	 */
	public int getMiseCourante() {
		return miseCourante;
	}

	/**
	 * 
	 * @return le montant de la relance attendue
	 */
	public int getRelance() {
		return relance;
	}

	/**
	 * 
	 * @return L'option "parole" est-elle offerte ?
	 */
	public boolean isParolePossible() {
		return parolePossible;
	}

	/**
	 * 
	 * @return l'option "suivre" est elle offerte
	 */
	public boolean isSuivrePossible() {
		return suivrePossible;
	}

	/**
	 * 
	 * @return mon niveau actuel de mise
	 */
	public int getMiseJoueur() {
		return miseJoueur;
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

	/**
	 * 
	 * @return L'état de chaque joueur. Les états possibles sont :
	 * 
	 *         JOUE (0) : n'a encore rien fait dans ce coup
	 * 
	 *         MISE (1) : est en train choisir son action
	 * 
	 *         PAROLE (2) : a fait praole (ou check)
	 * 
	 *         SUIT (3) : suit la mise actuelle
	 * 
	 *         RELANCE (4) : a relancé
	 * 
	 *         COUCHE (5) : s'est couché pour ce coup
	 * 
	 *         PERDU (6) : a perdu (caisse vide) et ne joue plus
	 * 
	 */
	public int[] getEtatJoueurs() {
		return etatJoueurs;
	}

	/**
	 * 
	 * @return La mise de chaque joueur (attention aux joueurs qui ont déjà
	 *         perdus)
	 */
	public int[] getMiseJoueurs() {
		return miseJoueurs;
	}

	/**
	 * 
	 * @return Mes chances calculees par le calculateur de chances de gagner
	 */
	public int getMesChances() {
		return mesChances;
	}

}
