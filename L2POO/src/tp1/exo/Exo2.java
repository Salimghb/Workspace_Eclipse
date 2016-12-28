package tp1.exo;

public class Exo2 {
	
	public static void main (String []args){
		double somme=0;
		for (String arg : args){
			somme+= Double.parseDouble(arg);
		}
		System.out.println("Somme des arguments : " + somme);
	}
}
