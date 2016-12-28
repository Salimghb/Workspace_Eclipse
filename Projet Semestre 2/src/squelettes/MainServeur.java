package squelettes;

import serveur.Serveur;

/**
 * Un exemple de classe pour démarrer le serveur
 * 
 */
public class MainServeur {
	public static void main(String[] args) {
		// instanciation du serveur
		Serveur s = new Serveur();
		// réglage du nombre de joueurs (passé en paramètre, par défaut 2)
		int nbj = 2;
		/*
		if (args.length > 0) {
			try {
				nbj = Integer.parseInt(args[0]);
			} catch (NumberFormatException nfe) {

			}
		}
		*/
		s.setNbJoueurs(nbj);
		// réglage du port d'écoute (par défaut : 9000)
		// s.setPort(9010);
		// Réglage de la caisse
		s.setCaisse(100);
		// Réglage de la petite blinde (grosse blinde=2*petite)
		s.setBlinde(10);
		// instanciation de la classe Croupier, et mise en lien avec le serveur
		s.setCroupier(new LeCroupier());
		// instanciation du calcul du test de gagnant
		s.setTestGagnant(new LeTestGagnant());
		// démarrage de la partie (le serveur se met à l'écoute de joueurs)
		s.demarreServeur();
	}
}
