package tp4.exo2;
import java.util.*;

public class ListeNuplet{

	private Nuplet[]lesNuplets;

	public ListeNuplet(int k,int taille){
		lesNuplets=new Nuplet[taille];
		for (int i=0;i<lesNuplets.length;i++){
			lesNuplets[i]=new Nuplet(k);
		}
	}
	public String toString() {
		return "Liste Nuplet:[" + super.toString() + "]";
	}
	public Nuplet getNuplet (int index){
		if ((index>=0) && (index<lesNuplets.length)){
			return lesNuplets[index];
		}
		else
			return null;
	}
	public void trier(){
		Arrays.sort(lesNuplets);
	}
}

