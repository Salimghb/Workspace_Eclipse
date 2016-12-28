public class Exercice1 {

	/**
	 * first() renvoie la premiere valeur d'un tableau
	 * 
	 * @param tableau non vide
	 * @return valeur de la premiere case du tableau (entier)
	 */
	public static int first (int[]tab){
		assert (!estVide(tab)):"Erreur : tableau vide";
		return tab[0];
	}

	/**
	 * estVide() vérifie si le tableau en parametre est vide
	 *
	 * @param tableau
	 * @return booleen
	 */
	public static boolean estVide(int[]tab){
		return tab == null;
	}

	/**
	 *
	 * @param valeur
	 * @param tab
	 * @return entier >= 0 si l'entier valeur est dans le tableau
	 * @return entier < 0 si l'entier valeur n'est pas dans le tableau
	 */
	public static int trouverDernierepos(int valeur,int[]tab){
		assert estTrie(tab) : "Erreur : tableau non trié";
		int pos = tab.length-1;
		while (tab[pos]!=valeur && pos >=0){
			pos --;
		}
		assert posValide(tab,pos,valeur) : "Erreur";
		return pos;
	}

	/**
	  * posValide vérifie si la position de la valeur est bien la dernière
	  * @param tableau
	  * @param entier pos
	  * @param entier val
	  * @return booleen
	  */
	public static boolean posValide(int[] tab, int pos, int valeur) {
		if (pos<0){
			return true;
		}
		if (tab[pos]!=valeur){
			return false;
		}
		else{
			if(pos==tab.length-1){
				return true;

			}
			else{	
				return (tab[pos]<tab[pos+1]);
			}
		}
	}
	/**
	 * estTrie verifie si le tableau en parametre est trié
	 * 
	 * @param tab
	 * @return booleen
	 */
	public static boolean estTrie(int []tab) {
		for (int i = 0 ; i<tab.length-1 ; i++){
			if (tab[i]>tab[i+1]){
				return false;
			}
		}
		return true;
	}
	
	public static void main (String[]args){
		int[] tab = {4 , 1 , 23 , 2 , 3 ,7, 8 ,2 , 10 , 11} ;
		System.out.println(first(tab));
		System.out.println(estTrie(tab));
		System.out.println(trouverDernierepos(2,tab));
		
		
	}
}
