/**
 * 
 */
package tp5.exo3;

import java.util.Scanner;

/**
 * @author kahlem
 *
 */
public class GestionNotes {

	/**
	 * @param args
	 */
	
	@SuppressWarnings("resource")
	private static EnsembleNotes saisirNote()
	{	EnsembleNotes lesNotes = new EnsembleNotes();
		Scanner sc = new Scanner(System.in);
		String nom = "";
		String matiere = "";
		int note = 0;
		
		boolean continuer = true;
		
		System.out.println("Veuillez saisir la matière : ");
		matiere = sc.next();
		while (continuer){
			System.out.println("Veuillez saisir un nom : ");
			nom = sc.next();
			if ( nom.equals(("q"))){
				continuer = false;
			}
			else {
				int nbNotes = 0;
				while (nbNotes <3){
					System.out.println("Veuillez saisir une note : ");
					if ( sc.hasNextInt()){
						note = sc.nextInt();
						if (note>=0 && note <=20){
							Note laNote = new Note (nom, matiere, note);
							lesNotes.ajouterNote(laNote);
							nbNotes++;
						}
						else System.out.println("la note doit être comprise entre 0 et 20");		
					}
					else {
						sc.next();
						System.out.println("ceci n'est pas un entier");
					}
				}
			}
		}
		return lesNotes;
	}

	public static void main(String[] args) {
		EnsembleNotes ens = saisirNote();
		System.out.println(ens);

	}

}
