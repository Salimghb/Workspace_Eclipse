package squelettes;

import serveur.TestGagnant;

public class LeTestGagnant implements TestGagnant {

	@Override
	public int[] rangGagnant(String[][] tableau, int nbCartesTableau, String[][][] joueurs, int[] rangs) {
		// implantation par défaut : indique toujours le joueur n° 0 comme gagnant...
		return new int[] { 0 };
	}

}
