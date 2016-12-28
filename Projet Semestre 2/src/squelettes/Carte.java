package squelettes;

public class Carte {
	public static char[] toString;
	public static int num;
	public static int coul;
	//* 1=coeur
	//* 2=carreau
	//* 3=pique
	//*	4=trefle
	public Carte (int x, int y) {
		num=x;
		coul=y;
	}
	public static String[] couleurs = { "Coeur", "Carreau", "Pique", "Trefle" };
	public static String[] valeurs  = { "As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Valet", "Dame", "Roi" };

	public String toString() {
		String c="";
		String n="";
		if (coul==1){
			c="Coeur";
		}
		if (coul==2){
			c="Carreau";
		}
		if (coul==3){
			c="Pique";
		}
		if (coul==4){
			c="Trefle";
		}
		if (num==1){
			n="As";
		}
		if (num==11){
			n="Valet";
		}
		if (num==12){
			n="Dame";
		}
		if (num==13){
			n="Roi";
		}
		if ((num<11)  &&  (num>1)){
			return num + " de " + c;
		}
		return n + " de " + c;
	}
	public static char[] getToString() {
		return toString;
	}
	public int getNum() {
		return num;
	}
	public int getCoul() {
		return coul;
	}
	public String getValeur() {
		return valeurs[num];
	}
	public String getCouleur() {
		return couleurs[coul];
	}
}