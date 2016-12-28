package tp1.exo;
import java.util.Scanner;
public class SommeNpremiers {

	private static Scanner sc= new Scanner(System.in);
	public static void main(String[]args){
		int n = 0;
		System.out.println("Donnez un entier positif");
		n = sc.nextInt();
		System.out.println(" La somme est " + somme(n));
	}

	static int somme(int n){
		if (n == 0)
			return 0;
		else
			return (n+somme(n-1));
	}
}
