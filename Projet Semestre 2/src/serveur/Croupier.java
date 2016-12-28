package serveur;

/**
 * Le croupier bat les cartes et procède à leur distribution.
 * 
 * Les cartes sont renvoyées sous la forme de paires de chaînes : valeur de la
 * carte + couleur de la carte.
 * 
 * Les valeurs sont : As, 2, 3, 4, 5, 6, 7, 8, 9, 10, Valet, Dame, Roi Les
 * couleurs sont : Coeur, Carreau, Pique, Trefle
 * 
 * Il faut utiliser les syntaxes ci-dessus (pas d'accents, majuscule en début de
 * mot).
 * 
 * 
 */
public interface Croupier {
	/////////// MELANGE DES CARTES /////////////
/**
 * Reforme le jeu complet en remettant dedans les cartes distribuées, les
 * cartes brûlées et le tableau
 */
public void ramasse();

	/**
	 * Bat les cartes (procède à un nombre aléatoire de coupes; le nombre de
	 * coupes est compris entre 5 et 30).
	 */

public void battage();
	/**
	 * Bat les cartes en procédant à exactement nbcoupes.
	 */

public void battage(int nbcoupes);
	/**
	 * Coupe le jeu : détermine aléatoirement un point de coupe dans le jeu,
	 * prend toutes les cartes situées après ce point et les place en début de
	 * jeu.
	 */

public void coupe();



public void brule();

	// ///////// DISTRIBUTION DES CARTES /////////////

	/**
	 * Renvoie le flop (3 premières cartes du tableau), constitué des trois
	 * premières cartes du jeu (celles du dessus), sous la forme d'un tableau de
	 * 6 chaines : Rang de la première carte + couleur de la première carte +
	 * rang de la deuxième carte etc.
	 * 
	 * @return le flop
	 */
public String[] flop();

	/**
	 * Renvoie le tournant (4ème carte du tableau) sous la forme d'un tableau de
	 * 2 chaines : Rang de la carte + couleur de la carte
	 * 
	 * @return le tournant
	 */
public String[] tournant();

	/**
	 * Renvoie la rivière (5ème carte du tableau) sous la forme d'un tableau de
	 * 2 chaines : Rang de la carte + couleur de la carte
	 * 
	 * @return la riviere
	 */
public String[] riviere();

	/**
	 * Renvoie la première carte du jeu (celle du dessus) sous la forme d'un
	 * tableau de 2 chaines : Rang de la carte + couleur de la carte
	 * 
	 * @return la première carte sur le paquet
	 */
public String[] carte();
}

