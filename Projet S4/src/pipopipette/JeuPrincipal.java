package pipopipette;

import java.util.Scanner;

public class JeuPrincipal {

	static Scanner in = new Scanner(System.in);

	public static void gaming() {

		long grilleLong = 0L;
		int nbCoupEnCours = 0;
		int nbDeCoupJouable = 0;
		int nbCasesLongueur = 0;
		int nbCasesLargeur = 0;
		char presenceBords = ' ';

		do {
			System.out
					.println("Voulez-vous jouer avec ou sans bords?\n(1) --> oui  /  (0) --> non");
			presenceBords = in.next().charAt(0);

			if (presenceBords != '1' && presenceBords != '0')
				System.out
						.println("Vos valeurs sont incorrectes! Veuillez saisir 1 ou 0 !");

		} while (presenceBords != '1' && presenceBords != '0');

		System.out
				.println("Veuillez entrer la largeur puis la longueur de votre grille");
		nbCasesLargeur = Affichage.askIntegerToPlayer();
		nbCasesLongueur = Affichage.askIntegerToPlayer();

		if (presenceBords == 1) {

			do {
				Affichage.afficherGrilleAvecBords(grilleLong, nbCasesLargeur,
						nbCasesLongueur);
				System.out.println("Où voulez vous jouer?");
				int choix = Affichage.askIntegerToPlayer();
				grilleLong = AjouterTrait.modifGrilleLong(grilleLong, choix);

				nbCoupEnCours++;

			} while (nbCoupEnCours != nbDeCoupJouable);
		}

		else {

			do {

				Affichage.afficherGrilleSansBords(grilleLong, nbCasesLargeur,
						nbCasesLongueur);
				System.out.println("Ou voulez vous jouer?");
				int choix = Affichage.askIntegerToPlayer();
				grilleLong = AjouterTrait.modifGrilleLong(grilleLong, choix);
				nbCoupEnCours++;

			} while (nbCoupEnCours != nbDeCoupJouable);
		}

	}
}
