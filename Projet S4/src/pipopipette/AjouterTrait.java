package pipopipette;

public class AjouterTrait {

	/**
	 * 
	 * teste si un trait existe sur une position si oui alors on ne valide pas le coup sinon on
	 * ajoute le trait
	 * 
	 * @param grilleLong
	 * @param choix
	 * @return
	 */
	public static long modifGrilleLong(long grilleLong, int choix) {
		long testPositionBit = 0;
		testPositionBit = testPositionBit + (long) Math.pow(2, choix - 1);
		if ((grilleLong & testPositionBit) == testPositionBit) {
			System.out.println("Vous avez déjà joué a cette position");
			return grilleLong;
		} else {
			grilleLong = grilleLong + (long) Math.pow(2, choix - 1);
			return grilleLong;
		}

	}
}
