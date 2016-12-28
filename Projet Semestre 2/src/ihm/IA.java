package ihm;

public interface IA {
	public static final int DECISION_PAROLE = 2;
	public static final int DECISION_SUIVRE = 3;
	public static final int DECISION_RELANCER = 4;
	public static final int DECISION_SE_COUCHER = 5;

	/**
	 * Retourne une des quatre valeurs proposées
	 * 
	 * @param cfj
	 * @return
	 */
	public int decider(ConfigurationJeu cfj);

	/**
	 * Informe l'IA de la fin du coup
	 */
	public void finCoup(ConfigurationFinCoup cfc);

}
