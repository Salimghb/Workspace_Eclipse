package tp2.exo;

public class Test2Pile {
	static Pile test=new Pile();

	public static void main (String[]args){
		test.empiler("a");
		test.empiler("b");
		test.empiler("c");
		test.empiler("d");
		test.empiler("e");
		Maillon pointeur= test.getSommet();
		while (pointeur!=null){
			System.out.println(pointeur.getValeur());
			pointeur = pointeur.getSuivant();
		}
		test.depiler();
		test.depiler();
		Maillon pointeur2= test.getSommet();
		while (pointeur2!=null){
			System.out.println(pointeur2.getValeur());
			pointeur2 = pointeur2.getSuivant();
		}
	}
}
