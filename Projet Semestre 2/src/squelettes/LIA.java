package squelettes;

import ihm.ConfigurationFinCoup;
import ihm.ConfigurationJeu;
import ihm.IA;

/**
 * Un squelette d'IA qui décide systématiquement de se coucher. A compléter...
 * 
 */
public class LIA implements IA {

	@Override
	public int decider(ConfigurationJeu cfj) {
		return DECISION_SE_COUCHER;
	}

	@Override
	public void finCoup(ConfigurationFinCoup cfc) {
	}

}
