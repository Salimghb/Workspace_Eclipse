package pipopipette;

import java.util.Scanner;

public class Affichage {

	public static void afficherGrilleSansBords(long grilleLong,
			int nbCasesLargeur, int nbCasesLongueur) {
		String pairImpair = "";
		int compteur = 0; // renommer compteur
		long positionBit = 1;

		pairImpair = "impair";
		while (compteur != nbCasesLongueur * 2 + 1) { // nb de ligne sans
			// compter les bords

			if (pairImpair == "pair") {

				System.out.print(""); // debut ligne pair
				for (int i = 0; i <= nbCasesLargeur; i++) {

					if (((grilleLong & positionBit) == positionBit)
							&& (i != nbCasesLargeur))
						System.out.print("| ");

					else {
						if (((grilleLong & positionBit) == positionBit)
								&& (i == nbCasesLargeur))
							System.out.print("|");

						else {
							if (i == nbCasesLargeur)
								System.out.print(" ");
							else
								System.out.print("  ");
						}
					}
					positionBit = positionBit * 2;
				}
				System.out.println("");
			}

			else { // debut ligne impair
				for (int i = 0; i < nbCasesLargeur; i++) {

					if ((grilleLong & positionBit) == positionBit)
						System.out.print(".-");

					else
						System.out.print(". ");

					positionBit = positionBit * 2;
				}
				System.out.println(".");
			}

			if (pairImpair == "pair")
				pairImpair = "impair";

			else
				pairImpair = "pair";

			compteur++;
		}

	}

	public static void afficherGrilleAvecBords(long grilleLong,
			int nbCasesLargeur, int nbCasesLongueur) {

		String pairImpair = "";
		int compteur = 0; // le compteur commence a 2 pour pouvoir correctement
		// afficher les coordonne a droite de la grille
		long positionBit = 1;

		for (int i = 0; i < nbCasesLargeur; i++) {
			System.out.print(".-");
		}
		System.out.println(".");

		pairImpair = "pair";
		while (compteur != nbCasesLongueur * 2 - 1) { // nb de ligne sans
			// compter les bords

			if (pairImpair == "pair") {
				System.out.print("| "); // debut ligne pair
				for (int i = 0; i < nbCasesLargeur - 1; i++) {

					if ((grilleLong & positionBit) == positionBit)
						System.out.print("| ");

					else
						System.out.print("  ");

					positionBit = positionBit * 2;
				}
				System.out.println("|");
			}

			else { // debut ligne impair
				System.out.print(".");
				for (int i = 0; i < nbCasesLargeur; i++) {

					if ((grilleLong & positionBit) == positionBit)
						System.out.print("-.");

					else
						System.out.print(" .");

					positionBit = positionBit * 2;
				}
				System.out.println();
			}

			if (pairImpair == "pair")
				pairImpair = "impair";

			else
				pairImpair = "pair";

			compteur++;
		}
		for (int i = 0; i < nbCasesLargeur; i++) {
			System.out.print(".-");

		}

		System.out.println(".");

	}
	
	public static int askIntegerToPlayer() throws NumberFormatException {
		Scanner in = new Scanner (System.in);
		try {
			return Integer.parseInt(in.next());
		} catch (NumberFormatException e) {
			System.out.println("Erreur!");
			System.out.println("Vous n'avez pas saisi un entier !");
			return askIntegerToPlayer();

		}finally{
			in.close();
		}
	}

}
