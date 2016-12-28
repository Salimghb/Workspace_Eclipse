package td2.exo;

public class ListeEntiers {
	private int[] LesEntiers;
	public ListeEntiers (int[]LesEntiers){
		for (int i=0;i<LesEntiers.length;i++){
			this.LesEntiers[i]=LesEntiers[i];
		}
	}
	public void ListeEntrees (String[]LesEntrees){
		for ( int i=0;i<=LesEntrees.length;i++){
			this.LesEntiers[i]=Integer.parseInt (LesEntrees[i]);
		}
	}
	public int longueur(){
		return LesEntiers.length;
	}
	public int somme(){
		int somme=0;
		for (int i=0; i< longueur();i++){
			somme+=LesEntiers[i];
		}
		return somme;
	}
	public int IndiceMax(){
		int Indice=0;
		int max=LesEntiers[0];
		for (int i=0;i<longueur();i++){
			if(max<LesEntiers[i]){
				max=LesEntiers[i];
				Indice=i;
			}
		}
		return Indice;
	}
	private int[]remp=new int [longueur()+1];
	public void ajoute (int n){
		for (int i=0;i<longueur();i++){
			remp[i]=LesEntiers[i];
		}
		remp[longueur()]=n;
		LesEntiers=remp;
	}
}








