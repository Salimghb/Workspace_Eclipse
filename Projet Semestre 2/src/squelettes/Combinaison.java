package squelettes;

public class Combinaison {

	public static int[][] convertion( String [][]t){
		int[][] tab = {} ;
		for (int i=0;i<t.length;i++){
			if (t[i][0]=="1"){
				tab[i][0]=1;
			}
			if (t[i][0]=="2"){
				tab[i][0]=2;
			}
			if (t[i][0]=="3"){
				tab[i][0]=3;
			}
			if (t[i][0]=="4"){
				tab[i][0]=4;
			}
			if (t[i][0]=="5"){
				tab[i][0]=5;
			}
			if (t[i][0]=="6"){
				tab[i][0]=6;
			}
			if (t[i][0]=="7"){
				tab[i][0]=7;
			}
			if (t[i][0]=="8"){
				tab[i][0]=8;
			}
			if (t[i][0]=="9"){
				tab[i][0]=9;
			}
			if (t[i][0]=="10"){
				tab[i][0]=10;
			}
			if (t[i][0]=="11"){
				tab[i][0]=11;
			}
			if (t[i][0]=="12"){
				tab[i][0]=12;
			}
			if (t[i][0]=="13"){
				tab[i][0]=13;
			}
			if (t[i][1]=="Coeur"){
				tab[i][0]=1;
			}
			if (t[i][1]=="Carreau"){
				tab[i][0]=2;
			}
			if (t[i][1]=="Pique"){
				tab[i][0]=3;
			}
			if (t[i][1]=="Trefle"){
				tab[i][0]=4;
			}
		}
		return tab;
	}

	//QUINTE FLUSH ROYALE = QUINTE FLUSH + 10<=valeur<=13 || valeur == 1
	public static boolean QuinteFlushRoyale(String [][]t){
		int[][] tab = convertion(t);
		if (QuinteFlush (t) && Royale(tab)){
			return true;
		}
		return false;
	}
	// VERIFIE SI LES VALEURS DES CARTES SONT ROYALES
	@SuppressWarnings("unused")
	public static boolean Royale(int[][] tab) {
		TriTab(tab);
		for( int i=0;i<tab.length;i++){
			if (tab[i][0]==10 && tab[i+1][0]==11 && tab[i+2][0]==12 && tab[i+3][0]==13 && tab[i+4][0]==1);
			return true;
		}
		return false;
	}

	//QUINTE FLUSH = COULEUR+SUITE
	public static boolean QuinteFlush(String [][]t){
		int[][] tab = convertion(t);
		if (couleur(t)&&suite(tab)){
			return true;
		}
		return false;
	}

	//CARRÉ
	public static boolean carre(String [][]tab){
		int[][] t = convertion(tab);
		for( int i=0;i<t.length;i++){
			for(int j=0;j<t.length;i++){
				for(int k=0;k<t.length;k++){
					for(int l=0;l<t.length;l++){
						if (t[i][0]==t[i+j][0] && t[i+j][0]==t[i+j+k][0] && t[i+j+k][0]==t[i+j+k+l][0]){
							return true;
						}	
					}
				}
			}
		}
		return false;
	}

	//FULL = BRELAN+PAIRE???


	// COULEUR (FLUSH)
	public static boolean couleur(String [][]tab){
		int[][] t = convertion(tab);
		for( int i=0;i<t.length;i++){
			for(int j=0;j<t.length;i++){
				for(int k=0;k<t.length;k++){
					for(int l=0;l<t.length;l++){
						for(int m=0;m<t.length;m++){
							if (t[i][1]==t[i+j][1] && t[i+j][1]==t[i+j+k][1] && t[i+j+k][1]==t[i+j+k+l][1] && t[i+j+k+l][1]==t[i+j+k+l+m][1]){
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}

	// SUITE (QUINTE)
	public static boolean suite(int[][] t) {
		TriTab(t);
		for( int i=0;i<t.length;i++){
			if (t[i][1]==t[i+1][1] && t[i+1][1]==t[i+2][1] && t[i+2][1]==t[i+3][1] && t[i+3][1]==t[i+4][1]){
				return true;
			}
		}
		return false;
	}

	// BRELAN
	public static boolean brelan(String [][]t){
		for( int i=0;i<t.length;i++){
			for(int j=0;j<t.length;i++){
				for(int k=0;k<t.length;k++){
					if (t[i][0]==t[i+j][0] && t[i+j][0]==t[i+j+k][0]){
						return true;
					}	
				}
			}
		}
		return false;
	}
	// DOUBLE PAIRE???

	// PAIRE
	public static boolean paire(String [][]t){
		for( int i=0;i<t.length;i++){
			for(int j=1;j<t.length;j++){
				if (t[i][0]==t[i+j][0]){
					return true; 
				}
			}	  
		}
		return false;
	}
	// TRI D'UN TABLEAU A 2 DIMENSION???
	public static void TriTab(int t[][]) {

	}
}


