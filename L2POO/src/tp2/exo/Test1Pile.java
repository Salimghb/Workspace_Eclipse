package tp2.exo;

public class Test1Pile {
	static Pile test=new Pile();

	public static void main (String [] args){
		for (int i=0; i<5;i++){
			int j = (int)(Math.random() * (100-1)) + 1;
			String c=Integer.toString(j);
			test.empiler(c);
		}
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
