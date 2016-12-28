/**
 * 
 */
package tp5;

import java.util.Scanner;

/**
 * @author kahlem
 *
 */
public class TestFacto2 {

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		boolean continuer = true;
		Scanner sc = new Scanner(System.in);
		while (continuer){
			System.out.println("Veuillez saisir un entier positif inférieur à 20 ou q pour quitter");
			if (sc.hasNextInt()){
				int n = sc.nextInt();
				try {
					System.out.println("la factorielle de " + n + " est: " +Facto2.factorielle(n));
				} catch (EntierNegatifException e) {
					System.out.println(e.getMessage());
				}
				catch(TropGrandException e1){
					System.out.println(e1.getMessage());
				}
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
