/**
 * 
 */
package tp5;

/**
 * @author utilisateur
 *
 */
public class Facto1 {

	public static long factorielle (int n) throws IllegalArgumentException{ 
		if (n<0)
			throw new IllegalArgumentException("n<0");
		if (n>20)
			throw new IllegalArgumentException("n>20");
		if (n==0) return 1 ; else return ( n*factorielle(n-1) ) ; 
	}
}
