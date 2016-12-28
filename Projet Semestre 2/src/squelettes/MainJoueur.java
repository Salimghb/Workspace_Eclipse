package squelettes;

import ihm.GestionnaireJoueur;

/**
 * Un exemple de classe pour démarrer le joueur (le joueur doit toujours être
 * démarré après le serveur)
 * 
 */
public class MainJoueur {

	public static void main(String[] args) {
		// instanciation du gestionnaire de joueur
		GestionnaireJoueur gestionnaire = new GestionnaireJoueur();

		// instanciation de votre calculateur de chances et mise en lien avec le gestionnaire
		gestionnaire.setCalculChances(new LeCalculChances());

		// instanciation de votre IA et mise en lien avec le gestionnaire (OPTIONNEL, SEULEMENT SI VOUS AVEZ UNE IA)
		// gestionnaire.setIA(new LIA());

		// connexion au serveur et démarrage de la partie
		gestionnaire.d�marrer();
	}

}
