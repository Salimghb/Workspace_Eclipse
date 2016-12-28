package tp4.exo2;
import java.util.*;

class Nuplet implements Comparable<Nuplet>{

	private int[]content;

	public Nuplet(int k){
		Scanner sc=new Scanner(System.in);
		content = new int[k];
		for (int i =0;i<k;i++){
			System.out.println("Saisir un entier : ");
			content[i]=sc.nextInt();
		}
		sc.close();
	}
	public int nbElements(){
		return content.length;
	}
	public int getElement(int index){
		if ((index>=0) && (index<content.length)){
			return content[index];
		}
		else
			return -1;
	}
	public String toString() {
		String s="(";
		for (int i=0 ; i<content.length-1 ; i++){
			s=s+content[i]+";";
		}
		return s+content[content.length-1]+")";
	}
	public int compareTo(Nuplet comp) {
		return 0;
	}
}
