/**
 * 
 */
package tp5;

import java.util.Scanner;

/**
 * @author utilisateur
 *
 */
public class TestFact1 {
		@SuppressWarnings("resource")
		public static void main(String[] args){
			boolean continuer = true;
			Scanner sc = new Scanner(System.in);
			while (continuer){
				System.out.println("Veuillez saisir un entier positif inférieur à 20 ou q pour quitter");
				if (sc.hasNextInt()){
					int n = sc.nextInt();
					if (n>=0 && n<=20)
					System.out.println("la factorielle de " + n + " est: " +Facto1.factorielle(n));
					else System.out.println("Factorielle impossible à calculer pour "+n);
				}
				else {
					if (sc.hasNext()){
	        			String s= sc.next();
	        			if (s.equals("q")){
	        				 System.out.println("fin");
	        				 continuer =false;
	        			}
	        			else 
	        				System.out.println("ceci n'est pas un entier");
	        		}
				}
					
			}
				
			System.exit(0);

		}

	

}
